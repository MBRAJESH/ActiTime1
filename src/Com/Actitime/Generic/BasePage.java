package Com.Actitime.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{	
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
        this.driver= driver;        

	}
	
	public void VerifyTitle(String eTitle)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		try
		{
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Title is matching "+eTitle ,true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching;Expected Tile is "+eTitle, true);
			Reporter.log("Actual Title is"+driver.getTitle(), true);
			Assert.fail();
			
		}
	}
	
	public void VerifyElement(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			Reporter.log("Element is present" ,true );
			
		}
		catch(Exception e )
		{
			Reporter.log("Element is Not present" , true);
			Assert.fail();
		}
				
				
		
	}
	

}
