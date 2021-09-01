package co.anilozturk.playground.calculator;

import co.anilozturk.playground.calculator.operation.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/calculator")
    ResponseEntity<List<Operation>> getSupportedOperations() {
        final List<Operation> supportedOperations = calculatorService.getSupportedOperations();
        return ResponseEntity.ok(supportedOperations);
    }
}
