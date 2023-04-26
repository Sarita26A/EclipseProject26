package Selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokingMultipleTab {
	
	public static void main(String args[]) throws IOException 
	//Requirement open a site open other tab switch to the child tab grab course anme and place it in name text box
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//Switch between different tab and windows
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String parentWindowHandle=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/");
		//Scrolling the window
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)","");
		//js.executeScript("window.scrollby(0,document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement courseName=driver.findElement(By.xpath("//a[text()='Core java for Automation Testers + Interview Programs']"));
		String courseNameString=courseName.getText();
		System.out.println(courseNameString);
		Set<String> parentAndChild=driver.getWindowHandles();
		driver.switchTo().window(parentWindowHandle);
		
		//Take screenShot of WebElement 
		
		WebElement name=driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']"));
		name.sendKeys(courseNameString);
	
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("screenShot1.png"));
		//driver.switchTo().newWindow(WindowType.WINDOW);
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		
			
	}

}
