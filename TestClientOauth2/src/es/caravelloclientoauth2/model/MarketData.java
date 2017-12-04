package es.caravelloclientoauth2.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "MarketData")
public class MarketData{
	
	@Id
	@Column(name = "marketid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int marketId;

	@Column(name = "providerid")
	private String providerId;
	
	@Column(name = "gender") 
	private String gender;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "income")
	private int income;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "frecuency")
	private String frecuency;
	
	@Column(name = "channel")
	private String channel;
	
	public MarketData(){
		providerId = "";
		country = "";
		age = 0;
		currency = "";
		income = 0;
		frecuency = "";
		channel = "";
	}
	
	
	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
		//this.add(linkTo(methodOn(CaravelloController.class).getMarketSurveysByMarketId(String.valueOf(marketId))).withSelfRel());
	}
	
	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	

}
