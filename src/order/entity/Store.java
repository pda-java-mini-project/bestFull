package order.entity;
import java.util.List;

public class Store {
    private int storeNumber;
    private String storeName;
    private String location;
    private String mainMenu;
    private List<Menu> menuList;

    public Store(int storeNumber, String storeName, String location, String mainMenu, List<Menu> menuList) {
        this.storeNumber = storeNumber;
        this.storeName = storeName;
        this.location = location;
        this.mainMenu = mainMenu;
        this.menuList = menuList;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeNumber=" + storeNumber +
                ", storeName='" + storeName + '\'' +
                ", location='" + location + '\'' +
                ", mainMenu='" + mainMenu + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
