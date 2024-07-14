package order.model;

import java.util.HashMap;

public class OrderDAO {
    private HashMap<Integer, Order> orderDb = new HashMap<>();
    private int autoIncrementIndex = 0;

    public void insert(Order order) {
        orderDb.put(autoIncrementIndex++, order);
    }
}
