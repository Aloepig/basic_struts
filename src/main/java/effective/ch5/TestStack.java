package effective.ch5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

public class TestStack {

    @Test
    @DisplayName("제네릭 메소드 만들어보기")
    public void stackTest() {

    }
    static class Stack<E> {
        private E[] elements;
        private int size;
        private static final int DEFAULT_CAPACITY = 16;

        // push(E) 로 넘어온 인스턴스만 사용하므로 타입 안정성이 있음.
        // 런타입 타입은 Object 임.
        @SuppressWarnings("unchecked")
        public Stack() {
            elements = (E[])new Object[DEFAULT_CAPACITY];
        }

        public void push(E o) {
            ensureCapacity();
            elements[size++] = o;
        }

        public E pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            E result = elements[--size];
            elements[size] = null;
            return result;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, size * 2);
            }
        }
    }

    static class StackOld {
        private Object[] elements;
        private int size;
        private static final int DEFAULT_CAPACITY = 16;

        public StackOld() {
            elements = new Object[DEFAULT_CAPACITY];
        }

        public void push(Object o) {
            ensureCapacity();
            elements[size++] = o;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            Object result = elements[--size];
            elements[size] = null;
            return result;
        }

        private void ensureCapacity() {
            if(elements.length == size) {
                elements = Arrays.copyOf(elements, size * 2);
            }
        }
    }
}
