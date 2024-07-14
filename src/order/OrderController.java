package order;

import exception.ExceptionHandler;
import exception.InvalidInputException;
import exception.MenuNotFoundException;
import order.model.CartService;
import order.model.OrderMenu;
import order.model.OrderService;
import store.model.Menu;

public final class OrderController {
    private final OrderView orderView = new OrderView();
    private final CartService cartService = new CartService();
    private final OrderService orderService = new OrderService();
    private Menu[] currentMenus = null;
    private String storeName = "";

    private int userId = 0;

    public void setCurrentMenus(Menu[] menus) {
        currentMenus = menus;
    }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public void setUserId(int userId) { this.userId = userId; }
    public void showReceiveAddItemToCartView() {
        orderView.showOrderNoticePage();
    }

    public void receiveAddOrderMenu() {
        boolean isStartCartService = true;
        while (isStartCartService) {
            try {
                String cartOrder = orderView.receiveMessage();
                if (cartOrder.equals("0")) {
                    isStartCartService = false;
                } else {
                    String[] addMenus = cartOrder.split(" ");
                    checkOrderValidity(addMenus);

                    int menuId = Integer.parseInt(addMenus[0]);
                    int menuCount = Integer.parseInt(addMenus[1]);
                    String menuName = findMenuNameById(menuId);
                    int menuPrice = findMenuPriceById(menuId);
                    cartService.updateCart(menuId, menuCount, menuName, menuPrice);
                }
            } catch (InvalidInputException exception) {
                ExceptionHandler.handleInvalidInputException(exception);
            } catch (MenuNotFoundException exception) {
                ExceptionHandler.handleMenuNotFoundException(exception);
            }
        }
    }

    public void showCartView() {
        orderView.showCartPage(cartService.getOrderMenus(), cartService.getTotalCartSum());
    }

    public void showReceiveCartPageOptionNoticeView() {
        orderView.showReceiveCartOptionMessage();
    }

    public String receiveCartPageOption() {
        boolean isNotCorrectInput = true;
        String option = "";

        while (isNotCorrectInput) {
            option = orderView.receiveMessage();
            try {
                checkOptionValidity(option);
                isNotCorrectInput = false;
            } catch (InvalidInputException exception) {
                ExceptionHandler.handleInvalidInputException(exception);
            }
        }

        return option;
    }

    public void showReceiveEditItemToCartView() {
        orderView.showEditOrderNoticePage();
    }


    public void showPaymentView() {
        orderView.showPaymentPage();
    }

    public void processOrder() {
        orderService.placeOrder(storeName, userId, cartService.getTotalCartSum(), cartService.getOrderMenus());
    }

    public void showReceiptView() {
        orderView.showReceiptPage(cartService.getOrderMenus(), cartService.getTotalCartSum());
    }

    public String receiveOrderCompletedOption() {
        boolean isNotCorrectInput = true;
        String option = "";

        while (isNotCorrectInput) {
            option = orderView.receiveMessage();
            try {
                checkCompletedOptionValidity(option);
                isNotCorrectInput = false;
            } catch (InvalidInputException exception) {
                ExceptionHandler.handleInvalidInputException(exception);
            }
        }

        return option;
    }

    private void checkOrderValidity(String[] addMenus) throws InvalidInputException, MenuNotFoundException {
        if (addMenus.length != 2) {
            throw new InvalidInputException("InvalidInputException");
        }

        int menuId = Integer.parseInt(addMenus[0]);
        boolean isCorrectMenuId = false;

        for (Menu menu : currentMenus) {
            if (menu.getId() == menuId) {
                isCorrectMenuId = true;
                break;
            }
        }

        if (isCorrectMenuId == false) {
            throw new MenuNotFoundException("MenuNotFoundException");
        }
    }

    private void checkOptionValidity(String option) throws InvalidInputException {
        switch (option) {
            case "0", "1", "2":
                break;
            default:
                throw new InvalidInputException("InvalidInputException");
        }
    }

    private void checkCompletedOptionValidity(String option) throws InvalidInputException {
        switch (option) {
            case "0":
                break;
            default:
                throw new InvalidInputException("InvalidInputException");
        }
    }

    private String findMenuNameById(int menuId) {
        for (Menu menu : currentMenus) {
            if (menu.getId() == menuId) {
                return menu.getName();
            }
        }

        return null;
    }

    private int findMenuPriceById(int menuId) {
        for (Menu menu : currentMenus) {
            if (menu.getId() == menuId) {
                return menu.getPrice();
            }
        }

        return 0;
    }
}