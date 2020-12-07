import java.util.ArrayList;

public class Kat
{
	public ArrayList<Musteri> musteriler;
	public int kat;

	Kat(int kat)
	{
		this.musteriler = new ArrayList<Musteri>();
		this.kat = kat;
	}

	public synchronized void musterilereEkle(Musteri musteri)
	{
		musteriler.add(musteri);
		System.out.printf(String.format("%d. kata %d müşteri girdi:"));
	}

	public synchronized void musteriCikar(Musteri musteri)
	{
		musteriler.remove(musteri);
	}
}
