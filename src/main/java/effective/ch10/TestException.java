package effective.ch10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class TestException {

    @Test
    @DisplayName("자주 사용하는 비검사 예외 6개")
    public void exceptionText() {
        ee();
    }

    public void ee() {

        int exceptionTrigger = ThreadLocalRandom.current().nextInt(6);

        switch (exceptionTrigger) {
            case 0:
                throw new IllegalStateException("0");
            case 1:
                throw new NullPointerException("1");
            case 2:
                throw new IllegalArgumentException("2");
            case 3:
                throw new IndexOutOfBoundsException("3");
            case 4:
                throw new ConcurrentModificationException("4");
            case 5:
                throw new UnsupportedOperationException("5");
            default:
                throw new RuntimeException("d");
        }

    }

}
