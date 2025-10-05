package pages;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.GetCourses;

public class OAuthTestClass {
	
	@Test
	public void getAccessToken()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String tokenResponse= given()
				.formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type","client_credentials")
				.formParam("scope","trust")
				.when().post("/oauthapi/oauth2/resourceOwner/token")
				.then().log().all().extract().response().asString();
		
		System.out.println(tokenResponse);
		JsonPath js=new JsonPath(tokenResponse);
		String accessToken=js.getString("access_token");
		
		GetCourses response=given().queryParam("access_token", accessToken).when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.then().extract().response().as(GetCourses.class);
		System.out.println(response.getInstructor());
	}

}