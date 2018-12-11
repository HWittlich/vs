package Uebung9;

public class Main {

	public static void main(String[] args) {
		for (int i=0; i<=200;i++) {
			Auto auto = new Auto();
			Thread t = new Thread (auto);
			t.start();
		}
	}

}
