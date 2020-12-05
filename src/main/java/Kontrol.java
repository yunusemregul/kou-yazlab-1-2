public class Kontrol extends Thread
{
	public void kontrolEt()
	{
		int bekleyenKisiSayisi = 0;

		for (int i = 0; i < 5; i++)
		{
			if (i==0) // zemin
			{
				bekleyenKisiSayisi += AVM.katlar[0].musteriler.size();
			}
			else
			{
				for (Musteri musteri:AVM.katlar[i].musteriler)
				{
					if (musteri.cikiyormu)
					{
						bekleyenKisiSayisi += 1;
					}
				}
			}
		}

		int aktifAsansorSayisi = 0;

		for (Asansor asansor:AVM.asansorler)
		{
			if (asansor.isAlive())
			{
				aktifAsansorSayisi += 1;
			}
		}

		// asansör gerekiyorsa
		if (bekleyenKisiSayisi > aktifAsansorSayisi * 10 * 2)
		{
			for (Asansor asansor:AVM.asansorler)
			{
				if (!asansor.calisiyor)
				{
					asansor.start();
				}
				break;
			}
		}
		else if(bekleyenKisiSayisi < aktifAsansorSayisi * 10 * 2) // gereksiz asansör varsa
		{
			for (Asansor asansor:AVM.asansorler)
			{
				if (asansor.calisiyor)
				{
					asansor.durdur();
				}
				break;
			}
		}
	}

	@Override
	public void run()
	{
		while (true)
		{
			kontrolEt();
		}
	}
}
