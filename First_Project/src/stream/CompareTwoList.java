package stream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareTwoList {
	@Test
	public void compareTwoList()
	//public static void main(String args[]) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("tr th:nth-child(1)")).click();
		List<WebElement> elementsList=driver.findElements(By.cssSelector("tr td:nth-child(1)"));
		List<String> originalElement=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> newSortedElement=originalElement.stream().sorted().collect(Collectors.toList());
		System.out.println(originalElement);
		System.out.println(newSortedElement);
		Assert.assertEquals(originalElement,newSortedElement);
	}

}
