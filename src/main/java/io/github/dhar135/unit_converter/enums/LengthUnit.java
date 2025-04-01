package io.github.dhar135.unit_converter.enums;

public enum LengthUnit {
    MILLIMETER("mm", .001),
    CENTIMETER("cm", .01),
    METER("m", 1.0),
    KILOMETER("km", 1000),
    INCH("in", 0.0254),
    FOOT("ft", 0.3048),
    YARD("yd", 0.9144),
    MILE("mi", 1609.34);

    private final String symbol;
    private final double conversionFactorToMeter;

    private LengthUnit(String symbol,  double conversionFactorToMeter) {
        this.symbol = symbol;
        this.conversionFactorToMeter = conversionFactorToMeter;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getConversionFactorToMeter() {
        return conversionFactorToMeter;
    }
}
