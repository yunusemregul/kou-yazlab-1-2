import java.util.ArrayList;

public class Asansor extends Thread
{
	private ArrayList<Musteri> musteriler;
	private int olduguKat;
	public volatile boolean calisiyor;

	Asansor()
	{
		musteriler = new ArrayList<>();
		olduguKat = 0;
	}

	public synchronized int gidilecekKatBelirle()
	{
		int enUzaklik = 0;
		int enUzakKat = olduguKat;

		for (Musteri musteri : musteriler)
		{
			int katUzakligi = Math.abs(musteri.hedefKat - olduguKat);

			if (katUzakligi > enUzaklik)
			{
				enUzaklik = katUzakligi;
				enUzakKat = musteri.hedefKat;
			}
		}

		return enUzakKat;
	}

	public void durdur()
	{
		calisiyor = false;
	}

	public synchronized void indiBindi()
	{
		// asansörde olan müşterileri bu katta ineceklerse bırakıyor
		for (Musteri musteri : musteriler)
		{
			if (musteri.hedefKat == olduguKat)
			{
				AVM.katlar[olduguKat].musterilereEkle(musteri);
				musteriler.remove(musteri);
			}
		}

		// olduğu kattaki müşterileri asansöre alıyor
		while (musteriler.size() <= 10)
		{
			for (Musteri musteri : AVM.katlar[olduguKat].musteriler)
			{
				if (olduguKat == 0)
				{
					musteriler.add(musteri);
					AVM.katlar[olduguKat].musteriCikar(musteri);
					break;
				}
				else
				{
					if (musteri.cikiyormu)
					{
						musteriler.add(musteri);
						AVM.katlar[olduguKat].musteriCikar(musteri);
						break;
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

	public synchronized void calis()
	{
		int hedef = gidilecekKatBelirle();

		while (this.olduguKat != hedef)
		{
			if (hedef - olduguKat > 0)
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
			calis();
		}
	}
}
