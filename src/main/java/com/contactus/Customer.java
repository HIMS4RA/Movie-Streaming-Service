package com.contactus;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String subject;
	private String message;
	
	
	public Customer(int id, String firstName, String lastName, String email, String phone, String subject,
			String message) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.subject = subject;
		this.message = message;
	}


	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}


	public String getPhone() {
		return phone;
	}


	public String getSubject() {
		return subject;
		
	}

	public String getMessage() {
		return message;
	}

	

}
