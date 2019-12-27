package Com.Actitime.Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Actitime.Generic.BaseTest;
import Com.Actitime.Generic.ExcelData;
import Com.Actitime.Pages.actiTIMEEnterTimeTrack;
import Com.Actitime.Pages.actiTIMELoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority=1)
	public void testValidloginlogout()
	{
		 String LoginTitle = ExcelData.getdata(Filepath, "TC01", 1,2);
		 String Username = ExcelData.getdata(Filepath, "TC01", 1, 0);
		String Password = ExcelData.getdata(Filepath, "TC01", 1, 1);
		String ETitle = ExcelData.getdata(Filepath, "TC01", 1, 3);
		
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTIMEEnterTimeTrack ep= new actiTIMEEnterTimeTrack(driver);
		
		
		//1.verify the title of login page
		lp.verifytheTitle(LoginTitle);
		
		//2. enter the username 
		Reporter.log("the user name is "+Username, true);
		lp.enterusername(Username);
		
		//3. enter the password
		Reporter.log("the password is  "+Password, true);
		lp.enterpassword(Password);
		
		//4. to click on login
		lp.clickOnlogin();
		
		//5.to verify the title of enter time track page
		lp.verifytheTitle(ETitle);
		
		/*//6.logout from appn
		ep.clickonlogout();
		
		//7.verify the title of login page				
		lp.verifytheTitle(LoginTitle);
		*/
	}

}
