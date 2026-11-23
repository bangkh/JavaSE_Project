package mylab.spring.order;

public class OrderService {
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int calculateOrderTotal() {
        int total = 0;
        for (Product product : shoppingCart.getProducts()) {
            total = total + product.getPrice();
        }
        return total;
    }
}
