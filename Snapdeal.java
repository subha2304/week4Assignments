package week4Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver .manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://WWW.snapdeal.com/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement mensfash = driver.findElement(By.xpath("(//span[text()=\"Men's Fashion\"])[2]"));
		builder.moveToElement(mensfash).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String shoecount = driver.findElement(By.xpath("(//div[@class='child-cat-count '] )[2]")).getText();
		System.out.println("the count of the shoe" + shoecount);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).sendKeys("900");
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='filter-color-tile Red '] ")).click();
		driver.findElement(By.xpath("//div[@class='navFiltersPill']/following::a[text()='Rs. 900 - Rs. 1200']")).isDisplayed();
				driver.findElement(By.xpath("//div[@class='navFiltersPill']/following::a[text()='Red']")).isDisplayed();
		Thread.sleep(2000);
	WebElement findElement = driver.findElement(By.xpath("//p[@class='product-title']"));
	builder.moveToElement(findElement).perform();
	driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		String text = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	System.out.println(text);
	String text2 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
	System.out.println(text2);
	TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
    File dst = new File("./snaps/snap.png");
    FileUtils.copyFile(src , dst);
    driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
    driver.close();
	}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
