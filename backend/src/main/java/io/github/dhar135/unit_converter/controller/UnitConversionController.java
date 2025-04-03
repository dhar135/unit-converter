package io.github.dhar135.unit_converter.controller;

import io.github.dhar135.unit_converter.enums.LengthUnit;
import io.github.dhar135.unit_converter.enums.TempUnit;
import io.github.dhar135.unit_converter.enums.WeightUnit;
import io.github.dhar135.unit_converter.service.UnitConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convert")
@CrossOrigin(origins = "http://localhost:3000")
public class UnitConversionController {

    private final UnitConversionService unitConversionService;

    public UnitConversionController(UnitConversionService unitConversionService) {
        this.unitConversionService = unitConversionService;
    }

    @GetMapping("/length")
    public ResponseEntity<ConversionResponse> convertLength(@RequestParam("value") double value,
            @RequestParam("from") String fromUnitString, @RequestParam("to") String toUnitString) {

        LengthUnit fromUnit = LengthUnit.fromSymbol(fromUnitString);
        LengthUnit toUnit = LengthUnit.fromSymbol(toUnitString);

        double result = unitConversionService.convertLength(value, fromUnit, toUnit);
        return ResponseEntity.ok(new ConversionResponse(result, toUnitString));
    }

    @GetMapping("/weight")
    public ResponseEntity<ConversionResponse> convertWeight(@RequestParam("value") double value,
            @RequestParam("from") String fromUnitString, @RequestParam("to") String toUnitString) {

        WeightUnit fromUnit = WeightUnit.fromSymbol(fromUnitString);
        WeightUnit toUnit = WeightUnit.fromSymbol(toUnitString);

        double result = unitConversionService.convertWeight(value, fromUnit, toUnit);
        return ResponseEntity.ok(new ConversionResponse(result, toUnitString));
    }

    @GetMapping("/temperature")
    public ResponseEntity<ConversionResponse> convertTemperature(@RequestParam("value") double value,
            @RequestParam("from") String fromUnitString, @RequestParam("to") String toUnitString) {

        TempUnit fromUnit = TempUnit.fromSymbol(fromUnitString);
        TempUnit toUnit = TempUnit.fromSymbol(toUnitString);

        double result = unitConversionService.convertTemperature(value, fromUnit, toUnit);
        return ResponseEntity.ok(new ConversionResponse(result, toUnitString));
    }

}
