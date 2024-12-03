package effective.ch4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.List;

public class TestInterface {

    @Test
    public void InterfaceTest() {
        // java 7 부터 리터럴에 밑줄 허용. 실제로는 숫자로 취급되지 않음.
        final double AVOGADRO = 6.022_140_857e23;
        final int TEST_INT = 1979_11_05;
        Assertions.assertEquals(19791105, TEST_INT);
    }


    // 골격 구현(skeletal)을 사용해 완성한 구체 클래스
// adapter 패턴 이기도 함(int[]를 List 로 바꿈)
    List<Integer> intArrayAsList(int[] intArray) {
        return new AbstractList<Integer>() {
            @Override
            public int size() {
                return intArray.length;
            }

            public Integer get(int index) {
                return intArray[index];
            }

            public Integer set(int index, Integer i) {
                int oldVal = intArray[index];
                intArray[index] = i;
                return oldVal;
            }
        };
    }

}

interface Singer {
    // java 8 부터
    default String getName() {
        return "default Name";
    }
}

interface SongWriter {
    String getTitle();
}

// 다중 상속
interface SingerSongwriter extends Singer, SongWriter {
    String getTitle();
}
