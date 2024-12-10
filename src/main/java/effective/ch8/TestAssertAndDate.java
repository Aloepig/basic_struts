package effective.ch8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

public class TestAssertAndDate {

    @Test
    @DisplayName("null 검사 방법")
    public void assertTest() {
        BigInteger a = BigInteger.valueOf(123);
        mod( a);
    }

    void mod(BigInteger m) {
        assert m != null;
        Objects.requireNonNull(m, "null 발생");
    }

    @Test
    @DisplayName("불변식 깨뜨리기")
    public void periodTest() throws IllegalAccessException {
        Date now1 = new Date();
        Date now2 = new Date();
        Period period = new Period(now1, now2);

        now1.setYear(1979);
        Date startDate = period.getStart();
        int startYear = startDate.getYear();
        Assertions.assertEquals(2024, startYear); // 1900 + 24 년으로 표기됨. 결과는 124.

        //    JDK 코드
        //    Date 의 희한한 메소드. 1900 + 년도로 표기.
        //
        //    public int getYear() {
        //        return normalize().getYear() - 1900;
        //    }

        //    public void setYear(int year) {
        //        getCalendarDate().setNormalizedYear(year + 1900);
        //    }


        assert period != null;
        period.getStart().setYear(1980);
        Assertions.assertEquals(2024, period.start.getYear());
    }

    private static class Period {
        private final Date start;
        private final Date end;

        public Period(Date start, Date end) throws IllegalAccessException {
            if (start.compareTo(end) > 0) {
              //  throw new IllegalAccessException(start + "가" + end + "보다 늦다.");
            }
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
        }

        public Date getStart() {
            return new Date(start.getTime());
        }

        public Date getEnd() {
            return new Date(end.getTime());
        }
    }

}
