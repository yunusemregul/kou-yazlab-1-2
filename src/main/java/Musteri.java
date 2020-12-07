public class Musteri
{
	public int hedefKat;
	public boolean cikiyormu;

	public Musteri(int hedefKat)
	{
		this.hedefKat = hedefKat;
		this.cikiyormu = false;
	}

	public void cikart()
	{
		cikiyormu = true;
		hedefKat = 0;
	}
}
