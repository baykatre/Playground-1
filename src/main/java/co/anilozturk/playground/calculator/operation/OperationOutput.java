package co.anilozturk.playground.calculator.operation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OperationOutput {

    private Double result;

    private OperationType operationType;
}
