package Intro;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}

}
