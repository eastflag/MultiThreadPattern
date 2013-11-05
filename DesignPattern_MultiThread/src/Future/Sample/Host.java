package Future.Sample;
public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) FutureData의 인스턴스를 만든다.
        final FutureData future = new FutureData();

        // (2) RealData 의 인스턴스를 만들기 위한 새로운 쓰레드를 기동한다.
        new Thread() {
            public void run() {
                RealData realdata = new RealData(count, c);
                future.setRealData(realdata);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) FutureData 의 인스턴스를 반환값으로 한다.
        return future;
    }
}
