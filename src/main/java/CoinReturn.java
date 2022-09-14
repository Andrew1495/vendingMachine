import java.util.ArrayList;
import java.util.HashMap;

public class CoinReturn {

    private ArrayList<Coin> changeReturn;


    public CoinReturn(){
        this.changeReturn = new ArrayList<Coin>();
    }

    public ArrayList<Coin> makeChange(int change, HashMap<CoinType, Integer> bank){
        if (change > 0) {
            while (change >= 200 && bank.get(CoinType.TWOPOUND) != 0) {
                addCoinReturn(CoinType.TWOPOUND);
                removeCoin(bank, CoinType.TWOPOUND);
                change -= 200;
            }
            while (change >= 100 && bank.get(CoinType.POUND) != 0) {
                addCoinReturn(CoinType.POUND);
                removeCoin(bank, CoinType.POUND);
                change -= 100;
            }
            while (change >= 50 && bank.get(CoinType.FIFTY) != 0) {
                addCoinReturn(CoinType.FIFTY);
                removeCoin(bank, CoinType.FIFTY);
                change -= 50;
            }
            while (change >= 20&& bank.get(CoinType.TWENTY) != 0) {
                addCoinReturn(CoinType.TWENTY);
                removeCoin(bank, CoinType.TWENTY);
                change -= 20;
            }
            while (change >=  10&& bank.get(CoinType.TEN) != 0) {
                addCoinReturn(CoinType.TEN);
                removeCoin(bank, CoinType.TEN);
                change -= 10;
            }
            while (change >= 5&& bank.get(CoinType.FIVE) != 0) {
                addCoinReturn(CoinType.FIVE);
                removeCoin(bank, CoinType.FIVE);
                change -= 5;
            }
        }
            return changeReturn;

    }

    public void addCoinReturn(CoinType coinType){
        Coin coin = new Coin(coinType);
        changeReturn.add(coin);

    }

    public ArrayList<Coin> getChangeReturn() {
        return changeReturn;
    }

    public void removeCoin(HashMap<CoinType, Integer> bank, CoinType coinType){
       Integer temp =  bank.get(coinType);
       temp -= 1;
       bank.put(coinType, temp);
    }

}
