import java.util.ArrayList;

public class Asansor extends Thread
{
	private ArrayList<Musteri> musteriler;
	private int olduguKat;
	public volatile boolean calisiyor;
	private int asansordekiMusteriSayisi;
	Asansor()
	{
		olduguKat = 0;
		asansordekiMusteriSayisi =0;
	}

	public synchronized int gidilecekKatBelirle()
	{
		while(asansordekiMusteriSayisi <= 10){
				for(int i=0; i<AVM.katlar[olduguKat].musteriler.size(); i++){
					musteriler.add(AVM.katlar[olduguKat].musteriler.get(i));
					AVM.katlar[olduguKat].musteriCikar(AVM.katlar[olduguKat].musteriler.get(i));
					asansordekiMusteriSayisi++;
				}
		}
		return 0; // TODO
	}

	public void durdur()
	{
		calisiyor = false;
	}

	@Override
	public void run()
	{
		calisiyor = true;

		while (calisiyor)
		{
			/* TODO: olduğu kattan müşteri alacak, gidilecek katı belirleyecek */
		}
	}
}
