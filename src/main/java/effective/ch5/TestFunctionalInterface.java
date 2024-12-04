package effective.ch5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

public class TestFunctionalInterface {

    @Test
    public void unaryTest() {
        // 구현한 메소드
        UnaryOperator<String> objectUnaryOperator = identityFunction();
        // identity api 사용
        UnaryOperator<String> unaryOperator = UnaryOperator.identity();

        Assertions.assertEquals("1a", objectUnaryOperator.apply("1a"));
        Assertions.assertEquals("string", unaryOperator.apply("string"));

        //  UnaryOperator<Object> 로 선언한 것
        Assertions.assertEquals(1, IDENTITY.apply(1));
    }

    // 메모리 절약을 위한 final 선언(상수화)
    private static final UnaryOperator<Object> IDENTITY = x12 -> x12; //apply 메소드 구현

    // 직접 identity 메소드를 구현함.
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY;
    }
}
