package com.subscriber;

public class Feedback {
 private int FID;
 private String Name;
 private String Email;
 private String MobileNo;
 private String Subject;
 private String Message;
public Feedback(int FID, String Name, String Email, String MobileNo, String Subject, String Message) {
	
	this.FID = FID;
	this.Name = Name;
	this.Email = Email;
	this.MobileNo = MobileNo;
	this.Subject = Subject;
	this.Message = Message;
}
public int getFID() {
	return FID;
}
public String getName() {
	return Name;
}
public String getEmail() {
	return Email;
}
public String getMobileNo() {
	return MobileNo;
}
public String getSubject() {
	return Subject;
}
public String getMessage() {
	return Message;
}


 
 
 
}
