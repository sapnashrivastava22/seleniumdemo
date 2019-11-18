package GridTest;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.ANY);
		URL link = new URL("http://10.216.139.9:3333/wd/hub");
		
		WebDriver driver = new RemoteWebDriver(link, dc);
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(500);		
		driver.findElement(By.id("Email")).sendKeys("hello@qbc.com");
		driver.findElement(By.id("Password")).sendKeys("Hello123");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[value='Log in']")).submit();
		Thread.sleep(2000);
		String webmsg = driver.findElement(By.cssSelector("a.account")).getText();
		System.out.println(webmsg);
		driver.findElement(By.linkText("Log out")).click();
		
		
		driver.quit();
	
	}

}
