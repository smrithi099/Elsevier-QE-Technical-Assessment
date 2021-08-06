package Bitly_APIProject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class BitlyPostTestCase2 {
	final static String ROOT_URI = "https://api-ssl.bitly.com/v4/bitlinks";
	 
	   String tokenGenerated = "c08549d81bd4b8de53451c54ce64f22c7f134bcd";
	  @Test(priority=1)
	  public void postlongURLtoBitlinkerror() {
		  
		  String reqbody =  "{"
				  + "\"long_url\": https://dev.bitly.com,"
		
	            + "\"domain\": \"bit.ly\","
		
	            + " \"group_guid\": \"Bl83agh17lO\","
	            + " \"title\": \"Bl83agh17lO\","
	            + " \"tags\": \"[\r\n" + 
	            "    \"bitly\",\r\n" + 
	            "    \"api\"\r\n" + 
	            "  ]\""
		
	        + "}";
		  
	      //ValidatableResponse response = 
	    		  given()
	    		  .header("Authorization","Bearer "+tokenGenerated)
	    		  .header("Content-Type","application/json")
	    		  .body(reqbody)
	    		 .when()
	    		  .post(ROOT_URI)
	    		 .then()
	    		  .statusCode(422);
	  	
	  }
	  }