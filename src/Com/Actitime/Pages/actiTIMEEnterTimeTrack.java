package Com.Actitime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Actitime.Generic.BasePage;

public class actiTIMEEnterTimeTrack extends BasePage
{
 
	//decration
	@FindBy(id="logoutLink")
	private WebElement logoutbtn;
	
	//initilization
	public actiTIMEEnterTimeTrack(WebDriver driver)
	{
		super(driver);
      PageFactory.initElements(driver, this);

	}
	
	//utilization
	//to click on logout
	public void clickonlogout()
	{
		logoutbtn.click();
	}

}
