package rebuild.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

    private String content = " CONTENT";

    @Override
    public String execute() {
        return SUCCESS;
    }

    public String getContent() {
        return content;
    }
}
