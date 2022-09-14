import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinTest {

    Coin coin;
    @Before
    public void setUp()  {
      coin = new Coin(CoinType.POUND);

    }

    @Test
    public void getType() {
        assertEquals(CoinType.POUND, coin.getType());
    }

    @Test
    public void getValue() {
        assertEquals(100, coin.getValue());
    }
}