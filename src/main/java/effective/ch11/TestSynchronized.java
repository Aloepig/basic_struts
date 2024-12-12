package effective.ch11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSynchronized {


    public void test() {
        // synchronize block
        String a = "a";
        synchronized (a) {
            System.out.println("test");
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        // 실행자를 통한 task 사용 예시.
        ExecutorService exec = Executors.newSingleThreadExecutor(); // 실행자
        exec.execute(runnable); // run 메소드가 있는 task(작업)
        exec.shutdown(); // 종료
    }
}
