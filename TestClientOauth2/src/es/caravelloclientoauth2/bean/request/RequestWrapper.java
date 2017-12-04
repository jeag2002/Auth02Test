package es.caravelloclientoauth2.bean.request;

public class RequestWrapper {

	private Requester requester;
	private Provider provider;
	private Survey survey;
	private Subscription subscription; 
	
	public RequestWrapper(){
		requester = new Requester();
		provider = new Provider();
		survey = new Survey();
		subscription = new Subscription();
	}
	
	public void clear(){
		requester = null;
		provider = null;
		survey = null;
		subscription = null;
	}
	
	public Requester getRequester() {
		return requester;
	}

	public void setRequester(Requester requester) {
		this.requester = requester;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

}
