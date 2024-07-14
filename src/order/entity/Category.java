package order.entity;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private List<Store> storeList;

    public Category(int categoryId, String categoryName, List<Store> storeList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.storeList = storeList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }
}
