package mantik;

public class AVM
{
	public final static Kat[] katlar = new Kat[5]; // uygulama genelinde 1 tane mantik.AVM olacağı için statik
	public final static Asansor[] asansorler = new Asansor[5];

	AVM()
	{
		for (int i = 0; i < 5; i++)
		{
			katlar[i] = new Kat(i);
		}
		for (int i = 0; i < 5; i++)
		{
			asansorler[i] = new Asansor();
		}

		asansorler[0].start();
	}
}
