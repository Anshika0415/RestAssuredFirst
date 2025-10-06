package pages;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.APIClass;
import pojo.GetCourses;
import pojo.WebAutomation;

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
		
		GetCourses gc=given().queryParam("access_token", accessToken).when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.then().log().all().extract().response().as(GetCourses.class);
		
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		List<APIClass> apiCourses=gc.getCourses().getApi();
		for(int i=0;i<apiCourses.size();i++)
		{
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println(apiCourses.get(i).getPrice());
			}
		}
		List<WebAutomation> webCourses=gc.getCourses().getWebAutomation();
		for(int i=0;i<webCourses.size();i++)
		{
			if(webCourses.get(i).getCourseTitle().equalsIgnoreCase("Cypress"))
			{
				System.out.println(webCourses.get(i).getCourseTitle());
				System.out.println(webCourses.get(i).getPrice());
			}
		}
		
	}

}