package effective.ch3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestItem13 {

    @Test
    public void test13() throws CloneNotSupportedException {
        CloneTest first = new CloneTest();
        CloneTest second = (CloneTest) first.clone();
        Assertions.assertEquals(first.age, second.age);
    }


}

// Cloneable 은 아무런 메소드가 없지만, 구현해야 Object.clone 을 사용할 수 있다.
class CloneTest implements Cloneable{

    public int age = 13;

    @Override
    public CloneTest clone() throws CloneNotSupportedException {
        return (CloneTest) super.clone();
    }
}

// 사실 복제가 필요하면 다음과 같이 생성자나 팩터리를 사용하는 것이 단순하고 안전하다.
class CopyTest {
    // 복사 생성자 = 변환 생성자
    public CopyTest(CopyTest copyTest){

    }

    public static CopyTest newInstance(CopyTest copyTest){
        return new CopyTest(copyTest);
    }
}