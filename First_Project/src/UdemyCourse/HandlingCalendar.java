package UdemyCourse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingCalendar {
	
	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']")).click();
		//select 23rd April 2023 in the calendar
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Code to select month in the calendar
		System.out.println("Hello");
		//WebElement element= driver.findElement(By.cssSelector("div[class='flatpickr-current-month'] span[class='cur-month']"));
		//System.out.println(element.getText());
		//driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//System.out.println(driver.findElement(By.cssSelector("div[class='flatpickr-current-month'] span[class='cur-month']")).getText());
		while(!(driver.findElement(By.cssSelector("div[class='flatpickr-current-month'] span[class='cur-month']")).getText().contains("April"))) 
		{
			driver.findElement(By.cssSelector("span[class='flatpickr-next-month'] svg")).click();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			System.out.println("Inside Whileloop");
		}
		System.out.println("April Month is selected");
		//Code to select date on the calendar
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<WebElement> dates=driver.findElements(By.cssSelector("div[class='dayContainer'] span"));
		//List<WebElement> dates=driver.findElements(By.cssSelector("span[class='flatpickr-day '] "));
		for(int i=0;i<dates.size();i++) 
		{
			Thread.sleep(2000);
			String text=driver.findElements(By.cssSelector("div[class='dayContainer'] span")).get(i).getText();
			//System.out.println(dates.get(i).getText());
			if(text.equalsIgnoreCase("23")){
				dates.get(i).click();
				//System.out.println("Date is Matched");
				break;
			}
		}
	}

}
