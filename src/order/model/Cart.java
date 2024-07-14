package order.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<OrderMenu> orderMenus;

    public Cart() {
        orderMenus = new ArrayList<OrderMenu>();
    }

    public OrderMenu[] getOrderMenus() {
        return orderMenus.toArray(new OrderMenu[0]);
    }

    public void addOrderMenu(int menuId, int menuCount, String menuName, int menuPrice) {
        for (OrderMenu orderMenu : orderMenus) {
            if (orderMenu.getId() == menuId) {
                orderMenu.setCount(menuCount);
                return;
            }
        }

        orderMenus.add(new OrderMenu(menuId, menuName, menuCount, menuPrice));
    }

    public void deleteOderMenu(int menuId) {
        int removeIndex = 0;
        boolean isFindDeleteMenu = false;

        for (int i = 0; i < orderMenus.size(); i++) {
            if (orderMenus.get(i).getId() == menuId) {
                removeIndex = i;
                isFindDeleteMenu = true;
                break;
            }
        }

        if (isFindDeleteMenu) {
            orderMenus.remove(removeIndex);
        }
    }
}
