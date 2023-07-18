package com.test.crud;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteEmployee4 extends UserServiceHelper{
	
	@BeforeMethod
	public static void baseUri() {
		RestAssured.baseURI = getBaseUri();
	}

	@Test
	public void deleteEmployee() {
		
        int id = 0;
		
		System.out.println("Employee id:"+ id);

		Response response = deleteEmployee(String.valueOf(id));
		
		ReusableMethods.verifyStatusCodeis(response, 400);
		System.out.println("Message: " + ReusableMethods.getMessage(response));
		
	    response.then().contentType("application/json");  
		response.prettyPrint();
		             
	}

}
