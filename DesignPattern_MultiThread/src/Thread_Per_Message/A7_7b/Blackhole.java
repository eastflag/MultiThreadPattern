package Thread_Per_Message.A7_7b;
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
        // thread�́Aobj�̃��b�N������Ă��玩�����g�̏I�����i���ɑ҂X���b�h
        Thread thread = new Thread() {
            public void run() {
                synchronized (obj) {        // ������obj�̃��b�N�����
                    synchronized (this) {
                        this.notifyAll();   // obj�̃��b�N����������Ƃ�ʒm
                    }
                    try {
                        this.join(); // �i���ɑ҂��ƂɂȂ�
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        synchronized (thread) {
            thread.start();     // �X���b�h�̋N��
            try {
                thread.wait();  // �V�����X���b�h��obj�̃��b�N�����̂�҂�
            } catch (InterruptedException e) {
            }
        }
    }
}
