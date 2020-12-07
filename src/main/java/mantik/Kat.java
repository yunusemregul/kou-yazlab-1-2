package mantik;

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

	public ArrayList<Musteri> getMusteriler()
	{
		synchronized (musteriler)
		{
			return musteriler;
		}
	}

	public void musterilereEkle(Musteri musteri)
	{
		getMusteriler().add(musteri);
	}

	public void musteriCikar(Musteri musteri)
	{
		getMusteriler().remove(musteri);
	}
}
