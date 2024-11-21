package formtest.action;

import org.apache.commons.lang3.StringUtils;

public class EchoAction {

    private String echoMessage;
    private String articleSimple;

    public String execute() throws Exception {
        if(StringUtils.isEmpty(echoMessage)){
            return "success";
        }
        return "success";
    }

    // dto 이자 service proferty service

    public String getEchoMessage() {
        return echoMessage;
    }
    public void setEchoMessage(String echoMessage) {
        this.echoMessage = echoMessage;
    }

    public String getArticleSimple() {
        return articleSimple;
    }

    public void setArticleSimple(String articleSimple) {
        this.articleSimple = articleSimple;
    }
}
