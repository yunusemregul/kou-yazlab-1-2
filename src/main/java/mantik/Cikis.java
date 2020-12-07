package mantik;

import java.util.Random;

public class Cikis extends Thread
{
	private Random random = new Random();

	public void musteriCikis() throws InterruptedException
	{
		int cikacakKisiSayisi = random.nextInt(5) + 1;
		int hangiKattan = random.nextInt(4) + 1;

		while (AVM.katlar[hangiKattan].musteriler.size()>0 && cikacakKisiSayisi > 0)
		{
			synchronized (AVM.katlar)
			{
				AVM.katlar[hangiKattan].getMusteriler().get(0).cikart();
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
