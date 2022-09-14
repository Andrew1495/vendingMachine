import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class VendingMachineTest {
    Sweet kitkat;
    Drink cola;
    Crisp walkers;
    VendingMachine vendingMachine;
    Drawer drawer;
    Drawer drawer2;
    Drawer drawer3;
    ArrayList<Drawer> drawers;
    ArrayList<Coin> input;
    Coin onePound;
    Coin twoPound;
    Coin fifty;
    Coin twenty;
    Coin ten;
    Coin five;
    Coin onePence;
    HashMap<CoinType, Integer> bank;



    @Before
    public void setUp()  {
        onePence = new Coin(CoinType.ONEPENCE);
        five = new Coin(CoinType.FIVE);
        ten = new Coin(CoinType.TEN);
        twenty = new Coin(CoinType.TWENTY);
        fifty = new Coin(CoinType.FIFTY);
        onePound = new Coin(CoinType.POUND);
        twoPound = new Coin(CoinType.TWOPOUND);
        kitkat = new Sweet("kit-kat", "Nestle", 65);
        cola = new Drink("cola", "cola", 100);
        walkers = new Crisp("walker", "walker", 50);
        drawer = new Drawer(Code.A1,kitkat,10);
        drawer2 = new Drawer(Code.A2,cola,10);
        drawer3 = new Drawer(Code.A3,walkers,10);
        drawers = new ArrayList<Drawer>();
        drawers.add(drawer);
        drawers.add(drawer2);
        drawers.add(drawer3);
        bank = new HashMap<CoinType, Integer>();
        bank.put(CoinType.TWOPOUND,30);
        bank.put(CoinType.POUND,10);
        bank.put(CoinType.FIFTY,5);
        bank.put(CoinType.TWENTY,11);
        bank.put(CoinType.TEN,15);
        bank.put(CoinType.FIVE,15);

        vendingMachine = new VendingMachine(drawers, bank);

    }

    @Test
    public void inputCoin() {
        vendingMachine.inputCoin(ten);
        assertEquals(1 ,vendingMachine.getInputMoney().size() );
    }


    @Test
    public void totalCredit() {
        vendingMachine.inputCoin(ten);
        assertEquals(10, vendingMachine.totalCredit());
    }

    @Test
    public void inputCode() {
        vendingMachine.inputCoin(onePound);
        vendingMachine.inputCoin(onePound);
        assertEquals(cola, vendingMachine.inputCode(Code.A2));
    }

    @Test
    public void change() {
        vendingMachine.inputCoin(onePound);
        vendingMachine.inputCoin(onePound);
        vendingMachine.inputCode(Code.A2);
        assertEquals(onePound.getValue(), vendingMachine.getCoinReturn().getChangeReturn().get(0).getValue());
    }


}