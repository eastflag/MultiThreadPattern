package SingleThreadedExecution.Q1_7;

public class Mutex {
    private volatile boolean mIsBusy = false;
    
    public synchronized void lock(){
        while(mIsBusy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mIsBusy = true;
    }
    
    public synchronized void unlock(){
        mIsBusy = false;
    }
}
