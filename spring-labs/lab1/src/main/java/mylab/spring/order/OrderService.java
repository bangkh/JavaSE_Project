package mylab.spring.order;

public class OrderService {
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() { return shoppingCart; }
    public void setShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart == null) { throw new IllegalArgumentException("장바구니가 필요합니다."); }
        this.shoppingCart = shoppingCart;
    }
    public int calculateOrderTotal() {
        if (shoppingCart == null) { throw new IllegalStateException("장바구니가 주입되지 않았습니다."); }
        int sum = 0;
        for (Product product : shoppingCart.getProducts()) {
            sum = Math.addExact(sum, product.getPrice());
        }
        return sum;
    }
}