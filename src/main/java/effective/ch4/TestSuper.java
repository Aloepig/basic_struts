package effective.ch4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class TestSuper {

    @Test
    @DisplayName("생성자가 재정의 메서드를 호출하면 의도와 다르게 동작하는 예제")
    public void SuperTest() {
        Super sub = new Sub();
        sub.overrideMe();
    }


}

class Super {
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}

class Sub extends Super {
    private final Instant instant; // final임에도 실행시 상태가 두가지(null, 시간) 를 가짐.

    public Sub() {
        instant = Instant.now();
    }

    // 상위클래스의 생성자가 먼저 실행됨.
    public void overrideMe() {
        System.out.println(instant);
    }

}
