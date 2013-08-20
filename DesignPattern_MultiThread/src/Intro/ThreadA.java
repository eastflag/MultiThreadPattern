package Intro;

public class ThreadA extends Thread{

	@Override
	public void run() {
		int a = TicketMaker.getInstance().getNextTicketNumber();
		System.out.println("Thread A ended. ticketnumber: " + a);
		super.run();
	}

}
