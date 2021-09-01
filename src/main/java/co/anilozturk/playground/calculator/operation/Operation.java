package co.anilozturk.playground.calculator.operation;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@JsonSerialize(using = OperationSerializer.class)
public enum Operation {

    SUM("SUMMATION", "+"),
    SUBTRACT("SUBTRACTION", "-"),
    MULT("MULTIPLICATION", "*"),
    DIV("DIVIDE", "/");

    private final String name, operator;
}
