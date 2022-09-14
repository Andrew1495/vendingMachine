public enum CoinType {
    ONEPENCE(1),
    TWOPENCE(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    POUND(100),
    TWOPOUND(200);

    private int value;

    public int getValue() {
        return value;
    }

    CoinType(int val){
        this.value = val;
    }


}
