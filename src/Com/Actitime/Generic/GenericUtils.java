package Com.Actitime.Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils 
{
	public static void getscreenshot(WebDriver driver, String name )
	{		
		try 
		{
			TakesScreenshot ts= (TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("./Screenshot/"+name+".png");
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) 
		{
			
		}
	}
	
	public static void selectindex(WebElement ele, int index)
	{
		Select sel= new Select(ele);
		sel.selectByIndex(index);
	}
	
	public static void selecttext(WebElement ele, String text)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}
	public static void selectvalue(WebElement ele, String value)
	{
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}

}
