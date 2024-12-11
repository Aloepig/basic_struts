package effective.ch8;

import freemarker.template.TemplateModelException;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

public class TestOptional {

    @Test
    public void optionalTest() throws TemplateModelException {
        List<String> list = new ArrayList<>();
        Optional<String> a = max(list);
        System.out.println(a.orElse("빈값")); // 값이 없으면 기본값
        System.out.println(a.orElseThrow(TemplateModelException::new)); // 값이 없으면 예외
    }

    // 컬렉션에서 최대 값을 구함
    private static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if(c.isEmpty()){
            return Optional.empty();
        }
        E result = null;
        for(E e : c){
            if(result == null || e.compareTo(result) > 0){
                result = e;
            }
        }
        return Optional.ofNullable(result);
    }
}
