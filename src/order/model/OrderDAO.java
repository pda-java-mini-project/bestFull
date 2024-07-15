package order.model;

import java.util.HashMap;
import java.util.Set;

public class OrderDAO {
    private HashMap<Integer, Order> orderDb = new HashMap<>();
    private int autoIncrementIndex = 1;

    public void insert(Order order) {
        order.setId(autoIncrementIndex);
        orderDb.put(autoIncrementIndex++, order);
    }

    public Order[] fetchAll() {
        return orderDb.values().toArray(new Order[0]);
    }

    public Order findById(int id) {
        return orderDb.get(id);
    }

    public int[] fetchAllId() {
        Set<Integer> keys = orderDb.keySet();
        int[] keyArray = new int[keys.size()];
        int i = 0;
        for (Integer key : keys) {
            keyArray[i++] = key;
        }
        return keyArray;
    }
}
