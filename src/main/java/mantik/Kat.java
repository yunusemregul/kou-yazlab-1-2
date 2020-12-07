package mantik;

import java.util.ArrayList;
import java.util.LinkedList;

public class Kat
{
	private LinkedList<Musteri> musteriler;
	private LinkedList<Musteri> cikacaklar;
	public int kat;

	Kat(int kat)
	{
		this.musteriler = new LinkedList<>();
		this.cikacaklar = new LinkedList<>();
		this.kat = kat;
	}

	public LinkedList<Musteri> getMusteriler()
	{
		synchronized (musteriler)
		{
			return musteriler;
		}
	}

	public LinkedList<Musteri> getCikacaklar()
	{
		synchronized (cikacaklar)
		{
			return cikacaklar;
		}
	}

	public void cikacaklaraEkle(Musteri musteri)
	{
		getCikacaklar().push(musteri);
	}

	public void musterilereEkle(Musteri musteri)
	{
		getMusteriler().push(musteri);
	}
}
