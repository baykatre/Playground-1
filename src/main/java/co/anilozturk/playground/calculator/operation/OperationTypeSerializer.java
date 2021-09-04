package co.anilozturk.playground.calculator.operation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

@SuppressWarnings("rawtypes")
public class OperationTypeSerializer extends StdSerializer<OperationType> {

    public static final String NAME = "name";

    public static final String OPERATOR = "operator";

    public OperationTypeSerializer(Class<OperationType> t) {
        super(t);
    }

    public OperationTypeSerializer() {
        this(null);
    }

    @Override
    public void serialize(OperationType operationType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(NAME, operationType.getName());
        jsonGenerator.writeStringField(OPERATOR, operationType.getSymbol());
        jsonGenerator.writeEndObject();
    }
}
