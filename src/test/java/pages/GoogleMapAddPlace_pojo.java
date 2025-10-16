package pages;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import serializationpojoPackage.AddPlace;
import serializationpojoPackage.Location;

public class GoogleMapAddPlace_pojo {
	
	@Test
	void addPlaceUsingPOJOFunc(){
		AddPlace AddPlace=new AddPlace();
		AddPlace.setAccuracy(50);
		AddPlace.setAddress("29, side layout, cohen 09");
		AddPlace.setLanguage("French-IN");
		AddPlace.setName("Frontline house");
		AddPlace.setPhone_number("(+91) 983 893 3937");
		AddPlace.setWebsite("http://google.com");
		//Location
		Location location=new serializationpojoPackage.Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		AddPlace.setLocation(location);
		//Types
		List<String> types=new java.util.ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().queryParam("key","qaclick123")
			    .header("Content-Type","application/json")
			    .body(AddPlace)
			    .when().post("/maps/api/place/add/json")
			    .then().log().all().statusCode(200)
			    .body("scope", equalTo("APP"))
			    .header("Server","Apache/2.4.52 (Ubuntu)")
			    .extract().response().asString();
		System.out.println(response);
		
	}
	
	
}
