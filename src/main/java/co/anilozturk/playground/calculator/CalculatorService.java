package co.anilozturk.playground.calculator;

import co.anilozturk.playground.calculator.operation.Operation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CalculatorService {

    List<Operation> getSupportedOperations() {
        final List<Operation> operationList = Arrays.asList(Operation.SUM, Operation.SUBTRACT, Operation.MULT, Operation.DIV);
        return operationList;
    }
}
