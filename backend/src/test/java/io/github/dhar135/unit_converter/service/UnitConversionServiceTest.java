package io.github.dhar135.unit_converter.service;

import io.github.dhar135.unit_converter.enums.LengthUnit;
import io.github.dhar135.unit_converter.enums.TempUnit;
import io.github.dhar135.unit_converter.enums.WeightUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitConversionServiceTest {

    private UnitConversionService unitConversionService;
    private static final double DELTA = 0.001; // Tolerance for floating-point comparisons

    @BeforeEach
    void setUp() {
        unitConversionService = new UnitConversionService();
    }

    @Nested
    @DisplayName("Length Conversion Tests")
    class LengthConversionTests {

        @Test
        @DisplayName("Convert Meter to Meter (Identity)")
        void testConvertMeterToMeter() {
            assertEquals(10.0, unitConversionService.convertLength(10.0, LengthUnit.METER, LengthUnit.METER), DELTA);
        }

        @Test
        @DisplayName("Convert Meter to Kilometer")
        void testConvertMeterToKilometer() {
            assertEquals(1.5, unitConversionService.convertLength(1500.0, LengthUnit.METER, LengthUnit.KILOMETER), DELTA);
        }

        @Test
        @DisplayName("Convert Kilometer to Meter")
        void testConvertKilometerToMeter() {
            assertEquals(2500.0, unitConversionService.convertLength(2.5, LengthUnit.KILOMETER, LengthUnit.METER), DELTA);
        }

        @Test
        @DisplayName("Convert Inch to Centimeter")
        void testConvertInchToCentimeter() {
            // Assuming 1 inch = 2.54 cm = 0.0254 m
            assertEquals(25.4, unitConversionService.convertLength(10.0, LengthUnit.INCH, LengthUnit.CENTIMETER), DELTA);
        }

        @Test
        @DisplayName("Convert Foot to Meter")
        void testConvertFootToMeter() {
            // Assuming 1 foot = 0.3048 m
            assertEquals(3.048, unitConversionService.convertLength(10.0, LengthUnit.FOOT, LengthUnit.METER), DELTA);
        }

        @Test
        @DisplayName("Convert Mile to Kilometer")
        void testConvertMileToKilometer() {
            // Assuming 1 mile = 1.60934 km = 1609.34 m
            assertEquals(16.093, unitConversionService.convertLength(10.0, LengthUnit.MILE, LengthUnit.KILOMETER), DELTA);
        }

        @Test
        @DisplayName("Convert Zero Length")
        void testConvertZeroLength() {
            assertEquals(0.0, unitConversionService.convertLength(0.0, LengthUnit.METER, LengthUnit.FOOT), DELTA);
        }

        @Test
        @DisplayName("Convert Negative Length")
        void testConvertNegativeLength() {
            // Conversion factor should apply linearly
            assertEquals(-1.5, unitConversionService.convertLength(-1500.0, LengthUnit.METER, LengthUnit.KILOMETER), DELTA);
        }
    }

    @Nested
    @DisplayName("Weight Conversion Tests")
    class WeightConversionTests {

        @Test
        @DisplayName("Convert Gram to Gram (Identity)")
        void testConvertGramToGram() {
            assertEquals(50.0, unitConversionService.convertWeight(50.0, WeightUnit.GRAM, WeightUnit.GRAM), DELTA);
        }

        @Test
        @DisplayName("Convert Gram to Kilogram")
        void testConvertGramToKilogram() {
            assertEquals(0.5, unitConversionService.convertWeight(500.0, WeightUnit.GRAM, WeightUnit.KILOGRAM), DELTA);
        }

        @Test
        @DisplayName("Convert Kilogram to Gram")
        void testConvertKilogramToGram() {
            assertEquals(2500.0, unitConversionService.convertWeight(2.5, WeightUnit.KILOGRAM, WeightUnit.GRAM), DELTA);
        }

        @Test
        @DisplayName("Convert Pound to Kilogram")
        void testConvertPoundToKilogram() {
            // Assuming 1 lb = 0.453592 kg = 453.592 g
            assertEquals(4.536, unitConversionService.convertWeight(10.0, WeightUnit.POUND, WeightUnit.KILOGRAM), DELTA);
        }

        @Test
        @DisplayName("Convert Kilogram to Pound")
        void testConvertKilogramToPound() {
            // Assuming 1 kg = 2.20462 lb
            assertEquals(22.046, unitConversionService.convertWeight(10.0, WeightUnit.KILOGRAM, WeightUnit.POUND), DELTA);
        }

        @Test
        @DisplayName("Convert Ounce to Gram")
        void testConvertOunceToGram() {
            // Assuming 1 oz = 28.3495 g
            assertEquals(283.495, unitConversionService.convertWeight(10.0, WeightUnit.OUNCE, WeightUnit.GRAM), DELTA);
        }

        @Test
        @DisplayName("Convert Zero Weight")
        void testConvertZeroWeight() {
            assertEquals(0.0, unitConversionService.convertWeight(0.0, WeightUnit.KILOGRAM, WeightUnit.POUND), DELTA);
        }

        @Test
        @DisplayName("Convert Negative Weight")
        void testConvertNegativeWeight() {
            // Conversion factor should apply linearly
            assertEquals(-0.5, unitConversionService.convertWeight(-500.0, WeightUnit.GRAM, WeightUnit.KILOGRAM), DELTA);
        }
    }

    @Nested
    @DisplayName("Temperature Conversion Tests")
    class TemperatureConversionTests {

        // *** IMPORTANT NOTE: ***
        // The service method under test is named 'convertLength' in the original code,
        // but it takes TempUnit arguments and performs temperature conversion.
        // These tests assume temperature conversion logic but call the method
        // as 'convertLength' to match the provided service code.
        // It should ideally be renamed to 'convertTemperature'.

        @Test
        @DisplayName("Convert Celsius to Celsius (Identity)")
        void testConvertCelsiusToCelsius() {
            assertEquals(25.0, unitConversionService.convertTemperature(25.0, TempUnit.CELSIUS, TempUnit.CELSIUS), DELTA);
        }

        @Test
        @DisplayName("Convert Fahrenheit to Fahrenheit (Identity)")
        void testConvertFahrenheitToFahrenheit() {
            assertEquals(77.0, unitConversionService.convertTemperature(77.0, TempUnit.FAHRENHEIT, TempUnit.FAHRENHEIT), DELTA);
        }

        @Test
        @DisplayName("Convert Kelvin to Kelvin (Identity)")
        void testConvertKelvinToKelvin() {
            assertEquals(300.0, unitConversionService.convertTemperature(300.0, TempUnit.KELVIN, TempUnit.KELVIN), DELTA);
        }

        @Test
        @DisplayName("Convert Celsius to Fahrenheit (Freezing Point)")
        void testConvertCelsiusToFahrenheit_Freezing() {
            assertEquals(32.0, unitConversionService.convertTemperature(0.0, TempUnit.CELSIUS, TempUnit.FAHRENHEIT), DELTA);
        }

        @Test
        @DisplayName("Convert Celsius to Fahrenheit (Boiling Point)")
        void testConvertCelsiusToFahrenheit_Boiling() {
            assertEquals(212.0, unitConversionService.convertTemperature(100.0, TempUnit.CELSIUS, TempUnit.FAHRENHEIT), DELTA);
        }

        @Test
        @DisplayName("Convert Celsius to Fahrenheit (Negative)")
        void testConvertCelsiusToFahrenheit_Negative() {
            assertEquals(-4.0, unitConversionService.convertTemperature(-20.0, TempUnit.CELSIUS, TempUnit.FAHRENHEIT), DELTA);
        }

        @Test
        @DisplayName("Convert Celsius to Fahrenheit (Common Point -40)")
        void testConvertCelsiusToFahrenheit_CrossOver() {
            assertEquals(-40.0, unitConversionService.convertTemperature(-40.0, TempUnit.CELSIUS, TempUnit.FAHRENHEIT), DELTA);
        }

        @Test
        @DisplayName("Convert Fahrenheit to Celsius (Freezing Point)")
        void testConvertFahrenheitToCelsius_Freezing() {
            assertEquals(0.0, unitConversionService.convertTemperature(32.0, TempUnit.FAHRENHEIT, TempUnit.CELSIUS), DELTA);
        }

        @Test
        @DisplayName("Convert Fahrenheit to Celsius (Boiling Point)")
        void testConvertFahrenheitToCelsius_Boiling() {
            assertEquals(100.0, unitConversionService.convertTemperature(212.0, TempUnit.FAHRENHEIT, TempUnit.CELSIUS), DELTA);
        }

        @Test
        @DisplayName("Convert Fahrenheit to Celsius (Common Point -40)")
        void testConvertFahrenheitToCelsius_CrossOver() {
            assertEquals(-40.0, unitConversionService.convertTemperature(-40.0, TempUnit.FAHRENHEIT, TempUnit.CELSIUS), DELTA);
        }

        @Test
        @DisplayName("Convert Celsius to Kelvin (Absolute Zero)")
        void testConvertCelsiusToKelvin_AbsoluteZero() {
            assertEquals(0.0, unitConversionService.convertTemperature(-273.15, TempUnit.CELSIUS, TempUnit.KELVIN), DELTA);
        }

        @Test
        @DisplayName("Convert Celsius to Kelvin (Freezing Point)")
        void testConvertCelsiusToKelvin_Freezing() {
            assertEquals(273.15, unitConversionService.convertTemperature(0.0, TempUnit.CELSIUS, TempUnit.KELVIN), DELTA);
        }

        @Test
        @DisplayName("Convert Kelvin to Celsius (Absolute Zero)")
        void testConvertKelvinToCelsius_AbsoluteZero() {
            assertEquals(-273.15, unitConversionService.convertTemperature(0.0, TempUnit.KELVIN, TempUnit.CELSIUS), DELTA);
        }

        @Test
        @DisplayName("Convert Kelvin to Celsius (Freezing Point)")
        void testConvertKelvinToCelsius_Freezing() {
            assertEquals(0.0, unitConversionService.convertTemperature(273.15, TempUnit.KELVIN, TempUnit.CELSIUS), DELTA);
        }

        @Test
        @DisplayName("Convert Fahrenheit to Kelvin")
        void testConvertFahrenheitToKelvin() {
            // 50 F = 10 C = 283.15 K
            assertEquals(283.15, unitConversionService.convertTemperature(50.0, TempUnit.FAHRENHEIT, TempUnit.KELVIN), DELTA);
        }

        @Test
        @DisplayName("Convert Kelvin to Fahrenheit")
        void testConvertKelvinToFahrenheit() {
            // 300 K = 26.85 C = 80.33 F
            assertEquals(80.33, unitConversionService.convertTemperature(300.0, TempUnit.KELVIN, TempUnit.FAHRENHEIT), DELTA);
        }

        // NOTE: Testing the default case throwing IllegalArgumentException
        // is difficult here because you cannot pass an invalid enum value directly at compile time.
        // If the enums were guaranteed non-null, those default cases might be considered unreachable
        // through standard usage. Testing null inputs would check for NullPointerException earlier.
    }
}