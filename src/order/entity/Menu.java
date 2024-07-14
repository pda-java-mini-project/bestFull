package order.entity;

public class Menu {
    private int menuNumber;
    private String menuName;
    private int menuPrice;
    private String menuDescription;

    public Menu(int menuNumber, String menuName, int menuPrice, String menuDescription) {
        this.menuNumber = menuNumber;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuNumber=" + menuNumber +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuDescription='" + menuDescription + '\'' +
                '}';
    }
}
