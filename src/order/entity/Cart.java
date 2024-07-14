package order.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> cartItems;

    public Cart(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItems.values()) {
            totalPrice += item.getMenu().getMenuPrice() * item.getQuantity();
        }
        return totalPrice;
    }
}
