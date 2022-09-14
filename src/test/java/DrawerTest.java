import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawerTest {

    Drawer drawer;
    Sweet kitkat;

    @Before
    public void setUp(){
        kitkat = new Sweet("kit-kat","Nestle", 50);
        drawer = new Drawer(Code.A1, kitkat, 10 );
    }

    @Test
    public void getCode() {
        assertEquals(Code.A1, drawer.getCode());
    }

    @Test
    public void getProducts() {
        assertEquals(10, drawer.getProducts().size());
    }

    @Test
    public void reStock(){
        drawer.reStock(10);
        assertEquals(20, drawer.getProducts().size());
    }

    public void changeStock(){
        drawer.changeProduct(kitkat, 2);
        assertEquals(2, drawer.getProducts().size());
    }
}
