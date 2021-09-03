package co.anilozturk.playground.calculator;

import co.anilozturk.playground.calculator.operation.OperationType;
import co.anilozturk.playground.calculator.operation.OperationInput;
import co.anilozturk.playground.calculator.operation.OperationOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping
    ResponseEntity<List<OperationType>> getSupportedOperations() {
        final List<OperationType> supportedOperationTypes = calculatorService.getSupportedOperations();
        return ResponseEntity.ok(supportedOperationTypes);
    }

    @PostMapping
    ResponseEntity<OperationOutput> process(@RequestBody OperationInput input){

        final OperationOutput output = calculatorService.process(input);
        return ResponseEntity.ok(output);
    }
}
