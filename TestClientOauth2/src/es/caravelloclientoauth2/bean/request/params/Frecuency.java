package es.caravelloclientoauth2.bean.request.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.caravelloclientoauth2.bean.request.params.serializer.FrecuencySerializer;
import es.caravelloclientoauth2.bean.request.params.serializer.GenderSerializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonSerialize(using = FrecuencySerializer.class)
public enum Frecuency {
	
	WEEKLY("weekly");
	
	private String frecuency;

	
	private Frecuency(String _frecuency){
		frecuency = _frecuency;
	}
	
	@JsonValue
	public String getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	
	


}
