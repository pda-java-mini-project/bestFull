package store;

import store.model.Menu;
import store.model.MenuGM;
import store.model.Store;
import store.model.DishInfo;
import java.util.HashMap;
import java.util.Scanner;

public class StoreView {
    Scanner sc = new Scanner(System.in);

    public int printCategory() {
        System.out.println("******************************* 카테고리 선택 *******************************");
        System.out.println("                        음식 카테고리 번호를 입력해주세요.                        ");
        System.out.println("                0.홈으로 돌아가기 1.한식 2.중식 3.일식 4.양식 5.기타                ");
        System.out.println("**************************************************************************");
        System.out.print("입력: ");
        return sc.nextInt();
    }

    public int printSelectedStores(String category, HashMap<String, Store> filteredStores) {
        System.out.println();
        System.out.println("******************************** 가게 리스트 ********************************");
        System.out.println("                         " + category + "에 해당하는 가게 리스트 입니다.                  ");
        System.out.println("[가게번호]   [가게이름]   [주메뉴]   [평균가]");

        int storeNum = 1;
        for (String storeName : filteredStores.keySet()) {
            Store thisStore = filteredStores.get(storeName);
            System.out.println("["+(storeNum++)+"] " + storeName + " " + thisStore.getMainDish() + " " + thisStore.getAveragePrice());
        }
        System.out.println("**************************************************************************");
        System.out.println("0.카테고리 변경으로 돌아가기");
        System.out.println("N.가게 메뉴 상세보기 [N:가게번호]");
        System.out.println("**************************************************************************");
        System.out.print("입력: ");

        int storeCommand = sc.nextInt();
        return storeCommand;
    }

    public int printStoreInfo(Store selectedStore) {
        String storeName = selectedStore.getStoreName();
        String storeCategory = selectedStore.getStoreCategory();
        String mainDish = selectedStore.getMainDish();
        String storeLocation = selectedStore.getStoreLocation();
        Menu menu = selectedStore.getMenu();

        System.out.println();
        System.out.println("*************************** 가게 상세 페이지 입니다 ***************************");
        System.out.println("            " + storeName + "은(는) " + storeLocation + "에 위치해 있고 " + mainDish + "이(가) 주력 메뉴입니다!     ");
        System.out.println("**************************************************************************");
        System.out.println("                                 메뉴판                                     ");
        System.out.println("[메뉴번호]          [메뉴이름]          [메뉴가격]          [메뉴설명]             ");
        for (Integer menuId : menu.getDishes().keySet()) {
            DishInfo dishInfo = menu.getDishes().get(menuId);
            System.out.println("["+dishInfo.getDishId()+"] " + dishInfo.getDishName() + " " + dishInfo.getDishPrice() + " " + dishInfo.getDishDescription());
        }
        System.out.println("**************************************************************************");
        System.out.println("                                옵션 선택                                   ");
        System.out.println("                    0.가게 리스트로 돌아가기 1.주문하기                           ");
        System.out.println("**************************************************************************");
        System.out.print("입력: ");

        int orderCommand = sc.nextInt();
        return orderCommand;
    }

    public void printErrorMessage() {
        System.out.println("없는 번호 입니다. 번호를 다시 입력해주세요.");
        System.out.println();
    }
}
