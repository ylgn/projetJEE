package PAP.ENTITY;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User implements IUser, Serializable {
	@Id @GeneratedValue
	private String mail;
	private String name;
	private String city;
	private String pass;
	
	public User() {
		
	}
	public User(String mail,String name,String city,String pass) {
		this.mail =mail;
		this.city = city;
		this.name = name;
		this.pass = pass;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}

	@Override
	public String getPass() {
		// TODO Auto-generated method stub
		return this.pass;
	}

	@Override
	public String getMail() {
		// TODO Auto-generated method stub
		return this.mail;
	}

}
