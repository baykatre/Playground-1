package co.anilozturk.playground.calculator.process;

import co.anilozturk.playground.calculator.operation.Operation;
import co.anilozturk.playground.calculator.operation.OperationInput;
import co.anilozturk.playground.calculator.operation.OperationOutput;
import co.anilozturk.playground.calculator.operation.OperationType;
import org.springframework.stereotype.Component;

@Component
public class Subtraction implements Operation {

    @Override
    public OperationOutput process(OperationInput input) {
        final Long firstNumber = input.getFirstNumber();
        final Long secondNumber = input.getSecondNumber();
        final OperationOutput output = OperationOutput.builder()
                .result(Double.valueOf(firstNumber - secondNumber))
                .operationType(OperationType.SUBTRACT)
                .build();

        return output;
    }
}