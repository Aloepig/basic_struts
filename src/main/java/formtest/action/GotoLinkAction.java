package formtest.action;

import com.opensymphony.xwork2.ActionSupport;

public class GotoLinkAction extends ActionSupport {

    private String message;

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
