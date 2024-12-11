package effective.ch9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestLibrary {

    static Random rnd = new Random();

    @DisplayName("Math.abs 의 결함. ")
    @Test
    public void mathAbsTest() {
        int min = Integer.MIN_VALUE;
        int fixed = 2 * (Integer.MAX_VALUE / 3);
        System.out.println(Integer.MIN_VALUE % fixed);
        System.out.println(Integer.MAX_VALUE % fixed);
        System.out.println(fixed / 2);
        Assertions.assertEquals(min, Math.abs(min));
    }

    @Test
    @DisplayName("Random 직접구현과 표준 API 차이")
    public void randomTest() {
        int low1 = 0;
        int low2 = 0;
        int n = 2 * (Integer.MAX_VALUE / 3);
        for (int i = 0; i < 1000000; i++) {
            if (oldRandom(n) < n / 2) low1++;
            if (random(n) < n / 2) low2++;
        }
        System.out.println(low1); // n값에 따라 치우치는 결과
        System.out.println(low2);
    }

    // 직접만든 랜덤 숫자 함수
    private int oldRandom(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    // API에 정의된 랜덤 숫자 함수
    private int random(int n) {
        return rnd.nextInt(n);
    }
}
