public abstract class Product {
    protected String brand;
    protected String name;

    protected  int price;

    public Product(String name, String brand, int price){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
