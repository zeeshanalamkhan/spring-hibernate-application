package com.zeeshan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USERS")
public class UserBO implements Serializable {

	private static final Logger logger = Logger.getLogger(UserBO.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "myGenerator")
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	private Integer id;

	@Column(name = "NAME", nullable = false)
	private String name;
	private String email;
	// @Column(updatable = false)
	private Long mobileNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date date;
	private Integer days;
	private Integer months;
	private Integer years;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "UserBO [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", date=" + date
				+ ", days=" + days + ", months=" + months + ", years=" + years + "]";
	}

}
