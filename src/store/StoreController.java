package store;

import store.model.DishInfo;
import store.model.Store;
import store.model.StoreModel;
import java.util.HashMap;

public class StoreController {
    public DishInfo[] startStore() {
        StoreModel storeModel = new StoreModel();
        StoreView storeView = new StoreView();
        int categoryNumber = 0;
        String category = "error";
        HashMap<String, Store> filteredStores = new HashMap<>();
        int storeNumber = 0;
        DishInfo[] dishInfoToArr = null;

        while(category.equals("error") || storeNumber == 0) {
            categoryNumber = storeView.printCategory();
            category = storeModel.categoryToStirng(categoryNumber);
            if(category.equals("error")) {
                storeView.printErrorMessage();
                continue;
            }

            Store selectedStore = null;
            while(selectedStore == null) {
                filteredStores = storeModel.filterStores(category);
                storeNumber = storeView.printSelectedStores(category, filteredStores);
                if(storeNumber == 0) {
                    break;
                }
                selectedStore = storeModel.selectStore(storeNumber, filteredStores);
                if(selectedStore == null) {
                    storeView.printErrorMessage();
                    continue;
                }
                int orderCommand = storeView.printStoreInfo(selectedStore);
                if(orderCommand != 1) {
                    selectedStore = null;
                    if(orderCommand != 0) {
                        storeView.printErrorMessage();
                    }
                    continue;
                }
                dishInfoToArr = storeModel.convertDishInfoToArr(selectedStore);

            }
        }
        return dishInfoToArr;
    }
}
