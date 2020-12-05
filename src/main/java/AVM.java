public class AVM
{
	public static Kat[] katlar; // uygulama genelinde 1 tane AVM olacağı için statik
	public static Asansor[] asansorler;

	AVM()
	{
		this.katlar = new Kat[5]; // 0 1 2 3 4
		asansorler = new Asansor[5];
		for (int i = 0; i < 5; i++)
		{
			this.katlar[i] = new Kat();
		}
		for (int i = 0; i < 5; i++)
		{
			this.asansorler[i] = new Asansor();
		}
	}
}
