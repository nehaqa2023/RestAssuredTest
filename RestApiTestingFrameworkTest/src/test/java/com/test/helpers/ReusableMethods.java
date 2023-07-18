package com.test.helpers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.test.models.EmployeeDataPOJO;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReusableMethods {
	
	public static EmployeeDataPOJO employee;

	
	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}
	
	public String getContentType(Response response) {
		return response.getContentType();
	}
	
	public long getResponseTimeIn(Response response, TimeUnit time ) {
		return response.getTimeIn(time);
	}
	
	public static void verifyStatusCodeis(Response response, int statusCode) {
		response.then().statusCode(statusCode);
	}

	public static String getJSONPathData(Response response, String string) {
		return response.body().jsonPath().getString(string);
	}

	public static String getStatus(Response response) {
		return response.body().jsonPath().get("status");
	}

	public static String getMessage(Response response) {
		return response.body().jsonPath().get("message");
	}

	public static List<EmployeeDataPOJO> getEmployeesData(Response response) {
		return response.body().jsonPath().get("data");
	}
	
	public static Object getEmployeeDetail(Response response, String key) {
		LinkedHashMap<String, Object> empData = response.body().jsonPath().get("data");
		return empData.get(key);
	}
}
