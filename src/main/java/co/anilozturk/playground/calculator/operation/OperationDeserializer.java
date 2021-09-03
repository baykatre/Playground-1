package co.anilozturk.playground.calculator.operation;

import co.anilozturk.playground.exception.CalculatorException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Arrays;

public class OperationDeserializer extends StdDeserializer<OperationType> {
    public static final String UNSUPPORTED_OPERATION = "Unsupported Operation!";

    protected OperationDeserializer(Class<?> vc) {
        super(vc);
    }

    OperationDeserializer() {
        super(OperationType.class);
    }

    @SneakyThrows
    @Override
    public OperationType deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {

        /*
        final Reflections reflections = new Reflections("co.anilozturk.playground.calculator");
        final Set<Class<? extends Operation>> operations = reflections.getSubTypesOf(Operation.class).stream().filter(o -> !o.isInterface()).collect(Collectors.toSet());
         */

        final String operationSymbol = parser.getValueAsString();
        final OperationType operationType = Arrays.stream(OperationType.values())
                .filter(o -> operationSymbol.equals(o.getSymbol()))
                .findFirst().orElseThrow(() -> new CalculatorException(UNSUPPORTED_OPERATION));

        return operationType;
    }
}


