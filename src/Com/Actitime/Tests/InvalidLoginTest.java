package Com.Actitime.Tests;
import static org.testng.Assert.expectThrows;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Actitime.Generic.BaseTest;
import Com.Actitime.Generic.ExcelData;
import Com.Actitime.Pages.actiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority=2)
	public void testInvlidLoginlogout() throws InterruptedException {
		String LoginTitle = ExcelData.getdata(Filepath, "TC01", 1, 2);
		String Eerrmessage = ExcelData.getdata(Filepath, "TC02", 1, 2);

		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.verifytheTitle(LoginTitle);

		int rc = ExcelData.getrowcount(Filepath, "TC02");

		for (int i = 1; i <= rc; i++) {
			String Username = ExcelData.getdata(Filepath, "TC02", i, 0);
			String Password = ExcelData.getdata(Filepath, "TC02", i, 1);

			
			Reporter.log("The username is " + Username, true);
			lp.enterusername(Username);
			Reporter.log("the passwrod is " + Password, true);
			lp.enterpassword(Password);

			lp.clickOnlogin();
			Thread.sleep(2000);

			String aErrmessage = lp.Verifyerrmessage();
			Reporter.log("The actual err message is " + aErrmessage, true);
			Reporter.log("the expected err message is " + Eerrmessage, true);

			Reporter.log("=============", true);
			Assert.assertEquals(aErrmessage, Eerrmessage);
			Reporter.log("the message is matching ......", true);
			Reporter.log("=============", true);

		}

	}

}
