package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Custom_User")
public class UserEntity  {
	@Id
	@GeneratedValue
	@Column(name="User_Id")
	private int userid;
	
	@Column(name="User_Name")
	private String username;
	
	@Column(name="User_Pwd")
	private String pwd;
	
	@Column(name="User_Email")
	private String email;
	
	
	@Column(name="User_Phno")
	private String phno;
	
	@Column(name="User_Country")
	private String country;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
		return "UserEntity [userid=" + userid + ", username=" + username + ", pwd=" + pwd + ", email=" + email
				+ ", country=" + country + ", phno=" + phno + "]";
	}
	
	
	
	

}
