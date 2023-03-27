import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			//Setting Up driver 
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			// Launching the browser 
			driver.get("https://www.amazon.in/");
			
			// Maximizing browser 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
			
			//Searching the product 
			WebElement EnterProduct = driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']"));
			EnterProduct.sendKeys("Samsung Mobile");
			
			//Clicking on search button 
			WebElement Searching = driver.findElement(By.xpath("//span[@aria-label='Go']"));
			Searching.click();
			
			//Taking Screenshot
			TakesScreenshot tsObj = (TakesScreenshot) driver;
			File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
			File screenshotObj = new File("src/Selenium/screenshot.png");
			FileUtils.copyFile(fileObj,screenshotObj);
			
			
			
			
			//Search Element
			List <WebElement> Productname = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
			List <WebElement> ProductPrice = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));
			List <WebElement> ProductSymbol = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
			
			//Print element name, price and Symbol
			for(int i = 0;i<Productname.size(); i++) {
			System.out.println(" Product" +Productname.get(i).getText());
			System.out.println("Price and Symbol "+ " " + ProductSymbol.get(i).getText()+ " "+ProductPrice.get(i).getText());
			
		}
		 driver.close();
		
		
		

	}
}

