package effective.ch11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestConcurrent {

    @Test
    @DisplayName("동시 실행 시간을 재는 프레임워크 예시")
    public void concurrentTest() throws InterruptedException {
        int threadCount = 2;
        // Executor executor = Executors.newSingleThreadExecutor(); // 스레드가 1개이므로 concurrency 를 2로 하면 무한 대기됨
        Executor executor = Executors.newFixedThreadPool(threadCount);
        long l = time(executor, threadCount, () -> {
            System.out.println("run");
        });

        System.out.println(l);
    }

    long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // 준비 마침알림
                ready.countDown();
                try {
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // 작업 마침을 알림
                    done.countDown();
                }
            });
        }
        ready.await();
        long begin = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - begin;
    }
}
