package parseresponse;
import io.restassured.path.json.JsonPath;
import payloads.Payloads;

public class ParsingResponse {
	
	public static void updatedMapResponse(String response)
	{   System.out.println(response);
		JsonPath js1=new JsonPath(response);
		String phonenum=js1.get("phone_number");
		System.out.println(phonenum);
	}
	public static void courseJsonParse()
	{
		JsonPath js2=new JsonPath(Payloads.courseJsonParsePayload());
		
		//print no of courses 
		int noOfCourses=js2.getInt("courses.size()");
		System.out.println(noOfCourses);
		
		//print title of first course
		String title=js2.getString("courses[0].title");
		System.out.println(title);
		
		//print all course title and their prices
		String coursetitle="";
		int courseprice=0;
		for(int i=0;i<noOfCourses;i++)
		{
			coursetitle=js2.getString("courses["+i+"].title");
			System.out.println(coursetitle);
			courseprice=js2.getInt("courses["+i+"].price");
			System.out.println(courseprice);
		}
	}
}
