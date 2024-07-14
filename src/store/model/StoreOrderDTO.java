package store.model;

public class StoreOrderDTO {

    private MenuGM[] menus;
    private String storeName;

    public StoreOrderDTO(DishInfo[] dishInfos, String storeName) {
        menus = new MenuGM[dishInfos.length];

        for (int i = 0; i < dishInfos.length; i++) {
            DishInfo dishInfo = dishInfos[i];
            menus[i] = new MenuGM(dishInfo.getDishId(), dishInfo.getDishName(), dishInfo.getDishPrice(), dishInfo.getDishDescription());
        }

        this.storeName = storeName;
    }

    public MenuGM[] getMenus() {
        return menus;
    }

    public String getStoreName() {
        return storeName;
    }
}
