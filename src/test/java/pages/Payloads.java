package pages;

public class Payloads {
	public static String mapsPostPayload()
	{
		return "{\n"
    			+ "  \"location\": {\n"
    			+ "    \"lat\": -13.383491,\n"
    			+ "    \"lng\": 33.427362\n"
    			+ "  },\n"
    			+ "  \"accuracy\": 50,\n"
    			+ "  \"name\": \"Frontline\",\n"
    			+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
    			+ "  \"address\": \"29, side layout, cohen 09\",\n"
    			+ "  \"types\": [\n"
    			+ "    \"shoe park\",\n"
    			+ "    \"shop\"\n"
    			+ "  ],\n"
    			+ "  \"website\": \"https://rahulshettyacademy.com\",\n"
    			+ "  \"language\": \"French-IN\"\n"
    			+ "}\n"
    			+ "";
	}
	public static String mapsPutPayload(String placeId)
	{
		return "{\n"
    			+ "\"place_id\":\""+placeId+"\",\n"
    			+ "\"address\":\"70 Summer walk, USA\",\n"
    			+ "\"key\":\"qaclick123\"\n"
    			+ "}\n"
    			+ "";
	}
	
	public static String courseJsonParsePayload()
	{
		return "{\n"
				+ "\n"
				+ "\"dashboard\": {\n"
				+ "\n"
				+ "\"purchaseAmount\": 910,\n"
				+ "\n"
				+ "\"website\": \"rahulshettyacademy.com\"\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "\"courses\": [\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Selenium Python\",\n"
				+ "\n"
				+ "\"price\": 50,\n"
				+ "\n"
				+ "\"copies\": 6\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Cypress\",\n"
				+ "\n"
				+ "\"price\": 40,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"RPA\",\n"
				+ "\n"
				+ "\"price\": 45,\n"
				+ "\n"
				+ "\"copies\": 10\n"
				+ "\n"
				+ "}\n"
				+ "\n"
				+ "]\n"
				+ "\n"
				+ "}";
	}
	public static String addBook(String isbn, String aisle)
	{
		String payload="{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}

}
