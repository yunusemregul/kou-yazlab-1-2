package mantik;

public class Kontrol extends Thread
{
	public void kontrolEt() throws InterruptedException
	{
		int bekleyenKisiSayisi = 0;
		int sonKatlar[] = new int[AVM.asansorler.length];

		synchronized (AVM.katlar)
		{
			for (int i = 0; i < 5; i++)
			{
				bekleyenKisiSayisi += AVM.katlar[i].getCikacaklar().size();
			}
		}

		synchronized (AVM.asansorler)
		{
			int aktifAsansorSayisi = 0;

			for (Asansor asansor : AVM.asansorler)
			{
				if (asansor.calisiyor)
				{
					aktifAsansorSayisi += 1;
				}
			}

			// asansör gerekiyorsa
			if (bekleyenKisiSayisi > 20)
			{
				for (int i = 1; i < AVM.asansorler.length; i++)
				{
					Asansor asansor = AVM.asansorler[i];
					if (!asansor.isAlive() && !asansor.calisiyor)
					{
						AVM.asansorler[i] = new Asansor();
						AVM.asansorler[i].olduguKat = sonKatlar[i];
						AVM.asansorler[i].start();
						sleep(2000);
						return;
					}
				}
			}
			else if (bekleyenKisiSayisi < 10) // gereksiz asansör varsa
			{
				Asansor[] asansorler = AVM.asansorler;
				for (int i = 0; i < asansorler.length; i++)
				{
					Asansor asansor = asansorler[i];
					if (asansor.isAlive() && asansor.calisiyor && asansor != AVM.asansorler[0])
					{
						sonKatlar[i] = asansor.olduguKat;
						asansor.durdur();
						sleep(2000);
						return;
					}
				}
			}
		}
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				kontrolEt();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
