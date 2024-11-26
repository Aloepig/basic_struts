package ch6.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class SystemAction extends ActionSupport {

    private List<String> stringList = new ArrayList<>();

    public SystemAction() {
        stringList.add("사용자관리1");
        stringList.add("사용자관리2");
        stringList.add("사용자관리3");
        stringList.add("사용자관리4");
        stringList.add("사용자관리5");
    }

    public List<String> getStringList() {
        return stringList;
    }
}
