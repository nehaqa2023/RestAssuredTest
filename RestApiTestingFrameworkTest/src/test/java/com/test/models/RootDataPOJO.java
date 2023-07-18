package com.test.models;

public class RootDataPOJO {

	String status;
	EmployeeDataPOJO data;
	String message;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmployeeDataPOJO getData() {
		return data;
	}
	public void setData(EmployeeDataPOJO data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
