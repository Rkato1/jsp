package model.vo;

public class Student {
	int stuNo;
	String stuName;
	String stuPhone;
	String email;
	String addr;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int stuNo, String stuName, String stuPhone, String email, String addr) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
		this.email = email;
		this.addr = addr;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
