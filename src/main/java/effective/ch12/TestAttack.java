package effective.ch12;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;

public class TestAttack {

    @Test
    public void attackTest() {
//        byte[] se = SerializationUtils.serialize(Elvis.INSTANCE);
//        System.out.println(Arrays.toString(se));

        byte[] de = {-84, -19, 0, 5, 115, 114, 0, 20, 101, 102, 102, 101, 99, 116, 105, 118, 101, 46, 99, 104, 49, 50, 46, 69, 108, 118, 105, 115, -24, 1, 119, 127, 123, 59, 38, 121, 2, 0, 1, 91, 0, 5, 110, 97, 109, 101, 115, 116, 0, 19, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 120, 112, 117, 114, 0, 19, 91, 76, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110, 103, 59, -83, -46, 86, -25, -23, 29, 123, 71, 2, 0, 0, 120, 112, 0, 0, 0, 4, 116, 0, 5, 69, 108, 118, 105, 115, 116, 0, 7, 80, 114, 101, 115, 108, 101, 121, 116, 0, 7, 76, 101, 111, 110, 97, 114, 100, 116, 0, 6, 72, 111, 119, 97, 114, 100};
        Elvis elvis = SerializationUtils.deserialize(de);
        Elvis impersonator = ElvisStealer.impersonator; // 안되는데??

        elvis.printNames();
        impersonator.printNames();
    }


}

class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    private String[] names = {"Elvis", "Presley", "Leonard", "Howard"};

    public void printNames() {
        System.out.println(Arrays.toString(names));
    }

    // 역직렬화 할때 반환되는 객체를 명시할 수 있음.
    private Object readResolve() {
        return INSTANCE;
    }
}

class ElvisStealer implements Serializable {
    static Elvis impersonator;
    private Elvis payload;

    private Object readResolve() {
        impersonator = payload; // resolve 되기전의 참조값 저장.

        return new String[] {"Stealing Elvis"};
    }

    private static final long serialVersionUID = 1L;
}
