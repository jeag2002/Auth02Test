package es.caravelloclientoauth2.bean.request;

import java.util.ArrayList;
import java.util.List;

import es.caravelloclientoauth2.bean.request.params.Channel;
import es.caravelloclientoauth2.bean.request.params.Frecuency;

public class Subscription {
	
	private Frecuency frecuency;
	private List<Channel> channel;
	
	public Subscription(){
		frecuency = Frecuency.WEEKLY;
		channel = new ArrayList<Channel>();
	}
	
	public Frecuency getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(Frecuency frecuency) {
		this.frecuency = frecuency;
	}

	public List<Channel> getChannel() {
		return channel;
	}

	public void setChann(List<Channel> channel) {
		this.channel = channel;
	}


}
