package es.caravelloclientoauth2.bean.request;

import java.util.ArrayList;
import java.util.List;

import es.caravelloclientoauth2.bean.request.params.Gender;


public class Target {

	private Gender gender;
	private Income income;
	private List<Integer>age;
	
	public Target(){
		gender = Gender.M;
		income = new Income();
		age = new ArrayList<Integer>();
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public List<Integer> getAge() {
		return age;
	}

	public void setAge(List<Integer> age) {
		this.age = age;
	}
	
	
	

}
