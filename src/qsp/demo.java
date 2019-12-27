package qsp;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo 
{
    @Parameters({"country", "city"})
	@Test
	public void getDetails(String country, String city)
	{
    	Reporter.log(country,true);
    	Reporter.log(city, true);
    	Reporter.log("testng parameters passed", true);
		
	}
}
