package effective.ch8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestOverload {

    @Test
    @DisplayName("다중정의 메소드가 정적(컴파일타임)으로 선택되는 예시")
    public void overloadTest() {
        Collection<?>[] collections = {
                new HashSet<>(), new ArrayList<>(), new HashMap<>().values()
        };

        CollectionClassifier cc = new CollectionClassifier();
        // 컴파일타임에는 Collection<?> 타입이므로 세번 COLLECTION 만 출력됨!
        for (Collection<?> c : collections) {
            System.out.println(cc.classify(c));
        }
    }

    class CollectionClassifier {
        public String classify(Set<?> s) {
            return "SET";
        }

        public String classify(List<?> s) {
            return "LIST";
        }

        public String classify(Collection<?> s) {
            return "COLLECTION";
        }
    }

    @Test
    @DisplayName("재메서드가 동적(런타임)에 선택되는 예시")
    public void overrideTest() {
        List<Wine> wineList = Arrays.asList(new Wine(), new SparklingWine(), new Champagne());

        for (Wine w : wineList) {
            System.out.println(w.name());
        }
    }

    class Wine {
        String name() {
            return "Wine";
        }
    }

    class SparklingWine extends Wine {
        @Override
        String name() {
            return "SparklingWine";
        }
    }

    class Champagne extends Wine {
        @Override
        String name() {
            return "Champagne";
        }
    }


}
