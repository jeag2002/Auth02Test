package es.caravelloclientoauth2.bean.request.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.caravelloclientoauth2.bean.request.params.serializer.CurrencySerializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonSerialize(using = CurrencySerializer.class)

public enum Currency {
	
	EUR("EUR");
	
	private String currency;


	private Currency(String _currency){
		currency = _currency;
	}
	
	@JsonValue
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	

}
