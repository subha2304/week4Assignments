package week4Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://WWW.amazon.in/");
			driver.manage().window().maximize();
			Actions builder = new Actions(driver);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
			driver.findElement(By.id("nav-search-submit-button")).click();
			driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
			Set<String> windowHandlesSet = driver.getWindowHandles();
			ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);

			driver.switchTo().window(windowHandlesList.get(1));
			driver.manage().window().maximize();
			String text = driver.findElement(By.xpath("//span[@id='priceblock_saleprice']")).getText();
			System.out.println("the price is"+text);
			String text2 = driver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]")).getText();
			System.out.println("the no of ratings " + text2);
			WebElement findElement = driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]"));
			builder.moveToElement(findElement).perform();
			driver.findElement(By.xpath("(//div[@class='a-meter'])[1]")).click();
			String text3 = driver.findElement(By.xpath("(//a[@class='a-link-normal'])[3]")).getText();
			System.out.println("the 5 star ratings "+ text3);
			
			driver.findElement(By.xpath("(//a[@class='a-link-normal'])[1]")).click();
			//WebElement findElement2 = driver.findElement(By.xpath(""));
			Thread.sleep(2000);
			TakesScreenshot tk = (TakesScreenshot)driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
		    File dst = new File("./snaps/pic2.png");
		    FileUtils.copyFile(src , dst);
		    driver.findElement(By.id("add-to-cart-button")).click();
		    Thread.sleep(2000);
		  
			WebElement element = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']"));
			String cartprice = element.getText();
			System.out.println(cartprice);
				
			
			
			if(cartprice.equals(text)) {
				System.out.println("it is verified");
				
			}else {
				System.out.println();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
	}

}
