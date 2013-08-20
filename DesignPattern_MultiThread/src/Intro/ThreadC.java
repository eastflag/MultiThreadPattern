package Intro;

public class ThreadC extends Thread{

	@Override
	public void run() {
		int a = TicketMaker.getInstance().getCurrentTicketNumber();
		System.out.println("Thread C ended. ticketnumber: " + a);
		super.run();
	}

}
