package pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;




public class LibraryAppTest 
{
	@Test(dataProvider="BooksData")
    public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String addBookResponse=given().header("Content-Type","application/json")
				.body(Payloads.addBook(isbn,aisle))
				.when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200)
				.body("Msg",equalTo("successfully added"))
				.extract().response().asString();
				
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"manu","412"},{"ravi","709"}};
	}
	
}
