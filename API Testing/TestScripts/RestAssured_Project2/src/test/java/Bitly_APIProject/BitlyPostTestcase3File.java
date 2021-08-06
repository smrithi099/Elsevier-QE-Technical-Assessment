package Bitly_APIProject;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class BitlyPostTestcase3File {
	  RequestSpecification request = RestAssured.given();
	   String tokenGenerated = "c08549d81bd4b8de53451c54ce64f22c7f134bcd";
	
  
@Test
  public void test_PostlongURLtoBitlinksuccess() {
	                                       
      request.header("Authorization","Bearer "+tokenGenerated );
	  request.header("Content-Type","application/json");
	  request.body(new File("./Payload.json")).log().all()
	  .when()
	      .post("https://api-ssl.bitly.com/v4/bitlinks")
	  .then()
	      .statusCode(200)
	  	  .body("long_url", equalTo("https://dev.bitly.com/"));
  }
  
}
