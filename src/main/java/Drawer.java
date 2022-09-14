import java.lang.reflect.Array;
import java.util.ArrayList;

public class Drawer {

    private Code code;

    private ArrayList<Product> products;

    public Drawer(Code code, Product product, int amount){
        this.code = code;
        this.products = buildArray(product, amount);
    }

    private ArrayList<Product> buildArray(Product product, int amount){
        ArrayList<Product> temp = new ArrayList<Product>();
        for (int i = 0; i < amount ; i++) {
            temp.add(product);
        }
        return temp;
    }

    public Code getCode() {
        return code;
    }
    public void removeProduct(){
        products.remove(0);
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void reStock(int amount){
            for (int i = 0; i <amount ; i++) {
                products.add(products.get(0));
            }
    }


    public void changeProduct(Product product, int amount){
        ArrayList<Product> temp = new ArrayList<Product>();
        for (int i = 0; i < amount ; i++) {
            temp.add(product);
        }
        this.products = temp;
        }


}
