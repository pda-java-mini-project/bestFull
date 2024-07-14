import exception.ExceptionHandler;
import exception.InvalidInputException;
import order.OrderController;
import store.model.MenuGM;

public class OrderManager {
    OrderController orderController = new OrderController();
    public void startService() {
        orderService();
    }

    private void orderService() {
        boolean isStopOrderService = false;
        setupOrderService();
        addOrderMenu();

        boolean isStartCartSevice = true;
        while (isStartCartSevice) {
            orderController.showCartView();
            orderController.showReceiveCartPageOptionNoticeView();
            switch (orderController.receiveCartPageOption()) {
                case "0":
                    isStopOrderService = true;
                    isStartCartSevice = false;
                    break;
                case "1":
                    editOrderMenu();
                    break;
                case "2":
                    boolean isPaymentServiceCompleted = paymentService();

                    if (isPaymentServiceCompleted) {
                        isStartCartSevice = false;
                    }
                    break;
                default:
                    ExceptionHandler.handleInvalidInputException(new InvalidInputException("InvalidInputException"));
            }
        }

        if (isStopOrderService) {
            return;
        }

        receiptService();
    }

    private void setupOrderService() {
        orderController.setUserId(1);
        orderController.setStoreName("조조 칼국수");
        orderController.setCurrentMenus(new MenuGM[]{new MenuGM(1, "칼국수", 10000, "기가 맥힘"), new MenuGM(2, "파전", 5000, "막걸리 생각")});
    }

    private void addOrderMenu() {
        orderController.showReceiveAddItemToCartView();
        orderController.receiveAddOrderMenu();
    }

    private void editOrderMenu() {
        orderController.showReceiveEditItemToCartView();
        orderController.receiveAddOrderMenu();
    }

    private boolean paymentService() {
        orderController.showPaymentView();
        boolean isStartPaymentSevice = true;

        switch (orderController.receiveCartPageOption()) {
            case "0":
                isStartPaymentSevice = false;
                break;
            case "1", "2":
                orderController.processOrder();
                break;
            default:
                ExceptionHandler.handleInvalidInputException(new InvalidInputException("InvalidInputException"));

        }

        return isStartPaymentSevice;
    }

    private void receiptService() {
        orderController.showReceiptView();
        orderController.receiveOrderCompletedOption();
    }
}
