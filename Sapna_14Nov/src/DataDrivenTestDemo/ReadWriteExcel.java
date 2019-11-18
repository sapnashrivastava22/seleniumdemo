package DataDrivenTestDemo;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadWriteExcel {

	public static WebDriver driver;
	public static FileInputStream fRead;
	public static FileOutputStream fWrite;
	public static XSSFWorkbook wb;
	public static XSSFSheet xs;
	public static String id, pwd, xlmsg;
	public static String pass = "Test is passed";
	public static String fail= "Test is failed";
	
	
	public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Sapna_Selenium3Plus_14-18Nov/Execuables/chromedriver.exe/");
		
		
		fRead = new FileInputStream("C:\\Sapna_Selenium3Plus_14-18Nov\\Data.xlsx"); // create new file object with path to the created exel
		wb = new XSSFWorkbook(fRead); // create workbook
		xs = wb.getSheet("Sheet1"); // or use getSheetAt(0) --- using index
		
		for(int i=1; i<xs.getPhysicalNumberOfRows() ; i++) 
		{
		
		id= xs.getRow(i).getCell(0).getStringCellValue();
		pwd= xs.getRow(i).getCell(1).getStringCellValue();
		xlmsg=xs.getRow(i).getCell(2).getStringCellValue();
		
		
		//---Reading the data from cells
		//System.out.println(d1);
		//System.out.println(d2);
		
		//--- Browser
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		
		//--Login & Logout check
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(500);
		driver.findElement(By.id("Email")).sendKeys(id);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("input[value='Log in']")).submit();
		Thread.sleep(2000);
		String webmsg = driver.findElement(By.cssSelector("a.account")).getText();
		//System.out.println(webmsg);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(2000);
		
		System.out.println("Login ID used: " + id);
		System.out.println("Password used: " + pwd);
		System.out.println("The user name is: " + webmsg);
		
		fWrite = new FileOutputStream("C:\\Sapna_Selenium3Plus_14-18Nov\\Data.xlsx");
		xs.getRow(i).createCell(3).setCellValue(webmsg);
		
		
		if(webmsg.equals(xlmsg)) {
			System.out.println("Test is PASSED");
			xs.getRow(i).createCell(4).setCellValue(pass);
		}
		else
		{
			System.out.println("Test is FAILED");
			xs.getRow(i).createCell(4).setCellValue(fail);
		}
		
		wb.write(fWrite);
		driver.close();
		}
		
		wb.close();
		
		
		

	}

}
