package es.caravelloclientoauth2.bean.request.params.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import es.caravelloclientoauth2.bean.request.params.Gender;

public class GenderSerializer extends StdSerializer<Gender> {

    private static final long serialVersionUID = 1376504304439963619L;

    public GenderSerializer() {
        super(Gender.class);
    }

    public GenderSerializer(Class<Gender> t) {
        super(t);
    }

    public void serialize(Gender gender, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("name");
        generator.writeString(gender.getGender());
        generator.writeEndObject();
    }
}