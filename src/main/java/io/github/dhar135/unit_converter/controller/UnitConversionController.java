package io.github.dhar135.unit_converter.controller;

import io.github.dhar135.unit_converter.enums.LengthUnit;
import io.github.dhar135.unit_converter.enums.TempUnit;
import io.github.dhar135.unit_converter.enums.WeightUnit;
import io.github.dhar135.unit_converter.service.UnitConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UnitConversionController {

    private final UnitConversionService unitConversionService;

    public UnitConversionController(UnitConversionService unitConversionService) {
        this.unitConversionService = unitConversionService;
    }

    // Home page route
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    // Length converter page routes
    @GetMapping("/length-converter")
    public String lengthConverterPage() {
        return "length/index";
    }

    @PostMapping("/convert-length")
    public String convertLength(
            @RequestParam("value") double value,
            @RequestParam("fromUnit") String fromUnitString,
            @RequestParam("toUnit") String toUnitString,
            Model model) {

        try {
            LengthUnit fromUnit = LengthUnit.fromSymbol(fromUnitString);
            LengthUnit toUnit = LengthUnit.fromSymbol(toUnitString);

            double result = unitConversionService.convertLength(value, fromUnit, toUnit);

            // Add all values to the model to display on the page
            model.addAttribute("value", value);
            model.addAttribute("fromUnit", fromUnitString);
            model.addAttribute("toUnit", toUnitString);
            model.addAttribute("result", result);

        } catch (Exception e) {
            // Handle errors
            model.addAttribute("error", "Error: " + e.getMessage());
            model.addAttribute("value", value);
            model.addAttribute("fromUnit", fromUnitString);
            model.addAttribute("toUnit", toUnitString);
        }

        return "length/index";
    }

    // Weight converter page routes
    @GetMapping("/weight-converter")
    public String weightConverterPage() {
        return "weight/index";
    }

    @PostMapping("/convert-weight")
    public String convertWeight(
            @RequestParam("value") double value,
            @RequestParam("fromUnit") String fromUnitString,
            @RequestParam("toUnit") String toUnitString,
            Model model) {

        try {
            WeightUnit fromUnit = WeightUnit.fromSymbol(fromUnitString);
            WeightUnit toUnit = WeightUnit.fromSymbol(toUnitString);

            double result = unitConversionService.convertWeight(value, fromUnit, toUnit);

            // Add all values to the model to display on the page
            model.addAttribute("value", value);
            model.addAttribute("fromUnit", fromUnitString);
            model.addAttribute("toUnit", toUnitString);
            model.addAttribute("result", result);

        } catch (Exception e) {
            // Handle errors
            model.addAttribute("error", "Error: " + e.getMessage());
            model.addAttribute("value", value);
            model.addAttribute("fromUnit", fromUnitString);
            model.addAttribute("toUnit", toUnitString);
        }

        return "weight/index";
    }

    // Temperature converter page routes
    @GetMapping("/temperature-converter")
    public String temperatureConverterPage() {
        return "temperature/index";
    }

    @PostMapping("/convert-temperature")
    public String convertTemperature(
            @RequestParam("value") double value,
            @RequestParam("fromUnit") String fromUnitString,
            @RequestParam("toUnit") String toUnitString,
            Model model) {

        try {
            TempUnit fromUnit = TempUnit.fromSymbol(fromUnitString);
            TempUnit toUnit = TempUnit.fromSymbol(toUnitString);

            double result = unitConversionService.convertTemperature(value, fromUnit, toUnit);

            // Add all values to the model to display on the page
            model.addAttribute("value", value);
            model.addAttribute("fromUnit", fromUnitString);
            model.addAttribute("toUnit", toUnitString);
            model.addAttribute("result", result);

        } catch (Exception e) {
            // Handle errors
            model.addAttribute("error", "Error: " + e.getMessage());
            model.addAttribute("value", value);
            model.addAttribute("fromUnit", fromUnitString);
            model.addAttribute("toUnit", toUnitString);
        }

        return "temperature/index";
    }

    // Keep the original REST API endpoints for possible future use
    @GetMapping("/api/length")
    @ResponseBody
    public ResponseEntity<Double> apiConvertLength(
            @RequestParam("value") double value,
            @RequestParam("from") String fromUnitString,
            @RequestParam("to") String toUnitString) {

        LengthUnit fromUnit = LengthUnit.fromSymbol(fromUnitString);
        LengthUnit toUnit = LengthUnit.fromSymbol(toUnitString);

        double result = unitConversionService.convertLength(value, fromUnit, toUnit);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/weight")
    @ResponseBody
    public ResponseEntity<Double> apiConvertWeight(
            @RequestParam("value") double value,
            @RequestParam("from") String fromUnitString,
            @RequestParam("to") String toUnitString) {

        WeightUnit fromUnit = WeightUnit.fromSymbol(fromUnitString);
        WeightUnit toUnit = WeightUnit.fromSymbol(toUnitString);

        double result = unitConversionService.convertWeight(value, fromUnit, toUnit);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/temperature")
    @ResponseBody
    public ResponseEntity<Double> apiConvertTemperature(
            @RequestParam("value") double value,
            @RequestParam("from") String fromUnitString,
            @RequestParam("to") String toUnitString) {

        TempUnit fromUnit = TempUnit.fromSymbol(fromUnitString);
        TempUnit toUnit = TempUnit.fromSymbol(toUnitString);

        double result = unitConversionService.convertTemperature(value, fromUnit, toUnit);
        return ResponseEntity.ok(result);
    }
}
