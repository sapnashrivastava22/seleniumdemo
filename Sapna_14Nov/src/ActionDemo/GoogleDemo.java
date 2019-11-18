package ActionDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Sapna_Selenium3Plus_14-18Nov/Execuables/chromedriver.exe/");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Accenture");
		driver.findElement(By.name("btnK")).submit();
		
	driver.close();

	}

}
