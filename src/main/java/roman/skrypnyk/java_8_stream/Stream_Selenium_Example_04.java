package roman.skrypnyk.java_8_stream;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stream_Selenium_Example_04 {
	public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			WebDriver webDriver = new ChromeDriver();
		try {
			webDriver.get("http://demowebshop.tricentis.com/");
			webDriver.manage().window().maximize();

			List<WebElement> productItemsList = webDriver.findElements(By.xpath("//h2[@class='product-title']"));
			List<WebElement> priceElementsList = webDriver.findElements(By.xpath("//div[@class='prices']"));

			Map<String, Double> productsWithPrice = new HashMap<>();

			for (int i = 0; i < priceElementsList.size(); i++) {

				String title = productItemsList.get(i).getText();
				Double price = Double.parseDouble(priceElementsList.get(i).getText());
				productsWithPrice.put(title, price);
			}

			productsWithPrice.forEach((i,p) -> System.out.println("Item name: " + i + " | Item price: " + p));
			System.out.println("---------------");
			productsWithPrice.entrySet().stream().filter(x -> x.getValue() > 800).forEach(v -> System.out.println("Items with price >800: " + v));

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			webDriver.quit();
		}
	}
}
