package mantik;

import java.util.Random;

public class Cikis extends Thread
{
	private Random random = new Random();
	private Musteri temp;

	public void musteriCikis() throws InterruptedException
	{
		int cikacakKisiSayisi = random.nextInt(5) + 1;
		int hangiKattan = random.nextInt(4) + 1;

		while (AVM.katlar[hangiKattan].musteriler.size()>0 && cikacakKisiSayisi > 0)
		{
			synchronized (AVM.katlar)
			{
				temp = AVM.katlar[hangiKattan].getMusteriler().get(0);
				temp.hedefKat =0;
				AVM.katlar[hangiKattan].getMusteriler().remove(0);
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
