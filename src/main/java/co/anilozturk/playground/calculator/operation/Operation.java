package co.anilozturk.playground.calculator.operation;

import co.anilozturk.playground.exception.CalculatorException;

public abstract class Operation {

    protected abstract OperationOutput process(OperationInput input);

    public OperationOutput wrapProcess(OperationInput input) {
        try {
            return process(input);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Arithmetic Error!");
        }
    }
}
