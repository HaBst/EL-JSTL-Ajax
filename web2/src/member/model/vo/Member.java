package member.model.vo;

import java.sql.Date;

public class Member {
	public Member() {}
	
	private String userId;
	private String userPwd;
	private String userName;
	private int userAge;
	private String userEmail;
	private String userPhone;
	private String userAddr;
	private String userGender;
	private String userHobby;
	private Date Enrolldate;
	private String activation;
	
	public Member(String userId, String userPwd, String userName, int userAge, String userEmail, String userPhone,
			String userAddr, String userGender, String userHobby, Date enrolldate, String activation) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.userGender = userGender;
		this.userHobby = userHobby;
		this.Enrolldate = enrolldate;
		this.activation = activation;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserHobby() {
		return userHobby;
	}
	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}
	public Date getEnrolldate() {
		return Enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		Enrolldate = enrolldate;
	}
}

/*
USERID	VARCHAR2(20 BYTE)
USERPWD	VARCHAR2(20 BYTE)
USERNAME	VARCHAR2(20 BYTE)
AGE	NUMBER
EMAIL	VARCHAR2(30 BYTE)
PHONE	VARCHAR2(13 BYTE)
ADDRESS	VARCHAR2(50 BYTE)
GENDER	VARCHAR2(1 BYTE)
HOBBY	VARCHAR2(30 BYTE)
ENROLLDATE	DATE
*/