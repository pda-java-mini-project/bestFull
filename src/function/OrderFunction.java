package function;

import exception.ExceptionHandler;
import exception.InvalidInputException;
import order.OrderController;
import store.StoreController;
import store.model.DishInfo;
import store.model.StoreOrderDTO;

public class OrderFunction {

    StoreController storeController = new StoreController();
    OrderController orderController = new OrderController();


    public void makeOrder(int userId){

        StoreOrderDTO dto = storeController.startStore();
        if (dto == null) return;

        orderController.setUserId(userId);
        orderController.setCurrentMenus(dto.getMenus());
        orderController.setStoreName(dto.getStoreName());

        orderController.showReceiveAddItemToCartView();
        orderController.receiveAddOrderMenu();


        boolean isStartCartSevice = true;
        while (isStartCartSevice) {
            orderController.showCartView();
            orderController.showReceiveCartPageOptionNoticeView();

            switch (orderController.receiveCartPageOption()) {
                case "0":
                    return;
                case "1":
                    orderController.showReceiveEditItemToCartView();
                    orderController.receiveAddOrderMenu();
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

        orderController.showReceiptView();
        orderController.receiveOrderCompletedOption();
    }


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

}