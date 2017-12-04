package es.caravelloclientoauth2.bean.request;

public class Requester {
	
	private String Id;
	private String name;
	
	public Requester(){
		Id = "";
		name = "";
	}
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
