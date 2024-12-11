package effective.ch9;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestReflect extends HashSet<String> {

    @Test
    @SuppressWarnings("unchecked")
    public void reflectTest(){
        Class<? extends Set<String>> cl = null;

        try {
            cl = (Class<? extends Set<String>>) Class.forName("effective.ch9.TestReflect");
        } catch (ClassNotFoundException e) {
            fatalError("클래스가 없음");
        }

        Constructor<? extends Set<String>> cons = null;
        try{
            cons = Objects.requireNonNull(cl).getDeclaredConstructor();
        } catch (NoSuchMethodException e){
            fatalError("생성자가 없음");
        }

        Set<String> s = null;
        try{
            s = Objects.requireNonNull(cons).newInstance();
        }catch (Exception e){
            fatalError("구현되지 않은 클래스다.");
        }

        Objects.requireNonNull(s).addAll(Arrays.asList("1","33"));
        System.out.println(s);
     }

     private void fatalError(String msg){
        System.out.println(msg);
     }
}
