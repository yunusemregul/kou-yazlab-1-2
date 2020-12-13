package mantik;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Asansor extends Thread
{
	private final ArrayList<Musteri> musteriler;
	public int olduguKat;
	public volatile boolean calisiyor;
	public int hedefKat;
	public boolean duruyorMu;

	Asansor()
	{
		musteriler = new ArrayList<>();
		duruyorMu = false;
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
		duruyorMu = true;
		while (true)
		{
			if (this.getMusteriler().size() < 1)
			{
				break;
			}
		}
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
			ArrayList<Musteri> kataBirakilacaklar = new ArrayList<>();

			// asansöre yolcu alınıyor
			if (!this.duruyorMu)
			{
				while (getMusteriler().size() < 10 && AVM.katlar[olduguKat].getCikacaklar().size() > 0)
				{
					getMusteriler().add(AVM.katlar[olduguKat].getCikacaklar().pop());
				}
			}

			// asansörde olan müşterileri bu katta ineceklerse bırakıyor
			for (Musteri musteri : getMusteriler())
			{
				if (musteri.hedefKat == 0 && olduguKat == 0)
				{
					kataBirakilacaklar.add(musteri);
					continue;
				}

				if (musteri.hedefKat == olduguKat)
				{
					AVM.katlar[olduguKat].musterilereEkle(musteri);
					kataBirakilacaklar.add(musteri);
				}
			}

			for (Musteri musteri : kataBirakilacaklar)
			{
				musteriler.remove(musteri);
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
