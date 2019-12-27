package Com.Actitime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Actitime.Generic.BasePage;

public class actiTIMELoginPage extends BasePage
{
   //declaration
	@FindBy(id="username")
	private WebElement untb;
	
	@FindBy(name="pwd")
	private WebElement pwtb;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement lgbtn;
	
	
	@FindBy(xpath="//span[contains(text(), 'invalid')]")
	private WebElement errmessage;
	
	@FindBy(xpath="//nobr[contains(text(), 'actiTIME ')]")
	private WebElement Version;	
	
	//initilization
	public actiTIMELoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);


	}
	//utilization
	//1.verify the title
	public void verifytheTitle(String eTitle)
	{
		VerifyTitle(eTitle);
	}
    //2.enter username
	public void enterusername(String un)
	{
		untb.sendKeys(un);
	}
	//3.enter the password
	public void enterpassword(String pw)
	{
		pwtb.sendKeys(pw);
	}
	//4.click on login
	public void clickOnlogin()
	{
		lgbtn.click();
	}
	//5.vefity the errmessage
	public String Verifyerrmessage()
	{
		VerifyElement(errmessage);
		String Aerrmessage = errmessage.getText();
		return Aerrmessage;
	}
	
	//6.Verify version
	public String VerifyVersion()
	{
		VerifyElement(Version);
		String AVersion = Version.getText();
		return AVersion;
		
	}
}
