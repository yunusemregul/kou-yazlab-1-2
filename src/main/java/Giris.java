import java.util.Random;

public class Giris extends Thread
{
	private Random random = new Random();

	public void musteriGiris() throws InterruptedException
	{
		while (true)
		{
			int girecekKisiSayisi = random.nextInt(10)+1;

			Musteri[] girecekMusteriler = new Musteri[girecekKisiSayisi];

			for (int i = 0; i < girecekKisiSayisi; i++)
			{
				girecekMusteriler[i] = new Musteri(random.nextInt(4)+1);
			}

			// AVM.Kat[0].musterilerEkle(girecekMusteriler);
			// AVM sınıfı olacak, Kat sınıfı olacak
			// Kat sınıfı üstünde müşteriler diye ArrayList Musteri tanımlı olacak
			// Kat sınıfı üstünde müşterilereEkle gibi bir fonksiyon olacak o katın ArrayList müsteri sine verilen müşterileri ekleyecek

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
