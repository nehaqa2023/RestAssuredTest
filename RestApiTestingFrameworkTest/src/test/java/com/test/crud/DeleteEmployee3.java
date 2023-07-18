package com.test.crud;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteEmployee3 extends UserServiceHelper{
	
	@BeforeMethod
	public static void baseUri() {
		RestAssured.baseURI = getBaseUri();
	}

	@Test
	public static void deleteEmployee() {
		
		Response response = createEmployee();		
		ReusableMethods.verifyStatusCodeis(response, 200);

		System.out.println("Employee Created");
		
		int id = (Integer) ReusableMethods.getEmployeeDetail(response, "id");
		//int id = 6890;
		
		System.out.println("Employee id:"+ id);

		response = deleteEmployee(String.valueOf(id));
		
		ReusableMethods.verifyStatusCodeis(response, 200);
		System.out.println("Message: " + ReusableMethods.getMessage(response));
		
	    response.then().contentType("application/json");  
		response.prettyPrint();
				             
	}

}
