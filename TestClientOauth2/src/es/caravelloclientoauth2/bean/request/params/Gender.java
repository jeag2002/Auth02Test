package es.caravelloclientoauth2.bean.request.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.caravelloclientoauth2.bean.request.params.serializer.GenderSerializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonSerialize(using = GenderSerializer.class)
public enum Gender {
	
	M("M"),F("F");
	
	private String gender;

	private Gender(String _gender){
		gender = _gender;
	}
	
	@JsonValue
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
