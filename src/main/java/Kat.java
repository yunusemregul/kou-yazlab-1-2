import java.util.ArrayList;

public class Kat
{
	public ArrayList<Musteri> musteriler;

	Kat()
	{
		this.musteriler = new ArrayList<Musteri>();
	}

	public void musterilereEkle(Musteri musteri)
	{
		musteriler.add(musteri);
	}
}
