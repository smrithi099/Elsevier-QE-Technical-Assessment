package Bitly_APIProject;

import java.util.HashMap;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BitlyPostTestcase {
	  RequestSpecification request = RestAssured.given();
	   String tokenGenerated = "c08549d81bd4b8de53451c54ce64f22c7f134bcd";
	
  @SuppressWarnings("unchecked")
@Test
  public void test_PostlongURLtoBitlink() {
	    
	  HashMap data = new HashMap();
	  
	  data.put("long_url", "https://dev.bitly.com");
	  data.put("domain","bit.ly");
	  data.put("group_guid","Bl83agh17lO");
	  data.put("title","Bitly API Documentation");
	  data.put("tags","[\"bitly\",\r\n" + 
	  		"	                   \"api\"]");
	                                    
      request.header("Authorization","Bearer "+tokenGenerated );
	  request.header("Content-Type","application/json");
	  request.body(data)
	  .when()
	      .post("https://api-ssl.bitly.com/v4/bitlinks")
	  .then()
	      .statusCode(200);	  
  }
  
}
