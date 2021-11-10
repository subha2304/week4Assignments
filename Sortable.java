package week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.messages.Messages.Location;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		 WebElement findElement = driver.findElement(By.xpath("//div[@id='content-wrapper']//div//div//iframe"));
		 driver.switchTo().frame(findElement);
		
		 WebElement item1 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[1]"));
		 WebElement item6 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[6]"));
		Point location1 = item6.getLocation();
		int x = location1.getX();
		int y = location1.getY();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, x, y).perform();
		 
	}

}
