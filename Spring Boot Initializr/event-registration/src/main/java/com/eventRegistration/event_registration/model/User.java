package com.eventRegistration.event_registration.model;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class User {
	
	public User(String name, String email, String password, String city, String contact, String gender,
			List<String> technologies, List<String> sessions, boolean newsletter, String payment, String comments) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.contact = contact;
		this.gender = gender;
		this.technologies = technologies;
		this.sessions = sessions;
		this.newsletter = newsletter;
		this.payment = payment;
		this.comments = comments;
	}
	
	public User() {}

	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message="Email is required")
	@Email(message="Please enter a valid email address")
	private String email;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	private String city;
	private String contact;
	private String gender;
	
	@NotEmpty(message="Please select atleast one technology")
	private List<String> technologies;
	
	@NotEmpty(message = "Please select a session")
	private List<String> sessions;
	
	private boolean newsletter;
	
	@NotEmpty(message = "Please select payment method")
	private String payment;
	
	private String comments;
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getCity() {
		return city;
	}
	public String getContact() {
		return contact;
	}
	public String getGender() {
		return gender;
	}
	public List<String> getTechnologies() {
		return technologies;
	}
	public List<String> getSessions() {
		return sessions;
	}
	public boolean isNewsletter() {
		return newsletter;
	}
	public String getPayment() {
		return payment;
	}
	public String getComments() {
		return comments;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}
	public void setSessions(List<String> sessions) {
		this.sessions = sessions;
	}
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", city=" + city + ", contact="
				+ contact + ", gender=" + gender + ", technologies=" + technologies + ", sessions=" + sessions
				+ ", newsletter=" + newsletter + ", payment=" + payment + ", comments=" + comments + "]";
	}
	
}
