package order;

import order.entity.*;
import order.service.OrderService;

public class OrderController {
    private static final OrderService orderService = new OrderService();
    private static final OrderView view = new OrderView();
    private CartDAO cartDAO;
    private StoreDAO storeDAO;

    public OrderController(StoreDAO storeDAO, CartDAO cartDAO) {
        this.storeDAO = storeDAO;
        this.cartDAO = cartDAO;
    }

    public void orderPage(){
        view.showOrderNoticeView();
    }

    public String orderInput(){
        return view.getInput();
    }

    public void order() {
        orderPage();
        while(true){
            String input = orderInput();
            if (input.equals("0")) {
                break;
            }
            String[] inputs = input.split(" ");
            int menuNumber = Integer.parseInt(inputs[0]);
            int quantity = Integer.parseInt(inputs[1]);
            Menu menu = orderService.getMenuInfo(menuNumber);
            orderService.putCart(menu, quantity);
        }
    }

    public int cart() {
        int totalPrice = orderService.getCart().calculateTotalPrice();
        return view.showCartNoticeView(orderService.getCartItems(), totalPrice);
    }

    public int pay() {
        return view.showPayNoticeView();
    }

    public int receipt() {
        orderService.order();
        return view.showReceiptNoticeView(orderService.getOrders());
    }
}
