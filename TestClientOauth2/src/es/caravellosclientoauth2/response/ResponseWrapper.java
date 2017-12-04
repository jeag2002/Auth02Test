package es.caravellosclientoauth2.response;

import java.util.ArrayList;
import java.util.List;

public class ResponseWrapper{
	
	private String idResponse;
	private List<es.caravelloclientoauth2.model.MarketData> marketData;
	
	public ResponseWrapper(){
		idResponse = "";
		marketData = new ArrayList<es.caravelloclientoauth2.model.MarketData>();
	}
	
	public String getIdResponse() {
		return idResponse;
	}

	public void setIdResponse(String idResponse) {
		this.idResponse = idResponse;
	}

	public List<es.caravelloclientoauth2.model.MarketData> getMarketData() {
		return marketData;
	}

	public void setMarketData(List<es.caravelloclientoauth2.model.MarketData> marketData) {
		this.marketData = marketData;
	}
	
	
	

}
