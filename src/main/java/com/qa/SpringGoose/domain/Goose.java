package com.qa.SpringGoose.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Goose")
public class Goose {

	//Primary Key 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank
	private String name;
	
	@Min(0)
	@Max(24)
	@Column
	private byte age;
	
	
	//Empty Constructor
	public Goose() {
		name = "Goose";
	}
	//Full Constructor
	public Goose(Long id, String name, byte age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//Constructor without ID
	public Goose(String name, byte age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}
	//Hash code and Equals
	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goose other = (Goose) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	//toStrings
	@Override
	public String toString() {
		return "Goose [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	
}
