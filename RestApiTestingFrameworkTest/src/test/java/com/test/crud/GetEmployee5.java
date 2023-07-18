package com.test.crud;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.json.*;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;
import com.test.models.EmployeeDataPOJO;
import com.test.models.RootDataPOJO;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetEmployee5 extends UserServiceHelper{
	
	@BeforeMethod
	public static void baseUri() {
		RestAssured.baseURI = getBaseUri();
	}
	
	@Test
	public void getEmployeeData() {
		
		String id = "2";
		
		Response response = getEmployee(id);

		ReusableMethods.verifyStatusCodeis(response, 200);
	    response.then().contentType("application/json");  
		//response.prettyPrint();
		
		String expectedStatus = "success";
		String actualStatus = ReusableMethods.getStatus(response);
		
		AssertJUnit.assertEquals(actualStatus, expectedStatus);
		
		System.out.println("Employee name: "+ReusableMethods.getEmployeeDetail(response, "employee_name"));
		System.out.println("Employee salary: "+ReusableMethods.getEmployeeDetail(response, "employee_salary"));
		System.out.println("Employee age: "+ReusableMethods.getEmployeeDetail(response, "employee_age"));

	}
	

	
	
	
}
