package effective.ch6;

import org.junit.jupiter.api.Test;

public class TestEnum {

    @Test
    public void enumTest() {
        for (Operation op : Operation.values()) {
            System.out.printf("%s %s %s = %s%n", 2, op, 4, op.apply(2, 4));
        }

        PayrollDay.MONDAY.pay(1,2);
    }

    private enum Operation {
        PLUS("+") {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        },
        MINUS("-") {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        },
        TIMES("*") {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };

        private final String symbol;

        Operation(String s) {
            symbol = s;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public abstract int apply(int a, int b);
    }

    enum PayrollDay{
        MONDAY(PayType.WEEKDAY),
        TUESDAY(PayType.WEEKDAY),
        SATURDAY(PayType.WEEKEND),;

        private final PayType payType;

        PayrollDay(PayType payType) {
            this.payType = payType;
        }

        int pay(int a, int b) {
            return payType.apply(a , b);
        }

        enum PayType{
            WEEKEND {
                @Override
                int apply(int a, int b) {
                    return a * b /2;
                }
            }, WEEKDAY {
                @Override
                int apply(int a, int b) {
                    return a * b /3;
                }
            };

            abstract int apply(int a, int b);
        }
    }
}
