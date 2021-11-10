package week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		WebElement findElement = driver.findElement(By.xpath("//div[@id='content-wrapper']//div//div//iframe"));
		driver.switchTo().frame(findElement);
		WebElement element = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));

		Actions builder = new Actions(driver);
		builder.dragAndDropBy(element, 150, 100).perform();
		
	}

}
