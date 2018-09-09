package com.start;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Girl {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	private String cupSize;
	private String age;

	public Girl() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
