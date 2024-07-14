package store;

import store.model.DishInfo;
import store.model.Store;
import store.model.StoreModel;
import store.model.StoreOrderDTO;

import java.util.HashMap;

public class StoreController {

    StoreModel storeModel = new StoreModel();
    StoreView storeView = new StoreView();

    public StoreOrderDTO startStore() {
        int categoryNumber = 0;
        String category = "error";
        HashMap<String, Store> filteredStores = new HashMap<>();
        int storeNumber = 0;
        DishInfo[] dishInfoToArr = null;
        Store selectedStore = null;

        while(category.equals("error") || storeNumber == 0) {
            categoryNumber = storeView.printCategory();
            category = storeModel.categoryToStirng(categoryNumber);
            if(category.equals("error")) {
                storeView.printErrorMessage();
                continue;
            }


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

        return new StoreOrderDTO(dishInfoToArr, selectedStore.getStoreName());
    }
}
