package UdemyCourse;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandleDemo {
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		//Locator of start date
		driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']")).click();
		
		//set the month to April
		while(!(driver.findElement(By.cssSelector("div[class='flatpickr-current-month'] span[class='cur-month']"))
				.getText().contains("April"))) 
		{
			driver.findElement(By.cssSelector("span[class='flatpickr-next-month'] svg")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//System.out.println("Inside Whileloop");
		}
		
		//Set the date to 23
		List<WebElement> dates=driver.findElements(By.cssSelector("div[class='dayContainer'] span[class*='flatpickr-day']"));
		for(int i=0;i<dates.size();i++) 
		{
			String text=driver.findElements(By.cssSelector("div[class='dayContainer'] span[class*='flatpickr-day']")).get(i).getText();
			//System.out.println(text);
			if(text.equalsIgnoreCase("23"))
			{
				dates.get(i).click();
				System.out.println("Date is Matched");
				break;
			}
		}
		
	}

}
