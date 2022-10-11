package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	@Test
	public void testPut() {
		JSONObject request = new JSONObject();//you will get the same output which you want
		
		request.put("name", "Nrali");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).//you are telling the server that you are sending the data in Json and you want data in Json also
		  accept(ContentType.JSON).
		  body(request.toJSONString()).
	    when().
		  put("/users/2").
	    then().
		  statusCode(200).log().all();
			
		}
	
	@Test
	public void testPatch() {
		JSONObject request = new JSONObject();//you will get the same output which you want
		
		request.put("name", "Nrali");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).//you are telling the server that you are sending the data in Json and you want data in Json also
		  accept(ContentType.JSON).
		  body(request.toJSONString()).
	    when().
		  patch("/api/users/2").
		  then().
		  statusCode(200).log().all();
			
		}
	
	@Test
	public void testDelete() {
		
		baseURI="https://reqres.in";
		when().
		  delete("/api/users/2").
		  then().
		  statusCode(204).log().all();
    }
	
}
