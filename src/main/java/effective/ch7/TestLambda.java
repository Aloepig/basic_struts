package effective.ch7;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleBinaryOperator;

public class TestLambda {

    @Test
    public void lambdaTest() {
        double a = Operation.PLUS.getResult(2, 4);
        double b = Operation.MULTI.getResult(2, 4);
        System.out.println(a);
        System.out.println(b);
    }

    public enum Operation {
        // -> 기호와 중복되는 파라미터와 반환값 생략
        PLUS("+", Double::sum), // 메소드 레퍼런스(메소드 참조)
        MULTI("*", (x, y) -> x * y),
        ;

        private final String simbol;
        private final DoubleBinaryOperator op;

        // functionalInterface 인 DoubleBinaryOperator
        Operation(String simbol, DoubleBinaryOperator op) {
            this.simbol = simbol;
            this.op = op;
        }

        public double getResult(double a, double b) {
            return op.applyAsDouble(a, b);
        }

        @Override
        public String toString() {
            return simbol;
        }
    }
}
