package io.github.dhar135.unit_converter.enums;

public enum WeightUnit {
    MILLIGRAM("mg", 0.001),
    GRAM("g", 1.0),
    KILOGRAM("kg", 1000),
    OUNCE("oz", 28.3495),
    POUND("lb", 453.592);

    private final String symbol;
    private final double conversionFactorToGram;

    private WeightUnit(String symbol, double conversionFactorToGram) {
        this.symbol = symbol;
        this.conversionFactorToGram = conversionFactorToGram;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getConversionFactorToGram() {
        return conversionFactorToGram;
    }
}

