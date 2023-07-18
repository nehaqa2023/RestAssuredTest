package com.test.helpers;

import com.test.utils.Utils;

import com.test.utils.Log4JUtility;
import com.test.constants.EndPoints;
import com.test.helpers.ReusableMethods;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class UserServiceHelper {

	private static Response response;
	protected static String token = null;
	protected static Log4JUtility logObject = Log4JUtility.getInstance();
	protected static Logger log;

	public static String getBaseUri() {
		String baseURI = Utils.getConfigProperty("url");
		log = logObject.getLogger();
		return baseURI;
	}
	
	public static Response getEmployees() {
		RequestSpecification request = RestAssured.given();
		Response response=request.when()
		                  .get(EndPoints.EMPLOYEES);
	   
	    return response;
	}

	public static Response createEmployee() {
		
		Response response = RestAssured.given().
			     contentType(ContentType.JSON)
			     .body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}")
			     .when()
			     .post(EndPoints.CREATE);
		return response;
	}
	
	
	public static Response deleteEmployee(String id) {
		
		Response response = RestAssured.given().
			     contentType(ContentType.JSON)
			     .body("{\"id\":"+id+"}")
			     .when()
			     .delete(EndPoints.DELETE+"/"+id);
		return response;
	}
	
	public static Response getEmployee(String id) {
		RequestSpecification request = RestAssured.given();
		Response response=request.when()
		                  .get(EndPoints.EMPLOYEE+"/"+id);
	   
	    return response;
	}

}
