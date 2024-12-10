package effective.ch7;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAnagrams {

    @Test
    public void anagramsTest() {
        System.out.println(toList());
        System.out.println(toMap());
        toMap3().forEach((artist, album) -> System.out.println(artist.name + ":" + album.name));
    }

    // 값이 가장 큰 원소 2개를 list 로 담음
    private List<String> toList() {
        Map<String, Long> freq = new HashMap<>();
        freq.put("a", 1L);
        freq.put("b", 2L);
        freq.put("c", 3L);
        freq.put("d", 4L);

        List<String> topTwo = freq.keySet().stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .limit(2)
                .collect(Collectors.toList());

        return topTwo;
    }

    // Enum을 이름과 값을 Map 에 담음
    private Map<String, Integer> toMap() {
        return Stream.of(SampleEnum.values()).collect(Collectors.toMap(Object::toString, SampleEnum::getI));
    }

    enum SampleEnum {
        SAM1(10), SAM2(20), SAM3(30);

        int i;

        SampleEnum(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }

    // 앨범 목록에서 가장 많이 팔린 앨범만 Map에 담음
    private Map<Artist, Album> toMap3() {
        Artist artist = new Artist("Lose");
        Artist artist2 = new Artist("Bruno");
        Album album1 = new Album(artist, 10, "APT");
        Album album2 = new Album(artist, 50, "SPT");
        Album album3 = new Album(artist2, 10, "SET");
        Album album4 = new Album(artist2, 50, "ZET");

        List<Album> albums = Arrays.asList(album1, album2, album3, album4);

        Map<Artist, Album> topHits = albums.stream().collect(
                Collectors.toMap(album -> album.artist, album -> album, BinaryOperator.maxBy(Comparator.comparing(album -> album.sales)))
        );

        return topHits;
    }

    class Artist {
        public final String name;

        public Artist(String name) {
            this.name = name;
        }
    }

    class Album {
        public final Artist artist;
        public final int sales;
        public final String name;

        public Album(Artist artist, int sales, String name) {
            this.artist = artist;
            this.sales = sales;
            this.name = name;
        }
    }

}
