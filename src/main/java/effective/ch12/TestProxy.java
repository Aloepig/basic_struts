package effective.ch12;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TestProxy {

    @Test
    public void proxyTest() {
//        Period period = new Period(new Date(), new Date());
//        byte[] de = SerializationUtils.serialize(period);
//        System.out.println(Arrays.toString(de));
//
//        Period pr = SerializationUtils.deserialize(de);
//        System.out.println(pr.getEnd());

        // SerializationProxy 객체의 직렬화 데이터
        byte[] se = {-84, -19, 0, 5, 115, 114, 0, 40, 101, 102, 102, 101, 99, 116, 105, 118, 101, 46, 99, 104, 49, 50, 46, 80, 101, 114, 105, 111, 100, 36, 83, 101, 114, 105, 97, 108, 105, 122, 97, 116, 105, 111, 110, 80, 114, 111, 120, 121, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 76, 0, 3, 101, 110, 100, 116, 0, 16, 76, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 68, 97, 116, 101, 59, 76, 0, 5, 115, 116, 97, 114, 116, 113, 0, 126, 0, 1, 120, 112, 115, 114, 0, 14, 106, 97, 118, 97, 46, 117, 116, 105, 108, 46, 68, 97, 116, 101, 104, 106, -127, 1, 75, 89, 116, 25, 3, 0, 0, 120, 112, 119, 8, 0, 0, 1, -109, -51, -42, -103, 124, 120, 115, 113, 0, 126, 0, 3, 119, 8, 0, 0, 1, -109, -51, -42, -103, 124, 120};
        Period peSe = SerializationUtils.deserialize(se);
        System.out.println(peSe.getEnd());
    }

}

class Period implements Serializable {

    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    // 이렇게 선언하면 Period 직렬화시 실행된다.
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // Period 역직렬화시 실행됨.
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        System.out.println("readObject");
        throw new java.io.InvalidObjectException("Proxy required");
    }

    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        // SerializationProxy 역직렬화시 실행됨.
        private Object readResolve() {
            System.out.println("프록시 역직렬화 Proxy readResolve");
            return new Period(start, end);
        }

        private static final long serialVersionUID = 1L;
    }

}


