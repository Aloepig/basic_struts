package effective.part1.item05;

import java.util.Objects;

/**
 * 스펠 체크하는 객체
 */
public class SpellChecker {
    private final String dictionary;

    public SpellChecker(String dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return true;
    }

}
