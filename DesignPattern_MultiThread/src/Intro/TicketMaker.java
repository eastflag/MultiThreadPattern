package Intro;

class TicketMaker {
	
	private static TicketMaker singleton;
	private int ticket = 1000;
	
	private TicketMaker(){
		
	}
	
	public static synchronized TicketMaker getInstance(){
		if(singleton == null){
			singleton = new TicketMaker();
		}
		return singleton;
	}
	
	public synchronized int getNextTicketNumber(){
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ++ticket;
	}
	
	public synchronized int getCurrentTicketNumber(){
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ticket;
	}
}
