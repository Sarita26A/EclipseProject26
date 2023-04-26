package stream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterWebTable121 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("input[id='search-field'")).sendKeys("Rice");
		List<WebElement> veggie=driver.findElements(By.cssSelector("tr td:nth-child(1)"));
		List<WebElement> filterVeggie=veggie.stream().filter(veg->veg.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(veggie.size(), filterVeggie.size());
		
		

	}

}
