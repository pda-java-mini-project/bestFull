package order.model;

public class OrderService {
    OrderDAO orderDAO = new OrderDAO();

    public void placeOrder(String storeName, int ownerId, int price, OrderMenu[] orderMenus) {
        Order newOrder = new Order(storeName, ownerId, price, orderMenus);
        orderDAO.insert(newOrder);
    }
}
