package store.model;


public class Menu {
    private int id;
    private String name;
    private int price;

    private String content;

    public Menu(int id, String name, int price, String content) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }
}
