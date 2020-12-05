import java.util.ArrayList;

public class Kat
{
	public ArrayList<Musteri> musteriler;

	Kat()
	{
		this.musteriler = new ArrayList<Musteri>();
	}

	public synchronized void musterilereEkle(Musteri musteri)
	{
		musteriler.add(musteri);
	}
}
