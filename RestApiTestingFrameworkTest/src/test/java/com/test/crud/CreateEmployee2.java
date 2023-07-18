package com.test.crud;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.constants.EndPoints;
import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;
import com.test.models.NewUserResponsePOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployee2 extends UserServiceHelper{
	
	@BeforeMethod
	public static void baseUri() {
		RestAssured.baseURI = getBaseUri();
	}

	@Test
	public static void createEmployeeTest() {
		
		Response response = createEmployee();						
		ReusableMethods.verifyStatusCodeis(response, 200);
	    response.then().contentType("application/json");  
		response.prettyPrint();
		
		String expectedStatus = "success";
		String actualStatus = ReusableMethods.getStatus(response);
		
		System.out.println(actualStatus +" "+ expectedStatus);
		AssertJUnit.assertEquals(actualStatus, expectedStatus);
		
		System.out.println("Id: "+ReusableMethods.getEmployeeDetail(response, "id"));
	}
	

}
