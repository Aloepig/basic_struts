package effective.ch6;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TestBigram implements Serializable {

    @Test
    public void bogram() {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                s.add(new Bigram(c, c));
            }
        }
        System.out.println(s.size());
    }

    static class Bigram {
        private final char first;
        private final char second;

        public Bigram(char first, char second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bigram bigram = (Bigram) o;
            return this.first == bigram.first && this.second == bigram.second;
        }

        public int hashCode() {
            return 31 * this.first + this.second;
        }
    }
}
