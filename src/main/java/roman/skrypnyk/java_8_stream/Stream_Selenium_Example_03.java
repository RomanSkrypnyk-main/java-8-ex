package roman.skrypnyk.java_8_stream;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Selenium_Example_03 {

	public static void main(String[] args) {

		//Ex1 Compare: if sort on web page is work correctly
		WebDriverManager.chromedriver().setup();
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://demowebshop.tricentis.com/");

		webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")).click(); // click&go link: Books
		Select sortByAtoZ = new Select(webDriver.findElement(By.id("products-orderby")));
		sortByAtoZ.selectByVisibleText("Name: A to Z");

		//select all items
		List<WebElement> originProductItems = webDriver.findElements(By.xpath("//h2[@class='product-title']"));
		List<String> beforeSortProductItems = originProductItems.stream().map(item -> item.getText()).collect(Collectors.toList());
		List<String> afterSortProductItems = originProductItems.stream().map(item -> item.getText()).sorted().collect(Collectors.toList());
		//afterSortProductItems.add("test non equal");
		List<String> a = afterSortProductItems.stream().sorted(Comparator.reverseOrder()).toList();
		List<String> b = afterSortProductItems.stream().sorted(Comparator.naturalOrder()).toList();
		List<String> c = afterSortProductItems.stream().max(Comparator.naturalOrder()).stream().toList();
		System.out.println("reverse: " + a);
		System.out.println("natural: " + b);
		System.out.println("max natural: " + c);

		System.out.println("origin items: " + beforeSortProductItems);
		System.out.println("item after sort: " + afterSortProductItems);
		boolean isEqual = beforeSortProductItems.equals(afterSortProductItems);
		System.out.println("is origin vs sort equal: " + isEqual);


		webDriver.close();
	}

}
