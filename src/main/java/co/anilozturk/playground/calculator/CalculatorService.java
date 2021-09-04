package co.anilozturk.playground.calculator;

import co.anilozturk.playground.calculator.operation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final OperationLocator locator;

    List<OperationType> getSupportedOperations() {
        final List<OperationType> operationTypeList = Arrays.asList(OperationType.SUM, OperationType.SUBTRACT, OperationType.MULT, OperationType.DIV);
        return operationTypeList;
    }

    OperationOutput process(OperationInput input){

        final OperationType operationType = input.getOperationType();

        Operation operation = locator.getOperation(operationType);

        return operation.wrapProcess(input);
    }
}
