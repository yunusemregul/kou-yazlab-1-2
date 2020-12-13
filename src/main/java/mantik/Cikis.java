package mantik;

import java.util.ArrayList;
import java.util.Random;

public class Cikis extends Thread
{
	private Random random = new Random();


	public void musteriCikis() throws InterruptedException
	{
		int cikacakKisiSayisi = random.nextInt(5) + 1;

		synchronized (AVM.katlar)
		{
			ArrayList<Integer> musteriOlanKatlar = new ArrayList<>();

			for (int i = 1; i < AVM.katlar.length; i++)
			{
				Kat kat = AVM.katlar[i];

				if (kat.getMusteriler().size()>0)
				{
					musteriOlanKatlar.add(i);
				}
			}

			if (musteriOlanKatlar.size()==0)
				return;

			int hangiKattan = musteriOlanKatlar.get(random.nextInt(musteriOlanKatlar.size()));

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
