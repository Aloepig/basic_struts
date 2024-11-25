package ch4.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CallMultiAction extends ActionSupport {

    private static final Logger log = LogManager.getLogger(CallMultiAction.class);

    public String action1() throws Exception {
        log.info("action1");
        return SUCCESS;
    }

    public String action2() throws Exception {
        log.info("action2");
        System.out.println("action2");
        return SUCCESS;
    }
}
