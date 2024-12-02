package effective.ch2.item03;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestElvis {

    @Test
    public void elvisTest(){
        Elvis elvis = Elvis.INSTANCE;
        Assertions.assertTrue(StringUtils.equalsIgnoreCase(elvis.getMyself(), "getMyself"));
    }

    @Test
    public void elvisNormalTest(){
        ElvisNormal elvisNormal = ElvisNormal.getInstance();
        Assertions.assertTrue(StringUtils.equalsIgnoreCase(elvisNormal.getMessage(), "message"));
    }
}
