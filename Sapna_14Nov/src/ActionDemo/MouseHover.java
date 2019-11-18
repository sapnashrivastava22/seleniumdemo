package ActionDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MouseHover {
	
	public static WebDriver driver;
	public static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Sapna_Selenium3Plus_14-18Nov/Execuables/chromedriver.exe/");
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		
		element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
		
		
		element= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
		action.moveToElement(element).click().build().perform();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Desktops");
		System.out.println(driver.getTitle());
		System.out.println("Test has passed");
		driver.close();

	}

}
