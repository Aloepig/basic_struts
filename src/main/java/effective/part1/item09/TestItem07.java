package effective.part1.item09;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

public class TestItem07 {
    @Test
    public void stackTest() throws Throwable {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
//        stack.finalize(); // Object 의 protected 이므로 override 해야 사용.
    }
}

class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public Stack() throws Throwable {
        elements = new Object[DEFAULT_CAPACITY];
//        finalize(); // Object 를 extends 했으므로 사용가능.
    }

    public void push(Object o) {
        grow();
        elements[size++] = o;
    }

    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // 참조 해제.
        return result;
    }

    private void grow() {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
}
