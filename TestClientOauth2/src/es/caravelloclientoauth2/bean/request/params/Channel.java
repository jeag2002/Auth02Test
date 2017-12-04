package es.caravelloclientoauth2.bean.request.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.caravelloclientoauth2.bean.request.params.serializer.ChannelSerializer;
import es.caravelloclientoauth2.bean.request.params.serializer.CountrySerializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonSerialize(using = ChannelSerializer.class)

public enum Channel {
	POSTAL("postal"),MAIL("mail"),API("api"),FTP("ftp");
	
	private String channel;
	

	private Channel(String _channel){
		channel = _channel;
	}
	
	@JsonValue
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	

}
