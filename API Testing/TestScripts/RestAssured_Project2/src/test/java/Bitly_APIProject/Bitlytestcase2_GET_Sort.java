package Bitly_APIProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;

public class Bitlytestcase2_GET_Sort {
	
	  RequestSpecification request = RestAssured.given();
	   
	  String tokenGenerated = "c08549d81bd4b8de53451c54ce64f22c7f134bcd";
	
  @Test
  public void test_getsort_clicks() {
	  
	
	  request.header("Authorization","Bearer "+tokenGenerated );
	  request.header("Content-Type","application/json")
	  .when()
	      .get("https://api-ssl.bitly.com/v4/groups/Bl83agh17lO/bitlinks/clicks")
	  .then()
	      .statusCode(200);
	  
	  
  }
 public void test_getsort_unitsoftime() {
	  
	  request.header("Authorization","Bearer "+tokenGenerated );
	  request.header("Content-Type","application/json")
	  .when()
	      .get("https://api-ssl.bitly.com/v4/groups/Bl83agh17lO/bitlinks/clicks?unit=month&units=5&unit_reference=2021-09-02T15%3A04%3A05-0700&size=10")
	  .then()
	      .statusCode(200);
	  
	  
  }
 public void test_get_404pagenotfound() {
	  
	  request.header("Authorization","Bearer "+tokenGenerated );
	  request.header("Content-Type","application/json")
	  .when()
	      .get("https://api-ssl.bitly.com/v4/groups/Bl83agh17lO/bitlink/clicks?unit=month&units=5&unit_reference=2021-09-02T15%3A04%3A05-0700&size=10")
	  .then()
	      .statusCode(404);
	  
	  
 }
}
