package order;
import order.entity.CartItem;
import order.entity.Order;

import java.util.Map;
import java.util.Scanner;

public class OrderView {
    Scanner scanner = new Scanner(System.in);

    public void showOrderNoticeView() {
        System.out.println("*************************** 주문 페이지 ****************************\n메뉴 번호와 수량을 스페이스 간격을 두고 입력해주세요.\n여러 메뉴를 원할 경우 엔터로 구분해주세요.\n메뉴를 모두 선택하셨으면 0번을 입력해주세요.\n***************************************************************\n입력: ");
    }

    public int showCartNoticeView(Map<Integer, CartItem> cartItems, int totalPrice) {
        System.out.println("*************************** 장바구니 페이지 ****************************");
        for(CartItem item: cartItems.values()){
            System.out.println(item);
        }
        System.out.println("----------\n="+totalPrice);
        System.out.println("***************************************************************\n옵션 선택\n0. 주문 취소하고 홈으로 이동하기  1. 주문 수정하기  2. 결제하기\n입력: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showUpdateOrderNoticePage() {
        System.out.println("*************************** 주문 수정 페이지 ****************************\n수정하길 원하는 메뉴번호와 수량을 스페이스 간격을 두고 입력해주세요\n수량을 0으로 입력하면 해당 메뉴는 삭제됩니다\n여러 메뉴를 원할 경우 엔터로 구분해주세요.\n메뉴를 모두 선택하셨으면 0번을 입력해주세요.\n***************************************************************\n입력: ");

    }

    public int showPayNoticeView() {
        System.out.println("*************************** 결제 페이지 ****************************\n결제 방식을 선택해주세요\n0. 장바구니로 돌아가기 1. 카드 2 현금\n***********************************************************\n입력: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int showReceiptNoticeView(Map<Integer, Order> orders) {
        System.out.println("*************************** 영수증 페이지 ****************************\n결제가 완료되었습니다!");
        for (Order order : orders.values()) {
            System.out.println(order);
        }
        System.out.println("***********************************************************\nBESTful을 이용해주셔서 감사합니다 ^^\n0. 홈으로 이동하기\n***********************************************************\n입력: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getInput(){
        return scanner.nextLine();
    }

}
