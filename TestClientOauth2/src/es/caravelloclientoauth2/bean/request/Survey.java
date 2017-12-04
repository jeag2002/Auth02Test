package es.caravelloclientoauth2.bean.request;

import es.caravelloclientoauth2.bean.request.params.Country;

public class Survey {

	private String subject;
	private Target target;
	private Country country;
	
	public Survey(){
		subject = "";
		target = new Target();
		country = Country.ES;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	

}
