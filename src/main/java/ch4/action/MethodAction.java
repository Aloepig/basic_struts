package ch4.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

public class MethodAction extends ActionSupport {

    private String message;
    private String name;
    private String submitType;

    @Override
    public String execute() throws Exception {
        boolean isCancel = StringUtils.equals(submitType, "취소");
        this.message = name + ":" + (isCancel ? "Cancel" : "Ok");
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
}
