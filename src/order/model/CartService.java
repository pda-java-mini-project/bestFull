package order.model;

public class CartService {
    Cart cart = new Cart();

    public void updateCart(int menuId, int menuCount, String menuName, int menuPrice) {
        if (menuCount == 0) {
            cart.deleteOderMenu(menuId);
            return;
        }

        cart.addOrderMenu(menuId, menuCount, menuName, menuPrice);
    }

    public int getTotalCartSum() {
        OrderMenu[] orderMenus = cart.getOrderMenus();
        int totalSum = 0;

        for (OrderMenu orderMenu : orderMenus) {
            totalSum += orderMenu.getTotalPrice();
        }

        return totalSum;
    }

    public OrderMenu[] getOrderMenus() {
        return cart.getOrderMenus();
    }

    public void reset(){
        this.cart = new Cart();
    }
}
