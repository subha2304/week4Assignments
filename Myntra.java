package week4Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver .manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://WWW.myntra.com/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		builder.moveToElement(findElement).perform();
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		
		System.out.println("the number of items "+ text);
		String jack1= driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		
		String replace = jack1.replace("(","");
		String jackrep1= replace.replace(")","");
		String jack2= driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String replace1 = jack2.replace("(","");
		String jackrep2= replace1.replace(")","");
		int i = Integer.parseInt(jackrep1);
		int j = Integer.parseInt(jackrep2);
		int total=i+j;
		String totalstr = Integer.toString(total);
		System.out.println(total);
		if(!text.equals(totalstr)) {
		System.out.println("not same");
		}
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("(//span[@class='FilterDirectory-count'])[1]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'close sprites-remove')]")).click();
		Thread.sleep(2000);
		List<WebElement> findElements = driver.findElements(By.xpath("//li[@class='product-base']//h3"));
		//List<String> arraylist = new ArrayList<String>();
		int count =0;
		for(WebElement totallist:findElements) {
		String text2 = totallist.getText();
		if(text2.contains("Duke")) {
			count++;
		}
		}
		if(count==findElements.size()) {
		System.out.println("all are same");
		}
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		WebElement findElement2 = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		builder.moveToElement(findElement2).perform();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		String text2 = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("the first item price is"+ text2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);

		driver.switchTo().window(windowHandlesList.get(1));
		driver.manage().window().maximize();
		TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
	    File dst = new File("./snaps/myntra.png");
	    FileUtils.copyFile(src , dst);
	    driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
	    driver.quit();
	    
		//if(text.equals(total)) {
		//	System.out.println("the items are same ");
		//}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
