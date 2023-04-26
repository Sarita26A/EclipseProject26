package UdemyCourse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableValidation {
	@Test
	public void tableDemo() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver .get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> amounts=driver.findElements(By.cssSelector("div[class='tableFixHead']  td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<amounts.size();i++) 
		{
			sum=sum+Integer.parseInt(amounts.get(i).getText());
		}
		
		System.out.println(sum);
		String amountDisplayed=driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(":")[1].trim();
		int amonutDisplayedInintFormat=Integer.parseInt(amountDisplayed);
		Assert.assertEquals(sum, amonutDisplayedInintFormat);
		
		
	}

}
