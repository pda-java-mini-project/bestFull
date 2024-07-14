package order.service;

import order.entity.*;

import java.util.Map;

public class OrderService {
    private static final CartDAO cartDAO = new CartDAO();
    private static final StoreDAO storeDAO = new StoreDAO();
    private static final OrderDAO orderDAO = new OrderDAO();
    public Menu getMenuInfo(int menuNumber) {
        return storeDAO.getMenuById(1, 2,menuNumber);
    }

    public void putCart(Menu menu, int quantity) {
        cartDAO.insert(new CartItem(menu, quantity));
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartDAO.getCartItems();
    }

    public Cart getCart(){
        return new Cart(cartDAO.getCartItems());
    }

    public int totalPrice(Cart cart) {
        return cart.calculateTotalPrice();
    }

    public void order() {
        Map<Integer, CartItem> items = getCartItems();
        int totalPrice = totalPrice(getCart());
        orderDAO.addOrder(items, totalPrice);
        cartDAO.getCartItems().clear();
    }

    public Map<Integer, Order> getOrders() {
        return orderDAO.getOrders();
    }

    public Order getOrderById(int orderId) {
        return orderDAO.getOrderById(orderId);
    }
}
