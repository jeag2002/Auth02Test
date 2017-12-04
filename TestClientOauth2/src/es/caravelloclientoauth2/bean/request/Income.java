package es.caravelloclientoauth2.bean.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.caravelloclientoauth2.bean.request.params.Currency;

public class Income {

	private Currency currency;
	private List<Integer>range;
	
	public Income(){
		currency = Currency.EUR;
		range = new ArrayList<Integer>();
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<Integer> getRange() {
		return range;
	}

	public void setRange(List<Integer> _range) {
		this.range = _range;
	}

}
