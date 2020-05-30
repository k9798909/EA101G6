package Loginintest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TestMenberVO {
	private String userId;
	private String userAccount;
	private String userPassword;
	private String name;
	private String gender;
	private String mail;
	private String address;
	private String id;
	private String phone;
	private String birthday;
	
	public TestMenberVO(){
		
	}
	
	public TestMenberVO(String userAccount,String userPassword,String name,String gender,String mail,String address,String id,String phone,String birthday) {
		
		this.userAccount=userAccount;
		this.userPassword=userPassword;
		this.name=name;
		this.gender=gender;
		this.mail=mail;
		this.address=address;
		this.id=id;
		this.phone=phone;
		this.birthday=birthday;
		
	}
	
	public TestMenberVO(String[] str) {
		try{
		this.userAccount=str[0];
		this.userPassword=str[1];
		this.name=str[2];
		this.gender=str[3];
		this.mail=str[4];
		this.address=str[5];
		this.id=str[6];
		this.phone=str[7];
		this.birthday=str[8];
		}catch(IllegalArgumentException e){
			e.getMessage();
		}
		
	}



	public String getUseraccount() {
		return userAccount;
	}

	public void setUseraccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserpassword() {
		return userPassword;
	}

	public void setUserpassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public List<String> getAll() {
		List<String> list = new ArrayList();
		list.add(this.userAccount);
		list.add(this.userPassword);
		list.add(this.name);
		list.add(this.gender);
		list.add(this.mail);
		list.add(this.address);
		list.add(this.id);
		list.add(this.phone);
		list.add(this.birthday);
		
		return list;
		
	}
	

	
	
}
