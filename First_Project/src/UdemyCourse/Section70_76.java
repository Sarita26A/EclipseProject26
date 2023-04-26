package UdemyCourse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section70_76 {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.setup", "C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> product= driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(product.size());
		for(int i=0;i<product.size();i++) 
		{
			String nameOfVeggie=product.get(i).getText();
			System.out.println(nameOfVeggie);
			if(product.contains("Cucumber")) 
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
			}
			
		}
		
		
		}

}
