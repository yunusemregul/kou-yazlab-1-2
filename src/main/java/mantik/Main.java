package mantik;

import arayuz.Arayuz;

public class Main
{
	public static void main(String[] args)
	{
		new AVM();

		Giris girisThread = new Giris();
		girisThread.start();

		Cikis cikisThread = new Cikis();
		cikisThread.start();

		Kontrol kontrolThread = new Kontrol();
		kontrolThread.start();

		new Arayuz();
	}
}
