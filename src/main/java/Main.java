/*
	AVM.Kat[0].musterilerEkle(girecekMusteriler);
	AVM sınıfı olacak, Kat sınıfı olacak
	Kat sınıfı üstünde müşteriler diye ArrayList Musteri tanımlı olacak
	Kat sınıfı üstünde müşterilereEkle gibi bir fonksiyon olacak o katın ArrayList müsteri sine verilen müşterileri ekleyecek

	TODO:
		Giris threadı her belirlenen aralıkta AVM.katlar[0] a projede belirlendiği gibi müşteri ekleyecek.
			AVM.katlar[0].musteriEkle(Musteri musteri)
		kullanılacak
 */

public class Main
{
	public static void main(String[] args)
	{
		Giris girisThread = new Giris();
		girisThread.run();
		AVM avm = new AVM();
	}
}
