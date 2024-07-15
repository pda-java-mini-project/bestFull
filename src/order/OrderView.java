package order;

import order.model.Order;
import order.model.OrderMenu;

import java.util.Scanner;

public class OrderView {
    private final Scanner scanner = new Scanner(System.in);
    public void showOrderNoticePage() {
        System.out.println("*************************** 주문 페이지 ****************************\n" +
                            "               메뉴 번호와 수량을 스페이스 간격을 두고 입력해주세요.         \n" +
                            "                   여러 메뉴를 원할 경우 엔터로 구분해주세요.             \n" +
                            "                   메뉴를 모두 선택하셨으면 0번을 입력해주세요.           \n" +
                            "****************************************************************");
    }
    public String receiveMessage() {
        System.out.print("                  입력: ");
        return scanner.nextLine();
    }

    public void showCartPage(OrderMenu[] orderMenus, int totalCartSum) {
        System.out.println("*************************** 장바구니 페이지 ****************************\n");
        showDinamicOrderMenus(orderMenus, totalCartSum);
    }

    public void showReceiveCartOptionMessage() {
        System.out.println("                              옵션선택                                    \n"+
                         "0. 주문 취소하고 홈으로 이동하기             1. 주문 수정하기              2. 결제하기");
    }

    public void showEditOrderNoticePage() {
        System.out.println("*************************** 주문 수정 페이지 ****************************\n" +
                            "               수정하길 원하는 메뉴번호와 수량을 스페이스 간격을 두고 입력해주세요\n" +
                            "                   수량을 0으로 입력하면 해당 메뉴는 삭제됩니다\n" +
                            "                   여러 메뉴를 원할 경우 엔터로 구분해주세요.\n" +
                            "                   메뉴를 모두 선택하셨으면 0번을 입력해주세요.\n" +
                            "****************************************************************");
    }

    public void showPaymentPage() {
        System.out.println("*************************** 결제 페이지 ****************************\n" +
                            "                       결제 방식을 선택해주세요\n" +
                            "            0. 장바구니로 돌아가기      1. 카드       2. 현금\n" +
                            "****************************************************************");
    }

    public void showReceiptPage(OrderMenu[] orderMenus, int totalCartSum) {
        System.out.println("*************************** 영수증 페이지 ****************************\n" +
                        "                      결제가 완료되었습니다!\n\n");
        showDinamicOrderMenus(orderMenus, totalCartSum);
        System.out.println("                    BESTful을 이용해주셔서 감사합니다 ^^\n" +
                            "                      0. 홈으로 이동하기\n" +
                            "*********************************************************************");
    }

    public void showOrderDetailPage(OrderMenu[] orderMenus, int totalCartSum) {
        System.out.println("*************************** 주문 상세 내역 ****************************");
        showDinamicOrderMenus(orderMenus, totalCartSum);
        System.out.println("                            0. 홈으로 돌아가기\n" +
                            "*********************************************************************");
    }

    private void showDinamicOrderMenus(OrderMenu[] orderMenus, int totalCartSum) {
        System.out.println("[메뉴번호]\t\t메뉴명\t\t개수\t\t총액(가격 * 개수)");
        for(OrderMenu orderMenu : orderMenus) {
            System.out.println(String.format("[%s]\t\t%s\t\t%s\t\t%,d(%,d * %d)",
                    orderMenu.getId(),
                    orderMenu.getName(),
                    orderMenu.getCount(),
                    orderMenu.getTotalPrice(),
                    orderMenu.getPrice(),
                    orderMenu.getCount()));
        }

        System.out.println("                       ***********************");
        System.out.println(String.format("                              = %,d(원)", totalCartSum));
        System.out.println("*********************************************************************");
    }

    public void showOrderedPage(Order[] orders) {
        System.out.println("*************************** 주문 내역 ****************************");
        System.out.println("[주문번호]\t\t주문일[내림차순]\t\t가게명\t\t주문총액");
        for (Order order : orders) {
            System.out.println(String.format("[%s]\t\t%s\t\t%s\t\t%,d원",
                    order.getId(),
                    order.getDate(),
                    order.getStoreName(),
                    order.getPrice()));
        }

        System.out.println("                       0. 홈으로 돌아가기\n" +
                "                N.주문내역 상세보기 [N: 주문 번호]\n" +
                "*********************************************************************");
    }
}
