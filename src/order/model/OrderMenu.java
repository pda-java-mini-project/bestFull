package order.model;

public class OrderMenu {
    private int id;
    private String name;

    private int count;
    private int price;

    private int totalPrice;

    public OrderMenu(int id, String name, int count, int price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = price * count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count ;
        totalPrice = this.count * price;
    }
}
