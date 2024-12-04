package effective.ch5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestChooser {

    @DisplayName("제네릭 적용전")
    @Test
    public void chooserTest() {
        Chooser c = new Chooser(new String[]{"1"});
        String s = (String) c.getChoiceArray();
    }

    static class Chooser {
        private final Object[] choiceArray;

        public Chooser(Object[] choiceArray) {
            this.choiceArray = choiceArray;
        }

        public Object getChoiceArray() {
            Random random = ThreadLocalRandom.current();
            return choiceArray[random.nextInt(choiceArray.length)];
        }
    }

    @DisplayName("제네릭 적용")
    @Test
    public void chooserGenericTest() {
        List<String> list = new LinkedList<>();
        list.add("1");
        ChooserGeneric<String> c = new ChooserGeneric<>(list);
        String s = c.getChoiceArray();
    }

    static class ChooserGeneric<T> {
        private final List<T> choiceList;

        public ChooserGeneric(Collection<T> choices) {
            this.choiceList = new ArrayList<T>(choices);
        }

        public T getChoiceArray() {
            Random random = ThreadLocalRandom.current();
            return choiceList.get(random.nextInt(choiceList.size()));
        }
    }

}
