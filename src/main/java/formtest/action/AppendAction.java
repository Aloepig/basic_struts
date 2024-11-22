package formtest.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class AppendAction extends ActionSupport {

    final private List<String> list1 = new ArrayList<>();
    final private List<String> list2 = new ArrayList<>();

    public AppendAction() {
        this.list1.add("a");
        this.list1.add("b");
        this.list1.add("c");
        this.list2.add("A");
        this.list2.add("B");
        this.list2.add("C");
    }

    public List<String> getList1() {
        return list1;
    }

    public List<String> getList2() {
        return list2;
    }
}
