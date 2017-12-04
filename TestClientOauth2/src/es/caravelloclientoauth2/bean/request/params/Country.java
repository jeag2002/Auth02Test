package es.caravelloclientoauth2.bean.request.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.caravelloclientoauth2.bean.request.params.serializer.CountrySerializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonSerialize(using = CountrySerializer.class)

public enum Country {
	
	ES("ES");
	
	private String country;

	private Country(String _country){
		country = _country;
	}
	
	@JsonValue
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
