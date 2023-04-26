
package UdemyCourse;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildWindow {
	public static void main(String args[]) {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
	//Get the window handle of parent window
	String parentId= driver.getWindowHandle();
	System.out.println(parentId);
	//Locator for
	driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
	Set<String> handleId=driver.getWindowHandles();
	//Switching to child Window 
	for(String handles:handleId) 
	{
		if(!(handles.equals(parentId)))
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.switchTo().window(handles);
			driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
			String emailId=driver.findElement(By.cssSelector("p[class='im-para red']")).getText()
					.split("at")[1].trim().split(" ")[0];
			driver.switchTo().window(parentId);
			driver.findElement(By.id("username")).sendKeys(emailId);
		}
	}
	
	}

}
