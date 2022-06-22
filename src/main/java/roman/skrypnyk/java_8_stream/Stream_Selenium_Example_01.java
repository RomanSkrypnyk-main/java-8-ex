package roman.skrypnyk.java_8_stream;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Stream_Selenium_Example_01 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://mvnrepository.com/");

		List<WebElement> webElementList = webDriver.findElements(By.tagName("a"));

		webElementList.forEach(x -> System.out.println(x.getText()));

		System.out.println("All count of hyperlinks <a> is : " + (long) webElementList.size());

		long notNullCountLinks = webElementList.stream().filter(link -> link.getAttribute("href") != null).count();
		System.out.println("All count of hyperlinks <a> with attribute <href> :" + notNullCountLinks);

		webDriver.close();
	}

}
