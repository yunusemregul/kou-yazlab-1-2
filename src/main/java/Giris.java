import java.util.Random;

public class Giris extends Thread
{
	private Random random = new Random();

	public void musteriGiris() throws InterruptedException
	{
		while (true)
		{
			int girecekKisiSayisi = random.nextInt(10)+1;
			int hedefKat = random.nextInt(4)+1;
			synchronized (AVM.katlar){
				for (int i = 0; i < girecekKisiSayisi; i++)
				{
					AVM.katlar[0].musterilereEkle(new Musteri(hedefKat));
				}
			}
			sleep(500);
		}
	}
	@Override
	public void run()
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
