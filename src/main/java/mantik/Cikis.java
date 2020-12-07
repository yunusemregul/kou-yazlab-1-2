package mantik;

import java.util.Random;

public class Cikis extends Thread
{
	private Random random = new Random();


	public void musteriCikis() throws InterruptedException
	{
		int cikacakKisiSayisi = random.nextInt(5) + 1;
		int hangiKattan = random.nextInt(4) + 1;

		synchronized (AVM.katlar)
		{
			while (AVM.katlar[hangiKattan].getMusteriler().size() > 0 && cikacakKisiSayisi > 0)
			{
				Musteri temp = AVM.katlar[hangiKattan].getMusteriler().pop();
				temp.hedefKat = 0;
				AVM.katlar[hangiKattan].cikacaklaraEkle(temp);
				cikacakKisiSayisi--;
			}
		}
		sleep(1000);
	}

	public void run()
	{
		while (true)
		{
			try
			{
				musteriCikis();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
