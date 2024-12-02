package effective.ch2.item09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestItem06 {

    @Test
    // 6초 소요
    public void item06TestSlow(){
        Date startDate = new Date();
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        Date endDate = new Date();
        System.out.println(endDate.getTime() - startDate.getTime());
        Assertions.assertEquals(sum, 2305843005992468481L);
    }

    @Test
    // 0.6초 소요
    public void item06TestFast(){
        Date startDate = new Date();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        Date endDate = new Date();
        System.out.println(endDate.getTime() - startDate.getTime());
        Assertions.assertEquals(sum, 2305843005992468481L);
    }
}
