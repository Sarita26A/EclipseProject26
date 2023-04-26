package UdemyCourse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Section7_58thlect {
	
	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option:options) 
		{
			if(option.getText().equalsIgnoreCase("India")) 
			{
				option.click();
			}
		}
		Assert.assertEquals(false, null);
	
		
		
	}

}
