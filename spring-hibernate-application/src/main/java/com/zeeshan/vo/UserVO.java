package com.zeeshan.vo;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVO {

	private String id;

	@Size(max = 50, min = 3, message = "{user.name.empty}")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]*$", message = "{user.name.special}")
	@NotEmpty
	private String name;

	@Email(message = "{user.email.invalid}")
	private String email;

	@Size(max = 10, min = 10, message = "{user.mobileNo.invalid}")
	@Pattern(regexp = "^(7|8|9)[0-9]{9}$", message = "{user.mobileNo.invalid.regEx}")
	@Column(updatable = false)
	private String mobileNo;

	
	@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$", message = "{user.dob.invalid}")
	private String dob;

	private String days;
	private String months;
	private String years;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", dob=" + dob
				+ ", days=" + days + ", months=" + months + ", years=" + years + "]";
	}

}
