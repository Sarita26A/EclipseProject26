package UdemyCourse;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptions106 {

	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		//To add   extension
		//options.addExtensions("");
		
		//When website needs proxy settings 
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("192.168.0.148:4444");
		options.setCapability("proxy", proxy);
		
		//To Block the popup
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		//To Set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		

	}

}
