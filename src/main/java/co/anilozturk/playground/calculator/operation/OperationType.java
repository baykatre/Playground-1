package co.anilozturk.playground.calculator.operation;


import co.anilozturk.playground.calculator.process.Divide;
import co.anilozturk.playground.calculator.process.Multiplication;
import co.anilozturk.playground.calculator.process.Subtraction;
import co.anilozturk.playground.calculator.process.Summary;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonSerialize(using = OperationSerializer.class)
@JsonDeserialize(using = OperationDeserializer.class)
public enum OperationType {

    SUM("SUMMATION", "+", Summary.class.getSimpleName()),
    SUBTRACT("SUBTRACTION", "-", Subtraction.class.getSimpleName()),
    MULT("MULTIPLICATION", "*", Multiplication.class.getSimpleName()),
    DIV("DIVIDE", "/", Divide.class.getSimpleName());

    private final String name, symbol, beanName;
}
