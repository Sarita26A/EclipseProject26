package UdemyCourse;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {
	public static void main(String args[]) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File fo=(ts).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fo, new File("D:\\Screenshot.png"));
		
	}

}
