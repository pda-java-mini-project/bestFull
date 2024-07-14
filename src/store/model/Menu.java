package store.model;

import java.util.HashMap;
import java.util.Iterator;

public class Menu {
    private String storeName;
    private HashMap<Integer, DishInfo> dishes;

    public Menu(String storeName) {
        this.storeName = storeName;
        dishes = new HashMap<>();
    }

    public void addDish(int dishId, String dishName, Integer dishPrice, String dishDescription) {
        dishes.put(dishId, new DishInfo(dishId, dishName, dishPrice, dishDescription));
    }

    public int getAveragePrice() {
        int sum = 0;

        Iterator<Integer> keys = dishes.keySet().iterator();
        while(keys.hasNext()) {
            Integer key = keys.next();
            sum += dishes.get(key).getDishPrice();
        }
        int averagePrice = sum / dishes.size();

        return averagePrice;
    }

    public HashMap<Integer, DishInfo> getDishes() {
        return dishes;
    }
}
