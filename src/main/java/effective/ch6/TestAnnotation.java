package effective.ch6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class TestAnnotation {

    private static final Logger log = LogManager.getLogger(TestAnnotation.class);

    @TestBj(value = ArithmeticException.class)
    public void m1() {
    }

    @Test
    public void m2() throws Exception {
        markerTest("effective.ch6.TestAnnotation");
    }


    @Retention(RetentionPolicy.RUNTIME) // 정보유지되는 대상
    @Target(ElementType.METHOD) // 적용대상
    public @interface TestBj {
        Class<? extends Throwable> value();
    }

    private void markerTest(String name) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> clazz = Class.forName(name);
        for (Method m : clazz.getMethods()) {
            if (m.isAnnotationPresent(TestBj.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (Exception targetException) {
                    Throwable exc = targetException.getCause();
                    log.error(String.valueOf(exc));
                }
            }
        }
        log.info(String.valueOf(passed));
        log.info(String.valueOf(tests));
    }
}
