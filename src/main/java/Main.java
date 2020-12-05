/*
	AVM.Kat[0].musterilerEkle(girecekMusteriler);
	AVM sınıfı olacak, Kat sınıfı olacak
	Kat sınıfı üstünde müşteriler diye ArrayList Musteri tanımlı olacak
	Kat sınıfı üstünde müşterilereEkle gibi bir fonksiyon olacak o katın ArrayList müsteri sine verilen müşterileri ekleyecek
 */

public class Main
{
	public static void main(String[] args)
	{
		new AVM();

		Giris girisThread = new Giris();
		girisThread.start();

		Kontrol kontrolThread = new Kontrol();
		kontrolThread.start();
	}
}
