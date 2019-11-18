package ActionDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class KeyboardEvents {
	
	public static WebDriver driver;
	public static WebElement keyPress;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Sapna_Selenium3Plus_14-18Nov/Execuables/chromedriver.exe/");
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		
		keyPress = driver.findElement(By.cssSelector("input[value='Search store']"));
		
		action.keyDown(keyPress, Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(5000);
		
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		Assert.assertTrue(driver.getTitle().contains("Build your own computer"));
		System.out.println("The test is PASSED");
		
		driver.close();

	}

}
