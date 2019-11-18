package JSExecutor;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Sapna_Selenium3Plus_14-18Nov/Execuables/chromedriver.exe/");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		
		Cookie cookie1 = new Cookie("Name","Username");
		driver.manage().addCookie(cookie1);
		Cookie cookie2 = new Cookie("Value","password");
		driver.manage().addCookie(cookie2);
		
		Set<Cookie> ck = driver.manage().getCookies();
		
		for(Cookie c:ck)
		{
			System.out.println("Name " + c.getName());
			System.out.println("Value " + c.getValue());
			System.out.println("Path " + c.getPath());
			System.out.println("Domain " + c.getDomain());
			System.out.println("Expires " + c.getExpiry());
			
		}
		
		
		///driver.close();
		
		
	}

}
