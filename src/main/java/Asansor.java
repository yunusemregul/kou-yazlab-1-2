import java.util.ArrayList;

public class Asansor extends Thread
{
	private ArrayList<Musteri> musteriler;
	private int olduguKat;
	public volatile boolean calisiyor;

	Asansor()
	{
		olduguKat = 0;
	}

	public synchronized int gidilecekKatBelirle()
	{

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
