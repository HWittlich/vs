package Uebung9;


public class Parkhaus {

	public static int parkplaetze = 50;

	public static Object lock = new Object();

	public static void einparken(int nummer) {
		synchronized (lock) {
			try {
				while (parkplaetze <= 0) {
					System.out.println("Alle Parkpl�tze belegt. Auto " + nummer + " wartet auf einen Parkplatz.");
					lock.wait();
				}
				parkplaetze-=1;
				System.out.println("Auto " + nummer + " ist eingefahren");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

	public static void ausparken(int nummer) {
		synchronized (lock) {
			parkplaetze+=1;
			System.out.println("Auto " + nummer + " ist ausgefahren");
			if(parkplaetze==50) {System.out.println("Parkhaus ist leer (50 Pl�tze frei) .");}
			lock.notifyAll();
		}
	}

}
