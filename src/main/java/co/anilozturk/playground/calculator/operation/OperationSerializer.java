package co.anilozturk.playground.calculator.operation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

@SuppressWarnings("rawtypes")
public class OperationSerializer extends StdSerializer<Operation> {

    public static final String NAME = "name";

    public static final String OPERATOR = "operator";

    public OperationSerializer(Class<Operation> t) {
        super(t);
    }

    public OperationSerializer() {
        this(null);
    }

    @Override
    public void serialize(Operation operation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(NAME, operation.getName());
        jsonGenerator.writeStringField(OPERATOR, operation.getOperator());
        jsonGenerator.writeEndObject();
    }
}
