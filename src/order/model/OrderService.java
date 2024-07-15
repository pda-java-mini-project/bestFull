package order.model;

public class OrderService {
    OrderDAO orderDAO = new OrderDAO();

    public void placeOrder(String storeName, int ownerId, int price, OrderMenu[] orderMenus) {
        Order newOrder = new Order(storeName, ownerId, price, orderMenus);
        orderDAO.insert(newOrder);
    }

    public Order[] getOrders() {
        return orderDAO.fetchAll();
    }

    public Order getOrder(String id) {
        int idAsInt = Integer.parseInt(id);
        return orderDAO.findById(idAsInt);
    }

    public int[] getAllOrderId() {
        return orderDAO.fetchAllId();
    }

    public OrderMenu[] getOrderMenus(Order order) {
        return order.getOrderMenus();
    }

    public int getOrderMenusTotalPrice(OrderMenu[] orderMenus) {
        int totalPrice = 0;

        for (OrderMenu orderMenu : orderMenus) {
            totalPrice += orderMenu.getTotalPrice();
        }

        return totalPrice;

    }
}
