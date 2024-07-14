package order.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Order {
    private String storeName;
    private int ownerId;
    private int price;
    private Date date;
    private OrderMenu[] orderMenus;

    public Order(String storeName, int ownerId, int price, OrderMenu[] orderMenus) {
        this.storeName = storeName;
        this.ownerId = ownerId;
        this.price = price;
        LocalDateTime now = LocalDateTime.now();
        date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        this.orderMenus = orderMenus;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public OrderMenu[] getOrderMenus() {
        return orderMenus;
    }
}
