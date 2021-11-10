package week4Assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		WebElement findElement = driver.findElement(By.xpath("(//section[@class='innerblock']//div//iframe)[1]"));
		driver.switchTo().frame(findElement);
		 WebElement pic = driver.findElement(By.xpath("//button[@id='Click']"));
		 TakesScreenshot tk = (TakesScreenshot) pic ;
			File src = tk.getScreenshotAs(OutputType.FILE);
		    File dst = new File("./snaps/pic1.png");
		    FileUtils.copyFile(src , dst);
		    driver.switchTo().defaultContent();
		     List<WebElement> numofframes = driver.findElements(By.tagName("iframe"));
		    int size = numofframes.size();
		    System.out.println("the number of frames"+size);
	}

}
