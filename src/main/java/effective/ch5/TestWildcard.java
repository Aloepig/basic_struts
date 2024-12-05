package effective.ch5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestWildcard {

    @Test
    public void testWildcard() {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3);
        numberStack.pushAll(integers);

        List<Object> popAllList = new ArrayList<>();
        numberStack.popAll(popAllList);
    }

    static class Stack<E> {
        private final List<E> list = new ArrayList<>();

        public Stack() {

        }

        public void push(E e) {
            list.add(e);
        }

        public E pop() {
            if (list.isEmpty()) {
                return null;
            } else {
                E e = list.get(list.size()-1);
                list.remove(e);
                return e;
            }
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void pushAll(Iterable<? extends E> sec){
            for (E e : sec) {
                push(e);
            }
        }

        public void popAll(Collection<? super E> dst) {
            while(!isEmpty()){
                dst.add(pop());
            }
        }
    }
}
