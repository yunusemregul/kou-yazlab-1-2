package mantik;

import java.util.Random;

public class Giris extends Thread
{
	private Random random = new Random();

	public void musteriGiris() throws InterruptedException
	{
		int girecekKisiSayisi = random.nextInt(10) + 1;
		int hedefKat = random.nextInt(4) + 1;

		synchronized (AVM.katlar)
		{
			for (int i = 0; i < girecekKisiSayisi; i++)
			{
				Musteri musteri = new Musteri(hedefKat);
				AVM.katlar[0].cikacaklaraEkle(musteri);
			}
		}
		sleep(500);
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				musteriGiris();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
