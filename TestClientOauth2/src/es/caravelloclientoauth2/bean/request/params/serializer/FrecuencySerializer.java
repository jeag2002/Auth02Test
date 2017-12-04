package es.caravelloclientoauth2.bean.request.params.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import es.caravelloclientoauth2.bean.request.params.Currency;
import es.caravelloclientoauth2.bean.request.params.Frecuency;

public class FrecuencySerializer extends StdSerializer<Frecuency> {

    private static final long serialVersionUID = 1376504304439963619L;

    public FrecuencySerializer() {
        super(Frecuency.class);
    }

    public FrecuencySerializer(Class<Frecuency> t) {
        super(t);
    }

    public void serialize(Frecuency frecuency, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("frecuency");
        generator.writeString(frecuency.getFrecuency());
        generator.writeEndObject();
    }
}