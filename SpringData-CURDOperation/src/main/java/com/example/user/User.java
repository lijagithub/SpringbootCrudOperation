package com.example.user;

public class User {
	
	private int userid;
	private String username;
	private String pwd;
	private String email;
	private String phno;
	private String country;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid=userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", pwd=" + pwd + ", email=" + email + ", country="
				+ country + ", phno=" + phno + "]";
	}
	
	
	

}
