import java.util.Random;

public class Cikis extends Thread
{
    private Random random = new Random();

    public void musteriCikis() throws InterruptedException {
        int cikacakKisiSayisi = random.nextInt(5)+1;
        int hangiKattan = random.nextInt(4)+1;

        for (int i = 0; i < cikacakKisiSayisi; i++)
        {
            AVM.katlar[hangiKattan].musteriler.get(i).cikiyormu = true;
        }
        sleep(1000);
    }

    public void run()
    {
        while (true)
        {
            try {
                musteriCikis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
