package es.caravelloclientoauth2.bean.request.params.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import es.caravelloclientoauth2.bean.request.params.Currency;

public class CurrencySerializer extends StdSerializer<Currency> {

    private static final long serialVersionUID = 1376504304439963619L;

    public CurrencySerializer() {
        super(Currency.class);
    }

    public CurrencySerializer(Class<Currency> t) {
        super(t);
    }

    public void serialize(Currency currency, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeString(currency.getCurrency());
        generator.writeEndObject();
    }
}