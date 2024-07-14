package order.entity;


import java.util.HashMap;
import java.util.Map;

public class CartDAO {
    private HashMap<Integer, CartItem> cartDb = new HashMap<>();


    public void insert(CartItem cartItem) {
        int menuNumber = cartItem.getMenu().getMenuNumber();
        if (cartDb.containsKey(menuNumber)) {
            CartItem existingItem = cartDb.get(menuNumber);
            existingItem.setQuantity(existingItem.getQuantity() + cartItem.getQuantity());
        } else {
            cartDb.put(menuNumber, cartItem);
        }
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartDb;
    }
}
