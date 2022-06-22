package roman.skrypnyk.java_8_stream;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Stream_Selenium_Example_02 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://mvnrepository.com/");

		//to open new window url
		webDriver.switchTo().newWindow(WindowType.TAB);
		webDriver.get("https://www.flipkart.com/");

		//to capture windows ids
		Set<String> windowsIds = webDriver.getWindowHandles();

		windowsIds.forEach(winId -> System.out.println(webDriver.switchTo().window(winId).getTitle()));

		webDriver.quit();

		///html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a

	}
}
