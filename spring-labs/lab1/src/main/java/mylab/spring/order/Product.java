package mylab.spring.order;

public class Product {
    private String id;
    private String name;
    private int price;

    public Product() {}
    public Product(String id, String name, int price) {
        setId(id);
        setName(name);
        setPrice(price);
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPrice() { return price; }
    public void setPrice(int price) {
        if (price < 0) { throw new IllegalArgumentException("가격은 0 이상이어야 합니다."); }
        this.price = price;
    }
}