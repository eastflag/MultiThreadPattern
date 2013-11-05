package Future.jucSample;
import java.util.concurrent.Callable;

public class Host {
    public FutureData request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) FutureData 의 인스턴스 생성
        //     생성자에게 Callable<RealData> 를 건넨다
        FutureData future = new FutureData(
            new Callable<RealData>() {
                public RealData call() {
                    return new RealData(count, c);
                }
            }
        );

        // (2) RealData를 만들기 위한 새로운 쓰레드를 기동한다.
        new Thread(future).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) FutureData를 만들기 위한 새로운 쓰레드를 기동한다.
        return future;
    }
}
