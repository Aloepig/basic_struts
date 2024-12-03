package effective.ch4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class TestHashSet {

    @Test
    @DisplayName("상위클래스의 로직에의해, 의도를 벗어나는 동작을 하는 잘못된 상속")
    public void HashSetTest(){
        InstrumentedHashSet<String> ihs = new InstrumentedHashSet<String>();
        ihs.add("a");
        ihs.add("b");
        ihs.add("c");
        ihs.addAll(Arrays.asList("d", "e"));
        Assertions.assertEquals(5, ihs.getAddCount()); // 결과 7
    }

    public static class InstrumentedHashSet<E> extends HashSet<E> {

        private int addCount = 0;

        public InstrumentedHashSet() {

        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        // 실제로는 addAll은 add메서드를 사용하여 추가하게 되어있고 API문서 어디에도 해당 내용이 없다!
        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    @Test
    @DisplayName("데코레이션 패턴을 적용한 구현")
    public void SetTest(){
        InstrumentedSet<String> ihs = new InstrumentedSet<>(new HashSet<>());
        ihs.add("a");
        ihs.add("b");
        ihs.add("c");
        ihs.addAll(Arrays.asList("d", "e"));
        Assertions.assertEquals(5, ihs.getAddCount()); // 결과 5
    }

    static class InstrumentedSet<E> extends ForwardingHashSet<E> {

        private int addCount = 0;

        public InstrumentedSet(HashSet<E> set) {
            super(set);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    static class ForwardingHashSet<E>  {
        private final HashSet<E> set;
        public ForwardingHashSet(HashSet<E> set) {
            this.set = set;
        }

        public boolean addAll(Collection<? extends E> c) {
            return set.addAll(c);
        }

        public boolean add(E e) {
            return set.add(e);
        }
    }

}
