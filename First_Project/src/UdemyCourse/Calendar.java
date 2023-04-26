package UdemyCourse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_view_date1']")).click();
		//System.out.println(driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText());
		//driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
		//System.out.println(driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText());
		
		//Set date as 23rd August
		
		//Set month as August
		while(!(driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText().equals("August")))
		{
			driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
		
		//set date as 23
		List<WebElement>dates=driver.findElements(By.cssSelector("a[class='ui-state-default']"));
		int sizeOfDates=dates.size();
		for(int i=0;i<sizeOfDates;i++) 
		{
			if(dates.get(i).getText().equals("23")) 
			{
				//driver.findElements(By.cssSelector("a[class='ui-state-default']")).get(i).click();
				dates.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
	}

}
