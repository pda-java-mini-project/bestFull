package order.entity;
import java.util.Map;

public class Order {
    private int orderId;
    private Map<Integer, CartItem> items;
    private int totalPrice;

    public Order(int orderId, Map<Integer, CartItem> items, int totalPrice) {
        this.orderId = orderId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}

