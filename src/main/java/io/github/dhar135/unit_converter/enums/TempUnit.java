package io.github.dhar135.unit_converter.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TempUnit {
    FAHRENHEIT("°F"),
    CELSIUS("°C"),
    KELVIN("K");

    private final String symbol;

    // --- Optimization Start ---
    private static final Map<String, TempUnit> SYMBOL_TO_UNIT_MAP;

    static {
        // Initialize map once, using lowercase symbols for case-insensitive lookup
        SYMBOL_TO_UNIT_MAP = Stream.of(values())
                .collect(Collectors.toMap(unit -> unit.getSymbol().toLowerCase(), Function.identity()));
    }

    public static TempUnit fromSymbol(String symbol) {
        TempUnit unit = SYMBOL_TO_UNIT_MAP.get(symbol.toLowerCase()); // Lookup in map (case-insensitive)
        if (unit == null) {
            throw new IllegalArgumentException("Invalid temperature unit symbol: " + symbol);
        }
        return unit;
    }
    // --- Optimization End ---

    TempUnit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
