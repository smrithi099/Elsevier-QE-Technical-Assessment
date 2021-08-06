package Bitly_APIProject;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class Bitlytestcase {
	
	 RequestSpecification request = RestAssured.given();
	   String tokenGenerated = "c08549d81bd4b8de53451c54ce64f22c7f134bcd";
  @Test
  public void test_getgroupdetails() {
	 
	  request.header("Authorization","Bearer "+tokenGenerated );
	  ValidatableResponse res =
	  request.header("Content-Type","application/json")
	  .when()
	      .get("https://api-ssl.bitly.com/v4/groups/Bl83agh17lO")
	  .then()
	      .statusCode(200)
	      .body("guid", equalTo("Bl83agh17lO"))
	      .body("name", equalTo("smrithi099"));
	  System.out.println(res.log().all());
	  
  }
 public void test_getgroupdetailserror() {
	 
	  request.header("Authorization","Bearer "+tokenGenerated );
	  request.header("Content-Type","application/json")
	  .when()
	      .get("https://api-ssl.bitly.com/v4/groups/Ba1bc23dE4F")
	  .then()
	      .statusCode(403)
	      .body("message", equalTo("FORBIDDEN"))
	      .body("description",equalTo("You are currently forbidden to access this resource"));
	  
	  
 }
	  
  
}
