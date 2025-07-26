package pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;


public class GoogleMapsAPITest 
{
    public static void main(String[] args)
    {
    	//Hamcrest library is being used for validation
    	//Validate is add API is working as expected
    	
    	//given - all input details
    	//when - submit the API ,resource, http method
    	//then - validate the response
    	
    	RestAssured.baseURI="https://rahulshettyacademy.com";
    	String response=given().queryParam("key","qaclick123").header("Content-Type","application/json").body(Payloads.mapsPostPayload()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).
    	body("scope",equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
    	//After assertThat function everything is validation
    	//i am removing then().log().all()
    	System.out.println(response);
    	
    	JsonPath js=new JsonPath(response);
    	String placeId=js.get("place_id");
    	System.out.println("placeId : "+placeId);
    	
    	//Update place
    	
    	String putResponse=given().queryParam("key","qaclick123").header("Content-Type","application/json").body(Payloads.mapsPutPayload(placeId)).when().put("maps/api/place/update/json").then().assertThat().statusCode(200).
    	body("msg",equalTo("Address successfully updated")).extract().asString();
    	
    	//Get updated place
    	
    	String getResponse=given().log().all().queryParam("key","qaclick123").queryParam("place_id", placeId).when().
    	get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
    	JsonPath js1=new JsonPath(getResponse);
    	String address=js1.getString("address");
    	
    	String newAddress = "70 Summer walk, USA"; 
    	Assert.assertEquals(address, newAddress);
    	
    	ParsingResponse.updatedMapResponse(getResponse);
    	
    }
}
