package week4Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://dev109266.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=8bo2FCJNiaaT");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Hello@123");
	driver.findElement(By.id("sysverb_login")).click();
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
	driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
	Thread.sleep(2000);
	driver.switchTo().frame(driver.findElement(By.xpath("//main[@class='navpage-main']//iframe[@id='gsft_main']")));
	driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("helloo");
	String attribute = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
	driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
	Set<String> windowHandlesSet1 = driver.getWindowHandles();
	ArrayList<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
	driver.switchTo().window(windowHandlesList1.get(1));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//tbody/tr/td/a[text()='Abel Tuter']")).click();
    driver.switchTo().window(windowHandlesList1.get(0));
	driver.switchTo().frame(driver.findElement(By.xpath("//main[@class='navpage-main']//iframe[@id='gsft_main']")));
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
	WebElement element = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	element.sendKeys(attribute);
	element.sendKeys(Keys.ARROW_DOWN);
	element.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//tbody/tr/td/a[@class='linked formlink']")).isDisplayed();
    TakesScreenshot tk = (TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
    File dst = new File("./snaps/pic1.png");
    FileUtils.copyFile(src , dst);
	}

}
