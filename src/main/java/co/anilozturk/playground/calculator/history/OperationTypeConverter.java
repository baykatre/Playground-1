package co.anilozturk.playground.calculator.history;

import co.anilozturk.playground.calculator.operation.OperationType;
import co.anilozturk.playground.exception.CalculatorException;

import javax.persistence.AttributeConverter;
import java.util.Objects;
import java.util.stream.Stream;

public class OperationTypeConverter implements AttributeConverter<OperationType, String> {
    public static final String MISSING_OPERATION = "MISSING OPERATION";

    @Override
    public String convertToDatabaseColumn(OperationType operationType) {

        if(Objects.nonNull(operationType)){
            return operationType.getSymbol();
        }
        return null;
    }

    @Override
    public OperationType convertToEntityAttribute(String s) {

        if (Objects.isNull(s)) {
            return null;
        }

        return Stream.of(OperationType.values())
                .filter(o -> s.equals(o.getSymbol()))
                .findFirst()
                .orElseThrow(() -> new CalculatorException(MISSING_OPERATION));
    }
}
