package store.model;

public class DishInfo {
    private int dishId;
    private String dishName;
    private int dishPrice;
    private String dishDescription;

    public DishInfo(int dishId, String dishName, int dishPrice, String dishDescription){
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishDescription = dishDescription;
    }

    public int getDishId() {
        return dishId;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public  String getDishName() {
        return dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }
}
