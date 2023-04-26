package UdemyCourse;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkCount {
	@Test
	public void findLink() throws InterruptedException 
	{
		//1. count of links on webpage 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		int numOfLink=driver.findElements(By.tagName("a")).size();
		System.out.println(numOfLink);
		// Count of Links on footer section of webpage
		WebElement footer= driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement footerFirstColumn=footer.findElement(By.cssSelector("table tbody tr td:nth-child(1) ul"));
		System.out.println(footerFirstColumn.findElements(By.tagName("a")).size());
		int numberOfLinksOnFooter=footerFirstColumn.findElements(By.tagName("a")).size();
		//Click on each of the link
		String clickOnNewtab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		for(int i=1;i<numberOfLinksOnFooter;i++) 
		{
			footerFirstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnNewtab);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			Thread.sleep(2);
		}
		//Print title of each of the tab
		Set<String> windowHandleid=driver.getWindowHandles();
		System.out.println(windowHandleid);
		for(String windowHandles:windowHandleid) 
		{
			driver.switchTo().window(windowHandles);
			System.out.println(driver.getTitle());
		}
		
	}

}
