package ch4.action;

import ch4.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

    private Product product;
    final private String productIdLabel = "제품ID";
    final private String productNameLabel = "제품명";

    public String addProductForm() throws Exception {
        return SUCCESS;
    }

    public String addProduct() throws Exception {
        product.setDescription("등록성공");
        // 여기는 값이 바뀌지만.
        return SUCCESS;
    }

    public String viewProduct() throws Exception {
        // 여기는 원래 매개변수 값을 사용되므로 값이 바뀌어 있지 않음.
        // 체이닝은 순서대로 실행하면서 모델값이 바뀌는 것이 아님.
        // 모델은 매 체인마다 같은 값을 사용함.
        return SUCCESS;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductIdLabel() {
        return productIdLabel;
    }

    public String getProductNameLabel() {
        return productNameLabel;
    }
}
