package order.entity;
import java.util.HashMap;
import java.util.Map;

public class OrderDAO {
    private Map<Integer, Order> orderDb = new HashMap<>();
    private int orderIdCounter = 1;

    public void addOrder(Map<Integer, CartItem> items, int totalPrice) {
        Order order = new Order(orderIdCounter++, items, totalPrice);
        orderDb.put(order.getOrderId(), order);
    }

    public Map<Integer, Order> getOrders() {
        return orderDb;
    }

    public Order getOrderById(int orderId) {
        return orderDb.get(orderId);
    }

    public int getOrderIdCounter() {
        return orderIdCounter;
    }
}
