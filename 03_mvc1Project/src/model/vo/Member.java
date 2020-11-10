package model.vo;

public class Member {
	int memNo;
	String memId;
	String memPw;
	String memName;
	String phone;
	String email;
	String gender;
	String enrollDate;
	/**
	 * @return the enrollDate
	 */
	public String getEnrollDate() {
		return enrollDate;
	}
	/**
	 * @param enrollDate the enrollDate to set
	 */
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int memNo, String memId, String memPw, String memName, String phone, String email, String gender,
			String enrollDate) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.enrollDate = enrollDate;
	}
	/**
	 * @return the memNo
	 */
	public int getMemNo() {
		return memNo;
	}
	/**
	 * @param memNo the memNo to set
	 */
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	/**
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}
	/**
	 * @param memId the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}
	/**
	 * @return the memPw
	 */
	public String getMemPw() {
		return memPw;
	}
	/**
	 * @param memPw the memPw to set
	 */
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	/**
	 * @return the memName
	 */
	public String getMemName() {
		return memName;
	}
	/**
	 * @param memName the memName to set
	 */
	public void setMemName(String memName) {
		this.memName = memName;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
}
