public class Main
{
	public static void main(String[] args)
	{
		AVM avm;
		avm = new AVM();

		Giris girisThread = new Giris();
		girisThread.start();

		Kontrol kontrolThread = new Kontrol();
		kontrolThread.start();
	}
}
