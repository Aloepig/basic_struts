package effective.ch5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestVarargs {

    @Test
    public void varargsTest(){
        // dangerrous(Arrays.asList("a", "b", "c")); // 에러 발생함.

        Number[] num = toArray(1,2,3,4);
        System.out.println(Arrays.toString(num));

        Object[] stringArray = picTwo(1, "bb2", "3");

    }

    void dangerrous(List<String>... stringArgs){
        List<Integer> intList = Arrays.asList(1,2,3);
        Object[] objectArray = stringArgs;
        objectArray[0] = intList; // 힙오염
        String s = stringArgs[0].get(0);
    }

    // 반환이 T[] 일것 같지만, 실제는 Object[] 임.
    <T> T[] toArray(T... t){
        System.out.println(t instanceof Object);
        return t;
    }

    <T> T[] picTwo(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0: return toArray(a,b);
            case 1: return toArray(a,c);
            case 2: return toArray(b,c);
            default: return toArray(a,c);
        }
    }
}
