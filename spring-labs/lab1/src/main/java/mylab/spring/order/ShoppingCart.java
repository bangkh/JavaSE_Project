package mylab.spring.order;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) {
        if (products == null) { throw new IllegalArgumentException("상품 목록이 null일 수 없습니다."); }
        this.products = new ArrayList<Product>(products);
    }
}