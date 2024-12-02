package effective.ch3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TestItem14 {

    @Test
    public void item14Test() {

        Assertions.assertEquals(-1, "1".compareTo("5"));
    }

    class PhoneNumber implements Comparable<PhoneNumber> {
        private long areaCode;
        private String prefix;
        private String lineNumber;

        // 일반적인 compareTo
        @Override
        public int compareTo(PhoneNumber o) {
            int result = Long.compare(areaCode, o.areaCode);
            if (result == 0) {
                result = prefix.compareTo(o.prefix);
                if (result == 0) {
                    result = lineNumber.compareTo(o.lineNumber);
                }
            }
            return result;
        }

        // 비교자 생성 메서드를 활용
        private final Comparator<PhoneNumber> phoneNumberComparator
                = Comparator.comparingLong((PhoneNumber pn) -> pn.areaCode)
                .thenComparing(pn -> pn.prefix)
                .thenComparing(pn ->pn.lineNumber);

        public int compareTo2(PhoneNumber o) {
                return phoneNumberComparator.compare(this, o);
        }
    }


}
