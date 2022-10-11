package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class TestOnLocalAPI {
   // @Test
    public void get() {
    	baseURI = "http://localhost:3000/";
    	
    	given().get("users").then().statusCode(200).log().all();
    }
	
	//@Test
     public void post() {
    	 JSONObject request=new JSONObject();
    	 
    	 request.put("firstname", "pheter");
    	 request.put("lastname", "Edison");
    	 request.put("subjectid", 1);
    	 
    	 baseURI="http://localhost:3000";
    	 
    	given()
    	  .contentType(ContentType.JSON)
    	  .accept(ContentType.JSON)
    	  .body(request.toJSONString())
    	.when()
    	  .post("/users")
        .then()
    	  .statusCode(201);
    	 
     }
    // @Test
     public void patch() {
    	 JSONObject request=new JSONObject();
    	 
    	 request.put("lastname", "Daina");
    	
    	 baseURI="http://localhost:3000";
    	 
    	given()
    	  .contentType(ContentType.JSON)
    	  .accept(ContentType.JSON)
    	  .body(request.toJSONString())
    	.when()
    	  .patch("/users/4")
        .then()
    	  .statusCode(200);
    	 
     }
     @Test
     public void delete() {
    	 baseURI="http://localhost:3000";
    	 when().delete("/users/4").then().statusCode(200);
     }
}


