package UdemyCourse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String args[]) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver .get("https://www.walmart.com/");
		List<WebElement> allLinks= driver.findElements(By.tagName("a"));
		List<String> urls=new ArrayList<>();
		System.out.println(allLinks.size());
		for(WebElement links:allLinks) 
		{
			String urlName=links.getAttribute("href");
			urls.add(urlName);	
			URL newUrl=new URL(urlName);
			HttpURLConnection httpUrlConnection=(HttpURLConnection) newUrl.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			if(httpUrlConnection.getResponseCode()>404) 
			{
				System.out.println(newUrl+"---->"+httpUrlConnection.getResponseMessage()+ "is a broken Link");
				Assert.assertTrue(false);
            
			}
			else 
			{
				 // System.out.println(httpUrlConnection.getResponseMessage()+ "Url is working fine");
				  Assert.assertTrue(true);
			}
		}
		
		
	}

}
