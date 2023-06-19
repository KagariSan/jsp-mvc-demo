package com.itplus.test1.entity;

import java.util.Date;


public class Employee {
	private Long id;
	private String empCode;
	private String name;
	private Date birthDay;
	private String address;
	private Gender gender;
	private Long posisitionId;
	private String position;
	private Status status;
	public Employee() {
		
	}
	public Employee(Long id, String empCode, String name, Date birthDay, String address, Gender gender,
			 String position, Long posisitionId, Status status) {
		super();
		this.id = id;
		this.empCode = empCode;
		this.name = name;
		this.birthDay = birthDay;
		this.address = address;
		this.gender = gender;
		this.posisitionId = posisitionId;
		this.position = position;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Long getPosisitionId() {
		return posisitionId;
	}
	public void setPosisitionId(Long posisitionId) {
		this.posisitionId = posisitionId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}



	public enum Gender {
		MALE, FEMALE
	}
	public enum Status {
		ACTIVE, IN_ACTIVE
	}
}
