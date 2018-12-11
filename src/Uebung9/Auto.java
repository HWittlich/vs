package Uebung9;

public class Auto implements Runnable {
	
	public static int anzahl = 0;
	private int nummer;
	
	public Auto () {
		nummer = anzahl;
		anzahl++;
	}

	@Override
	public void run() {
		try {
			Parkhaus.einparken(nummer);
			Thread.sleep(5);
			Parkhaus.ausparken(nummer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
