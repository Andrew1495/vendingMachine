import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SweetTest {

    Sweet sweet;

    @Before
    public void setUp() {
        sweet = new Sweet("kit-kat", "Nestle", 65);
    }

    @Test
    public void getBrand() {
        assertEquals("Nestle", sweet.getBrand());
    }

    @Test
    public void getName() {
        assertEquals("kit-kat", sweet.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(65, sweet.getPrice());
    }
}