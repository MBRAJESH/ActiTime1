package Com.Actitime.Generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public  abstract class BaseTest implements Autoconstant
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}

	@Parameters({"nodeurl", "browsername", "appurl"})
	@BeforeMethod
	public void precondition(String nodeurl, String browserName, String appurl) throws MalformedURLException
	{	
		URL url= new URL(nodeurl);
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName(browserName);		
        driver=new RemoteWebDriver(url, dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appurl);
	}
	
	@AfterMethod
	public void postcondition(ITestResult res)
	{
		int Status = res.getStatus();
		if(Status==2)
		{
			String name = res.getName();
			Reporter.log("the method name is "+name, true);
			GenericUtils.getscreenshot(driver, name);
		}
		
		driver.close();
	}
	
	
	
	
	
}
