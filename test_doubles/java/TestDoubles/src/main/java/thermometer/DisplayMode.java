package thermometer;

public enum DisplayMode {
    CELSIUS("C"), FAHRENHEIT("F");

    private String symbol;

    private DisplayMode(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
