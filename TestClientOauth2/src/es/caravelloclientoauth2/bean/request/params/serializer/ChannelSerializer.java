package es.caravelloclientoauth2.bean.request.params.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import es.caravelloclientoauth2.bean.request.params.Channel;
import es.caravelloclientoauth2.bean.request.params.Country;
import es.caravelloclientoauth2.bean.request.params.Currency;

public class ChannelSerializer extends StdSerializer<Channel> {

    private static final long serialVersionUID = 1376504304439963619L;

    public ChannelSerializer() {
        super(Channel.class);
    }

    public ChannelSerializer(Class<Channel> t) {
        super(t);
    }

    public void serialize(Channel channel, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeString(channel.getChannel());
        generator.writeEndObject();
    }
}