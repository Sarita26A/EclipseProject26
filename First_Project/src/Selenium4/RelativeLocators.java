package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.cssSelector("input[class*='form-control']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());
		System.out.println(driver.findElement(with(By.tagName("label")).below(name)).getText());
		//Click submit button which is below dateOf Birth
		WebElement dateOfBirth=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		//Click webElement left of the element
		WebElement checkBoxText=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxText)).click();
		WebElement employmentStatus=driver.findElement(By.cssSelector("label[for='exampleFormControlRadio1']"));
		driver.findElement(with(By.tagName("label")).toRightOf(employmentStatus)).click();
		

	}

}
