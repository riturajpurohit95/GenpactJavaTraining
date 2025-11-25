package com.springboot.first_webmvc.model;

import java.util.List;

public class User {
	
	public User(String name, String email, Integer age, String password, String about, boolean subscribe,
			List<String> interests, String gender, List<String> languages, String country) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
		this.about = about;
		this.subscribe = subscribe;
		this.interests = interests;
		this.gender = gender;
		this.languages = languages;
		this.country = country;
	}

	public User(String name, String email, Integer age, String password, String about, boolean subscribe, List<String> interests) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
		this.about = about;
		this.subscribe = subscribe;
		this.interests = interests;
	}
	
	public User() {}
	
	private String name;
	private String email;
	private Integer age;
	private String password;
	private String about;
	private boolean subscribe;
	private List<String> interests;
	private String gender;
	private List<String> languages;
	private String country;
	
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Integer getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	public Boolean getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Boolean subscribe) {
		this.subscribe = subscribe;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", password=" + password + ", about="
				+ about + "]";
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public String getGender() {
		return gender;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public String getCountry() {
		return country;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
