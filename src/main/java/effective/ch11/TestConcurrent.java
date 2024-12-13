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
        // 스레드 기아 교착상태 thread starvation deadlock 이라 함.
        Executor executor = Executors.newFixedThreadPool(threadCount);
        long nanosecond = time(executor, threadCount, () -> {
            System.out.println("run");
        });

        System.out.println(nanosecond);
    }

    /**
     * Measures the time taken for a concurrent action to complete with a specified number of threads.
     *
     * @param executor the {@link Executor} used to manage threads that execute the action
     * @param concurrency the number of threads to execute the action in parallel
     * @param action the task to be executed by each thread
     * @return the time taken in nanoseconds for all threads to complete the action
     * @throws InterruptedException if the current thread is interrupted while waiting for threads to complete
     */
    long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // 스레드 준비 완료 표시
                try {
                    start.await(); // 시작 신호 대기
                    action.run(); // 지정된 작업 실행
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 스레드 인터럽트 처리
                } finally {
                    done.countDown(); // 작업 완료 알림
                }
            });
        }
        ready.await(); // 1. ready latch 가 0이 되면 다음코드 실행
        long begin = System.nanoTime();
        start.countDown(); // 2. 모든 스레드의 start.await() 블락 해제
        done.await(); // 3. done latch 가 0이 되면 다음코드 실행.
        return System.nanoTime() - begin;
    }
}
