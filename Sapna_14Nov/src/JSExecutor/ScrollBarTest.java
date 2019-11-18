package JSExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollBarTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Sapna_Selenium3Plus_14-18Nov/Execuables/chromedriver.exe/");
		WebDriver driver = new ChromeDriver();
		driver.get("https://docs.seleniumhq.org//");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,800)");
		js.executeScript("alert('windows has scrolled down')");
		Thread.sleep(5000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.close();

	}

}
