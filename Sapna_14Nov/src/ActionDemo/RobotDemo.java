package ActionDemo;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotDemo {
	
	public static WebDriver driver;
	public static WebElement element;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Sapna_Selenium3Plus_14-18Nov/Execuables/chromedriver.exe/");
		driver = new ChromeDriver();
		driver.get("http://postimages.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		//Creating screenshot----
		File sfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sfile, new File("C:\\Sapna_Selenium3Plus_14-18Nov\\snaps\\Demo.png"));
		Thread.sleep(3000);
		driver.findElement(By.id("uploadFile")).click();
		
		//Copying file path to clip board---
		StringSelection copy= new StringSelection("C:\\Sapna_Selenium3Plus_14-18Nov\\snaps\\Demo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy, null);

		Thread.sleep(2000);
		
		Robot rob = new Robot();
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.setAutoDelay(1000);
		
		rob.keyPress(KeyEvent.VK_V);
		rob.setAutoDelay(1000);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.setAutoDelay(1000);
		
		rob.keyRelease(KeyEvent.VK_V);
		rob.setAutoDelay(1000);
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.setAutoDelay(1000);
		
		/*
		System.out.println("passed");
		
		driver.close(); */
		
	}

}
