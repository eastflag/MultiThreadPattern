package Intro;

class TicketMaker {
	
	private static TicketMaker singleton;
	private int ticket = 1000;
	
	private TicketMaker(){
		
	}
	
	public static synchronized TicketMaker getInstance(){
		if(singleton == null){
			System.out.println("TicketMaker null");
			singleton = new TicketMaker();
		}
		return singleton;
	}
	
	public synchronized int getNextTicketNumber(){
		System.out.println("getNextTicketNumber start: " + ticket);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ++ticket;
	}
	
	public synchronized int getCurrentTicketNumber(){
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ticket;
	}
}
