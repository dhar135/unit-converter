package io.github.dhar135.unit_converter.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WeightUnit {
    MILLIGRAM("mg", 0.001),
    GRAM("g", 1.0),
    KILOGRAM("kg", 1000),
    OUNCE("oz", 28.3495),
    POUND("lb", 453.592);

    private final String symbol;
    private final double conversionFactorToGram;

    // --- Optimization Start ---
    private static final Map<String, WeightUnit> SYMBOL_TO_UNIT_MAP;

    static {
        // Initialize map once, using lowercase symbols for case-insensitive lookup
        SYMBOL_TO_UNIT_MAP = Stream.of(values())
                .collect(Collectors.toMap(unit -> unit.getSymbol().toLowerCase(), Function.identity()));
    }

    public static WeightUnit fromSymbol(String symbol) {
        WeightUnit unit = SYMBOL_TO_UNIT_MAP.get(symbol.toLowerCase()); // Lookup in map (case-insensitive)
        if (unit == null) {
            throw new IllegalArgumentException("Invalid length unit symbol: " + symbol);
        }
        return unit;
    }
    // --- Optimization End ---

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

