package io.github.dhar135.unit_converter.enums;

public enum TempUnit {
    FAHRENHEIT("°F"),
    CELSIUS("°C"),
    KELVIN("K");

    private final String symbol;

    private TempUnit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
