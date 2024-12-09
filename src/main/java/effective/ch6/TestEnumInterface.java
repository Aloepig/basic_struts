package effective.ch6;

import org.junit.jupiter.api.Test;

public class TestEnumInterface {

    @Test
    public void enumInterface() {
        test(ExtendedOperation.class, 4, 2);
    }

    private <T extends Enum<T> & Operation2> void test(Class<T> t, double a, double b) {
        // 위 문법이 생소해서 Operation2 op 가 enum 인것이 이상한가?
        // T 는 Operation2 를 구현(상속)했으므로, T에 속한 각 enum 상수도 Operation2 의 인스턴스다.
        // T op : t.getEnumConstants() 로 작성해도 됨. 상속했으므로 상위 객체로 캐스팅 가능함.
        // 실제는 enum 객체지만 Operation2 객체이기도 하므로 Operation2로 Boxing 한 것.
        // 고양이는 동물이다. 동물 a = 고양이. 와 동일.
        for (Operation2 op : t.getEnumConstants()) {
            System.out.printf("%f %s %f %s%n", a, op, b, op.apply(a, b));
        }
    }

    interface Operation2 {
        double apply(double a, double b);
    }

    enum BasicOperation implements Operation2 {
        PLUS {
            public double apply(double a, double b) {
                return a + b;
            }
        }, MINUS {
            @Override
            public double apply(double a, double b) {
                return a - b;
            }
        }
    }

    enum ExtendedOperation implements Operation2 {
        EXP {
            @Override
            public double apply(double a, double b) {
                return Math.pow(a, b);
            }
        },
        REMAINDER {
            @Override
            public double apply(double a, double b) {
                return a % b;
            }
        }
    }
}
