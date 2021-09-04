package co.anilozturk.playground.calculator;

import co.anilozturk.playground.calculator.operation.OperationInput;
import co.anilozturk.playground.calculator.operation.OperationOutput;
import co.anilozturk.playground.calculator.operation.OperationType;
import co.anilozturk.playground.generic.Response;
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
    ResponseEntity<Response<List<OperationType>>> getSupportedOperations() {
        final List<OperationType> supportedOperationTypes = calculatorService.getSupportedOperations();
        return ResponseEntity.ok(Response.from(supportedOperationTypes));
    }

    @PostMapping
    ResponseEntity<Response<?>> process(@RequestBody OperationInput input){

        final OperationOutput output = calculatorService.process(input);
        return ResponseEntity.ok(Response.from(output));
    }
}
