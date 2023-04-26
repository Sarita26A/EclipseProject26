package UdemyCourse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver .get("https://rahulshettyacademy.com/AutomationPractice/");
		int NumberOFrow=driver.findElements(By.cssSelector("table[class='table-display'] tr")).size();
		System.out.println(NumberOFrow);
		int NumberOfCol=driver.findElements(By.cssSelector("table[class='table-display'] th")).size();
		System.out.println(NumberOfCol);
		List<WebElement> thirdRowContent=driver.findElements(By.cssSelector("table[class='table-display'] tr:nth-child(3) td"));
		for(WebElement abc:thirdRowContent) 
		{
			System.out.println(abc.getText());
		}
		
		
	}
}
