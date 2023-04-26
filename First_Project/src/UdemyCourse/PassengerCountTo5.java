package UdemyCourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PassengerCountTo5 {
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//locator to Passenger
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		Thread.sleep(1000);
		//Adding passenger count to 5
		for(int i=1;i<5;i++) 
		{
		driver.findElement(By.cssSelector("span[id='hrefIncAdt']")).click();
		}
		String passengerCount= driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText();
		System.out.println(passengerCount);
		driver.findElement(By.cssSelector("input[value='Done']")).click();
		Assert.assertTrue(true);
	}

@Test
	public void  example()
	{
		
	}
}
