package ThreadSpecific.Sample2;
public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    // ���O������
    public static void println(String s) {
        getTSLog().println(s);
    }

    // ���O�����
    public static void close() {
        getTSLog().close();
    }

    // �X���b�h�ŗL�̃��O�𓾂�
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        // ���̃X���b�h����̌Ăяo�����͂��߂ĂȂ�A�V�K�쐬���ēo�^����
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
