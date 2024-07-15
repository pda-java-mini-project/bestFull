package order.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Order {
    private int id;
    private String storeName;
    private int ownerId;
    private int price;
    private Date date;
    private OrderMenu[] orderMenus;

    public Order(String storeName, int ownerId, int price, OrderMenu[] orderMenus) {
        this.id = 0;
        this.storeName = storeName;
        this.ownerId = ownerId;
        this.price = price;
        LocalDateTime now = LocalDateTime.now();
        date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        this.orderMenus = orderMenus;
    }

    public int getId() {
        return id;
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

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public OrderMenu[] getOrderMenus() {
        return orderMenus;
    }

    public void setId(int id) {
        this.id = id;
    }
}
