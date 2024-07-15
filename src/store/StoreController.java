package store;

import store.model.DishInfo;
import store.model.Store;
import store.model.StoreService;
import store.model.StoreOrderDTO;

import java.util.HashMap;

public class StoreController {

    StoreService storeService = new StoreService();
    StoreView storeView = new StoreView();

    public StoreOrderDTO startStore() {
        String category = "error";
        HashMap<String, Store> filteredStores = new HashMap<>();
        int storeNumber = 0;
        DishInfo[] dishInfoToArr = null;
        Store selectedStore = null;

        while(category.equals("error") || storeNumber == 0) {
            category = receiveCategory();
            if(category == null) return null;
            if(category.equals("error")) {
                continue;
            }

            while(selectedStore == null) {
                filteredStores = getFilterStores(category);
                storeNumber = receiveStoreNumber(category, filteredStores);
                if(storeNumber == 0) {
                    break;
                }

                selectedStore = showSelectedStore(storeNumber, filteredStores);
                if(selectedStore == null) {
                    continue;
                }

                int orderCommand = receiveOrderCommand(selectedStore);
                if(orderCommand != 1) {
                    selectedStore = null;
                    continue;
                }

                dishInfoToArr = storeService.convertDishInfoToArr(selectedStore);
            }
        }

        return new StoreOrderDTO(dishInfoToArr, selectedStore.getStoreName());
    }

    private String receiveCategory() {
        int receivedCategoryNumber = storeView.printCategory();
        if(receivedCategoryNumber == 0) return null;
        String receivedCategory = storeService.categoryToStirng(receivedCategoryNumber);
        if(receivedCategory.equals("error")) {
            storeView.printErrorMessage();
            return "error";
        }
        return receivedCategory;
    }

    private HashMap<String, Store> getFilterStores(String category) {
        HashMap<String, Store> filteredStores = storeService.filterStores(category);
        return filteredStores;
    }

    private int receiveStoreNumber(String category, HashMap<String, Store> filteredStores) {
        int receivedStoreNumber = storeView.printSelectedStores(category, filteredStores);
        return receivedStoreNumber;
    }

    private Store showSelectedStore(int storeNumber, HashMap<String, Store> filteredStores) {
        Store selectStore = storeService.selectStore(storeNumber, filteredStores);
        if(selectStore == null) {
            storeView.printErrorMessage();
            return null;
        }
        return selectStore;
    }

    private int receiveOrderCommand(Store selectedStore) {
        int receivedOrderNumber = storeView.printStoreInfo(selectedStore);
        if(receivedOrderNumber != 1) {
            if(receivedOrderNumber != 0) {
                storeView.printErrorMessage();
            }
        }
        return receivedOrderNumber;
    }
}
