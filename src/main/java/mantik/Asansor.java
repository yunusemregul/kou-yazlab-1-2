package mantik;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Asansor extends Thread
{
	private ArrayList<Musteri> musteriler;
	public int olduguKat;
	public volatile boolean calisiyor;
	public int hedefKat;

	Asansor()
	{
		musteriler = new ArrayList<>();
		olduguKat = 0;
	}

	public int gidilecekKatBelirle()
	{
		int hedefKat = 0;

		if (this.olduguKat == 0)
			hedefKat = 4;
		else if (this.olduguKat == 4)
			hedefKat = 0;

		return hedefKat;
	}

	public void durdur()
	{
		calisiyor = false;
	}

	public ArrayList<Musteri> getMusteriler()
	{
		synchronized (musteriler)
		{
			return musteriler;
		}
	}

	public void indiBindi()
	{
		synchronized (AVM.katlar)
		{
			ArrayList<Musteri> cikartilacaklar = new ArrayList<>();
			// asansörde olan müşterileri bu katta ineceklerse bırakıyor
			for (Musteri musteri : getMusteriler())
			{
				if (musteri.hedefKat == olduguKat)
				{
					AVM.katlar[olduguKat].musterilereEkle(musteri);
					cikartilacaklar.add(musteri);
				}
			}

			for (Musteri musteri:cikartilacaklar)
			{
				musteriler.remove(musteri);
			}

			if (hedefKat != 4 || olduguKat == 0)
			{
				// olduğu kattaki müşterileri asansöre alıyor
				while (getMusteriler().size() < 10 && (AVM.katlar[olduguKat].musteriler.stream().anyMatch(musteri -> musteri.cikiyormu) || (olduguKat==0 && AVM.katlar[0].getMusteriler().size()>0)))
				{
					cikartilacaklar = new ArrayList<>();

					for (Musteri musteri : AVM.katlar[olduguKat].musteriler)
					{
						if (olduguKat == 0)
						{
							getMusteriler().add(musteri);
							cikartilacaklar.add(musteri);
							break;
						}
						else
						{
							if (musteri.cikiyormu)
							{
								getMusteriler().add(musteri);
								cikartilacaklar.add(musteri);
								break;
							}
						}
					}

					for (Musteri musteri:cikartilacaklar)
					{
						AVM.katlar[olduguKat].musteriler.remove(musteri);
					}
				}
			}
		}
	}

	public void yukariCik()
	{
		this.olduguKat += 1;
		indiBindi();
	}

	public void asagiIn()
	{
		this.olduguKat -= 1;
		indiBindi();
	}

	public void calis() throws InterruptedException
	{
		hedefKat = gidilecekKatBelirle();

		while (this.olduguKat != hedefKat)
		{
			sleep(200);
			if (hedefKat - olduguKat > 0)
			{
				yukariCik();
			}
			else
			{
				asagiIn();
			}
		}
	}

	@Override
	public void run()
	{
		calisiyor = true;

		while (calisiyor)
		{
			try
			{
				calis();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
