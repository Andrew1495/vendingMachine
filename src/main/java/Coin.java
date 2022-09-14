public class Coin {
    private final CoinType type;

    public Coin(CoinType coinType){
        this.type = coinType;
    }

    public CoinType getType() {
        return type;
    }

    public int getValue(){
        return type.getValue();
    }
}
