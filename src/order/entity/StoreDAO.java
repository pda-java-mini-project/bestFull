package order.entity;
import java.util.HashMap;
import java.util.*;
public class StoreDAO {
    private Map<Integer, Category> categoryMap;

    public StoreDAO() {
        categoryMap = new HashMap<>();
        initializeStores();
    }

    private void initializeStores() {
        List<Menu> menuList1 = new ArrayList<>();
        menuList1.add(new Menu(1, "마라탕", 12000, "매운 마라탕"));
        menuList1.add(new Menu(2, "마라샹궈", 15000, "마라샹궈"));

        List<Menu> menuList2 = new ArrayList<>();
        menuList2.add(new Menu(1, "칼국수", 8000, "쫄깃한 칼국수"));
        menuList2.add(new Menu(2, "해물 칼국수", 10000, "신선한 해물 칼국수"));
        menuList2.add(new Menu(3, "매운 칼국수", 8000, "쫄깃한 칼국수"));
        menuList2.add(new Menu(4, "짜장 칼국수", 10000, "신선한 해물 칼국수"));

        Store store1 = new Store(1, "라화쿵부", "서울 강남구", "마라탕", menuList1);
        Store store2 = new Store(2, "조조칼국수", "서울 서초구", "칼국수", menuList2);

        List<Store> koreanStores = new ArrayList<>();
        koreanStores.add(store1);
        koreanStores.add(store2);

        categoryMap.put(1, new Category(1, "한식", koreanStores));
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categoryMap.values());
    }

    public Category getCategoryById(int categoryId) {
        return categoryMap.get(categoryId);
    }

    public Store getStoreById(int categoryId, int storeNumber) {
        Category category = categoryMap.get(categoryId);
        if (category != null) {
            for (Store store : category.getStoreList()) {
                if (store.getStoreNumber() == storeNumber) {
                    return store;
                }
            }
        }
        return null;
    }

    public Menu getMenuById(int categoryId, int storeNumber, int menuNumber) {
        Store store = getStoreById(categoryId, storeNumber);
        if (store != null) {
            for (Menu menu : store.getMenuList()) {
                if (menu.getMenuNumber() == menuNumber) {
                    return menu;
                }
            }
        }
        return null;
    }
}

