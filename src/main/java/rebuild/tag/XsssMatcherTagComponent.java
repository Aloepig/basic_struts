package rebuild.tag;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.UIBean;

public class XsssMatcherTagComponent extends UIBean {
    public XsssMatcherTagComponent(ValueStack stack, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    protected String getDefaultTemplate() {
        return template;
    }

    @Override
    protected void evaluateExtraParams() {
        super.evaluateExtraParams();
    }
}
