package store.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StoreModel {
    private HashMap<String, Store> stores;
    private StoreDB storeData;

    public StoreModel() {
        storeData = new StoreDB();
        stores = new HashMap<>();
        stores = storeData.setStoreInformation();
    }

    public HashMap<String, Store> getStores() {
        return stores;
    }

    public Store getStore(String storeName) {
        return stores.get(storeName);
    }

    public HashMap<String, Store> filterStores(String category) {
        HashMap<String, Store> selectedStore = new HashMap<>( stores.entrySet().stream()
                .filter(entry -> entry.getValue().getStoreCategory().equals(category))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue())));

        return selectedStore;
    }

    public String categoryToStirng(int categoryNumber) {
        String category = "";
        switch (categoryNumber) {
            case 0:
                category = "홈";
                break;
            case 1:
                category = "한식";
                break;
            case 2:
                category = "중식";
                break;
            case 3:
                category = "일식";
                break;
            case 4:
                category = "양식";
                break;
            case 5:
                category = "기타";
                break;
            default:
                category = "error";
                break;
        }
        return category;
    }

    public Store selectStore(int selectedStoreNumber, HashMap<String, Store> filterdStores) {
        Store selectedStore = null;

        int storeNum = 1;
        for (String storeName : filterdStores.keySet()) {
            if (storeNum == selectedStoreNumber) {
                selectedStore = filterdStores.get(storeName);
                break;
            }
            storeNum++;
        }

        return selectedStore;
    }

    public DishInfo[] convertDishInfoToArr(Store selectedStore) {
        Menu menu = selectedStore.getMenu();
        ArrayList<DishInfo> dishInfoToArrayList = new ArrayList<>();

        for (Integer menuId : menu.getDishes().keySet()) {
            DishInfo dishInfo = menu.getDishes().get(menuId);
            dishInfoToArrayList.add(dishInfo);
        }

        DishInfo[] dishInfoToArr = new DishInfo[dishInfoToArrayList.size()];
        dishInfoToArr = dishInfoToArrayList.toArray(dishInfoToArr);
        return dishInfoToArr;
    }
}
