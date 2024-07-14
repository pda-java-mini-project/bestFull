package store.model;

public class Store {
    private String storeName;
    private String storeCategory;
    private String mainDish;
    private String storeLocation;
    private Menu menu;
    private int averagePrice;

    public Store(String storeName, String storeCategory, String mainDish, String storeLocation){
        this.storeName = storeName;
        this.storeCategory = storeCategory;
        this.mainDish = mainDish;
        this.storeLocation = storeLocation;
        this.menu = new Menu(storeName);
    }

    public void setAveragePrice() {
        averagePrice =  menu.getAveragePrice();
    }

    public String getStoreName() {
        return storeName;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public String getMainDish() {
        return mainDish;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public Menu getMenu() {
        return menu;
    }
}
