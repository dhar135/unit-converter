package io.github.dhar135.unit_converter.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    // --- Optimization Start ---
    private static final Map<String, LengthUnit> SYMBOL_TO_UNIT_MAP;

    static {
        // Initialize map once, using lowercase symbols for case-insensitive lookup
        SYMBOL_TO_UNIT_MAP = Stream.of(values())
                .collect(Collectors.toMap(unit -> unit.getSymbol().toLowerCase(), Function.identity()));
    }

    public static LengthUnit fromSymbol(String symbol) {
        LengthUnit unit = SYMBOL_TO_UNIT_MAP.get(symbol.toLowerCase()); // Lookup in map (case-insensitive)
        if (unit == null) {
            throw new IllegalArgumentException("Invalid length unit symbol: " + symbol);
        }
        return unit;
    }
    // --- Optimization End ---

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
