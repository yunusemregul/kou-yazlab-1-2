package mantik;

import java.util.ArrayList;

public class Kat
{
	public ArrayList<Musteri> musteriler;
	public ArrayList<Musteri> cikacaklar;
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
	public ArrayList<Musteri> getCikacaklar()
	{
		synchronized (cikacaklar)
		{
			return cikacaklar;
		}
	}

	public void cikacaklaraEkle(Musteri musteri) {
		getCikacaklar().add(musteri);
	}

	public void musterilereEkle(Musteri musteri)
	{
		getMusteriler().add(musteri);
	}

}
