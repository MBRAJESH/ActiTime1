package Com.Actitime.Tests;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.Actitime.Generic.BaseTest;
import Com.Actitime.Generic.ExcelData;
import Com.Actitime.Pages.actiTIMELoginPage;

public class VerifyversionTest extends BaseTest
{
	@Test(priority=3)
	public void testVerifyVersion()
	{
		String LoginTitle = ExcelData.getdata(Filepath, "TC01", 1, 2);
		String EVersion = ExcelData.getdata(Filepath,  "TC03", 1,0);
		
		
		actiTIMELoginPage lp= new actiTIMELoginPage(driver);
		lp.verifytheTitle(LoginTitle);
		
		String AVersion = lp.VerifyVersion();
		Reporter.log("Actual version is "+AVersion, true);
		Reporter.log("the expectyed version is"+EVersion, true);
		
		Reporter.log("=============", true);
		
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(AVersion,EVersion);
		Reporter.log("the version is matching ...", true);
	}

}
