package io.github.dhar135.unit_converter.service;

import io.github.dhar135.unit_converter.enums.LengthUnit;
import io.github.dhar135.unit_converter.enums.TempUnit;
import io.github.dhar135.unit_converter.enums.WeightUnit;
import org.springframework.stereotype.Service;

@Service
public class UnitConversionService {
    public double convertLength(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        double valueInMeters = value * fromUnit.getConversionFactorToMeter();
        return valueInMeters / toUnit.getConversionFactorToMeter();
    }

    public double convertWeight(double value, WeightUnit fromUnit, WeightUnit toUnit) {
        double valueInGrams = value * fromUnit.getConversionFactorToGram();
        return valueInGrams / toUnit.getConversionFactorToGram();
    }

    public double convertTemperature(double value, TempUnit fromUnit, TempUnit toUnit) {
        double celsius;

        switch (fromUnit) {
            case CELSIUS ->  celsius = value;
            case FAHRENHEIT -> celsius = (value - 32) *  5 / 9;
            case KELVIN -> celsius = value - 273.15;
            default -> throw new IllegalArgumentException("Unsupported Temperature Unit " + fromUnit);
        }

        switch (toUnit) {
            case CELSIUS -> {
                return celsius;
            }
            case FAHRENHEIT -> {
                return (celsius * 9 / 5) + 32;
            }
            case KELVIN -> {
                return celsius + 273.15;
            }
            default -> throw new IllegalArgumentException("Unsupported Temperature Unit " + toUnit);
        }
    }
}
