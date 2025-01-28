public enum Denomination {
    ONE_PESO(1, "1 PHP Coins"),
    FIVE_PESO(5, "5 PHP Coins"),
    TEN_PESO(10, "10 PHP Coins"),
    TWENTY_PESO(20, "20 PHP Bills"),
    FIFTY_PESO(50, "50 PHP Bills"),
    ONE_HUNDRED_PESO(100, "100 PHP Bills"),
    TWO_HUNDRED_PESO(200, "200 PHP Bills"),
    FIVE_HUNDRED_PESO(500, "500 PHP Bills"),
    ONE_THOUSAND_PESO(1000, "1000 PHP Bills");

    private final int value;
    private final String description;

    Denomination(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public void processInput(Money vmMoney) {
        int count = Helper.scanDenominationCount(description);
        Helper.updateMoney(vmMoney, this, count);
    }
}
