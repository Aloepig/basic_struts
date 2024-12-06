package effective.ch6;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class TestEnumMap {

    @Test
    public void enumMapTest() {

        Map<LifeCycle, String> plantByLifeCycle = new EnumMap<>(LifeCycle.class);

        for (LifeCycle lifeCycle : LifeCycle.values()) {
            plantByLifeCycle.put(lifeCycle, lifeCycle.toString());
        }
        System.out.println(plantByLifeCycle);
    }

    enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    @Test
    public void enumMapTest2() {
        Phase.Transition transition = Phase.Transition.get(Phase.GAS, Phase.LIQUID);
        System.out.println(transition);
    }

    enum Phase {
        SOLD, LIQUID, GAS;

        public enum Transition {
            MELT(SOLD, LIQUID), FREEZE(LIQUID, SOLD),
            BOIL(LIQUID, SOLD), CONDENSE(GAS, LIQUID),
            SUBLIME(SOLD, GAS), DEPOSIT(GAS, SOLD);

            private Phase from;
            private Phase to;

            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }

            private static final Map<Phase, Map<Phase, Transition>> m
                    = Stream.of(values()).collect(groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class), toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))));

            public static Transition get(Phase from, Phase to) {
                return m.get(from).get(to);
            }
        }
    }


}
