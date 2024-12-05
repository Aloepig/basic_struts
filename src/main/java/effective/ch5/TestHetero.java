package effective.ch5;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHetero {

    @Test
    public void testHetero() {
        Favorites favorites = new Favorites();

        favorites.putFavorite(String.class, "Java");
//        favorites.putFavorite(String.class, 123); // 컴파일 오류
        favorites.putFavorite(Class.class, Favorites.class);

        Integer faString = favorites.getFavorite(Integer.class);
        Class<?> faClass = favorites.getFavorite(Class.class);

        System.out.printf("%s%n %s", faString, faClass.getName());
    }

    static class Favorites {
        private final Map<Class<?>, Object> repo = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T value) {
            repo.put(type, value);
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(repo.get(type)); // 경고 없음. 동적형변환
//            return (T) repo.get(type); // 알수없는 형변환 경고 발생함. 실행 가능. 정적형변환이라 컴파일시 타입을 알 수 없음.
        }
    }
}
