package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExample {
	//@Test
	public void test_two() {
		baseURI="https://reqres.in/api";
		given().
		  get("/users?page=2").
		then().
		  statusCode(200).
		  body("data[4].first_name", equalTo("George")).
		  body("data.first_name", hasItems("George","Rachel"));//you will get all the name from API program
		
	}
	@Test
	public void testPost() {
		Map<String, Object> map = new HashMap<String,Object>();//this is for type the String object value
		
		//map.put("name", "Nrali");
		//map.put("job", "Teacher");
		//System.out.println(map);
		
		JSONObject request = new JSONObject(map);//you will get the same output which you want
		
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
		  post("/users").
		then().
		  statusCode(201).log().all();
		
	}
}
