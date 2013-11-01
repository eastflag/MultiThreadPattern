package Thread_Per_Message.A7_7a;
public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");  // �����ɂ͂��Ȃ�
        }
    }

    public static void magic(final Object obj) {
        // thread는 obj의 락을 취하고 무한 루프하는 쓰레드
        // thread의 이름을 가드 조건으로 사용한다
        Thread thread = new Thread() { // inner class
            public void run() {
                synchronized (obj) { // 여기에서 obj의 락을 취한다
                    synchronized (this) {
                        this.setName("Locked"); // 가드 조건의 변화
                        this.notifyAll(); // obj의 락을 취했음을 통보
                    }
                    while (true) {
                        // 무한 루프
                    }
                }
            }
        };
        
        synchronized (thread) {
            thread.setName("");
            thread.start(); // 쓰레드의 기동
            // Guarded Suspension 패턴
            while (thread.getName().equals("")) {
                try {
                    thread.wait(); // 새로운 쓰레드가 obj의 락을 취하기를 기다린다
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
