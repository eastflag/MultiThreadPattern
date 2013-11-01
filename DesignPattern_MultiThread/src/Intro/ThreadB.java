package Intro;

public class ThreadB extends Thread{

	@Override
	public void run() {
		int a =TicketMaker.getInstance().getCurrentTicketNumber();
		System.out.println("Thread B ended. ticketnumber: " + a);
		super.run();
	}

}
