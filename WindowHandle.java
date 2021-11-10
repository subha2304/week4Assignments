package week4Assignments;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
	 driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	 
     driver.findElement(By.id("password")).sendKeys("crmsfa");

	driver.findElement(By.className("decorativeSubmit")).click();
	
	 driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
Set<String> windowHandlesSet = driver.getWindowHandles();
ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);

driver.switchTo().window(windowHandlesList.get(1));
driver.manage().window().maximize();
driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
driver.switchTo().window(windowHandlesList.get(0));
driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
Set<String> windowHandlesSet1 = driver.getWindowHandles();
ArrayList<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);

driver.switchTo().window(windowHandlesList1.get(1));
driver.manage().window().maximize();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[text()='17742']")).click();
driver.switchTo().window(windowHandlesList1.get(0));

driver.findElement(By.xpath("//a[text()='Merge']")).click();
Alert alert = driver.switchTo().alert();
alert.accept();
String title = driver.getTitle();
System.out.println(title);






















	}

}
