package es.caravelloclientoauth2.bean.request.params.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import es.caravelloclientoauth2.bean.request.params.Country;
import es.caravelloclientoauth2.bean.request.params.Currency;

public class CountrySerializer extends StdSerializer<Country> {

    private static final long serialVersionUID = 1376504304439963619L;

    public CountrySerializer() {
        super(Country.class);
    }

    public CountrySerializer(Class<Country> t) {
        super(t);
    }

    public void serialize(Country country, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("country");
        generator.writeString(country.getCountry());
        generator.writeEndObject();
    }
}