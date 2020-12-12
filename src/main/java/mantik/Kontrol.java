package mantik;

public class Kontrol extends Thread
{
	public void kontrolEt() throws InterruptedException {
		int bekleyenKisiSayisi = 0;

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
			if (bekleyenKisiSayisi > 20) // aktifAsansorSayisi * 10 * 2
			{
				for (int i = 1; i < AVM.asansorler.length; i++)
				{
					Asansor asansor = AVM.asansorler[i];
					if (!asansor.isAlive() && !asansor.calisiyor)
					{
						AVM.asansorler[i] = new Asansor();
						AVM.asansorler[i].start();
						sleep(2000);
						break;
					}
				}
			}
			else if (bekleyenKisiSayisi < 10) // if(bekleyenKisiSayisi <= 20) // gereksiz asansör varsa (aktifAsansorSayisi - 1) * 10 * 2
			{
				for (Asansor asansor : AVM.asansorler)
				{
					if (asansor.isAlive() && asansor.calisiyor && asansor != AVM.asansorler[0])
					{
						// TODO: durmadan önce içindekileri indir istedikleri kata
								asansor.durdur();
							sleep(1000);
						break;
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
			try {
				kontrolEt();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
