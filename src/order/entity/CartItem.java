package order.entity;


public class CartItem {
    private Menu menu;
    private int quantity;

    public CartItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return menu.getMenuNumber() + menu.getMenuName() + quantity + (menu.getMenuPrice() * quantity) + "("+menu.getMenuPrice()+"*"+quantity+")";
    }


}
