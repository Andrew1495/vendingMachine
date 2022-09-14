import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {
    private ArrayList<Drawer> drawers;
    private HashMap<CoinType,Integer> bank;
    private ArrayList<Coin> inputMoney;
    private int userCredit;
    private CoinReturn coinReturn;

    public VendingMachine(ArrayList<Drawer> drawers, HashMap<CoinType, Integer> bank) {
        this.drawers = drawers;
        this.bank = bank;
        this.inputMoney = new ArrayList<Coin>();
        this.coinReturn = new CoinReturn();
        this.userCredit = totalCredit();
    }

    public ArrayList<Drawer> getDrawers() {
        return drawers;
    }

    public HashMap<CoinType, Integer> getBank() {
        return bank;
    }

    public ArrayList<Coin> getInputMoney() {
        return inputMoney;
    }

    public int getUserCredit() {
        return userCredit;
    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public void inputCoin(Coin coin){
        if(coin.getType() != CoinType.ONEPENCE || coin.getType() != CoinType.TWOPENCE) {
            inputMoney.add(coin);
            setUserCredit(totalCredit());

        }
        else {
            coinReturn.addCoinReturn(coin.getType());
        }
    }

    public void setUserCredit(int value) {
        this.userCredit += value;

    }

    public Product inputCode(Code code) {
        for (Drawer drawer : drawers) {
            if (code == drawer.getCode() && checkCredit(drawer.getProducts().get(0).getPrice())) {
                int change = totalCredit() - drawer.getProducts().get(0).getPrice();
                coinReturn.makeChange(change, bank);
                setUserCredit(-getUserCredit());
                Product item = drawer.getProducts().get(0);
                drawer.removeProduct();
                return item;

            }
        }
        return null;
    }



    public int totalCredit(){
        int total = 0;
        for (Coin coin: inputMoney) {
            total += coin.getValue();
        }
        return total;
    }

    public boolean checkCredit(int price){
        return price <= getUserCredit();
    }

}
