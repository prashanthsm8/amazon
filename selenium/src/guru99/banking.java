package guru99;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class banking  {

	
		// TODO Auto-generated method stub
		//String ET = "Guru99 Bank Manager HomePage";
		
		
		/*FileInputStream fis = new FileInputStream("D://sel_workspace//selenium//Util.properties");
		Properties pp = new Properties();
		pp.load(fis);*/
				
		/*FileInputStream fis2 = new FileInputStream("D:\\sel_workspace\\selenium\\UP.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis2);
		XSSFSheet sh = wb.getSheet("Sheet1");*/
		
			
		
			//driver.quit();
	public static WebDriver driver;
		
	
	@BeforeMethod
	public void Beftest()
	{
		
		System.setProperty("webdriver.chrome.driver", "D://sel_workspace//chromedriver_win32//chromedriver.exe");
	}
	
	@Test(groups= {"sanity"})
	public void test1() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(util.url+"/v4/");
		driver.manage().window().maximize();
		String[] data= util.getxcldata(0);
	
		driver.findElement(By.xpath("//*[@name='uid']")).sendKeys(data[0]);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(data[1]);
		
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin")));
		
		driver.findElement(By.name("btnLogin")).click();
		
		
	/*	Wait wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver) {
			 return driver.findElement(By.id("foo"));
			 }
		});
		*/		
	}
	
	@Test(groups= {"sanity"})
	public void test2() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(util.url+"/v4/");
		driver.manage().window().maximize();
		String[] data= util.getxcldata(1);
	
		driver.findElement(By.xpath("//*[@name='uid']")).sendKeys(data[0]);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(data[1]);
		
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin")));
		
		driver.findElement(By.name("btnLogin")).click();
			
	}
	
	@Test(dataProvider="getdata") 
	public void test3(String un, String pas) throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(util.url+"/v4/");
		driver.manage().window().maximize();
		//String[] data= util.getxcldata(2);
	
		driver.findElement(By.xpath("//*[@name='uid']")).sendKeys(un);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(pas);
		
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin")));
		WebElement et = driver.findElement(By.name("btnLogin"));
		
		Assert.assertFalse(et.isDisplayed());
		
		et.click();
			
	}


	@AfterMethod
	public  void aft()
	{
		driver.quit();
	}
	
	@DataProvider 
	public Object getdata()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="mngr128041";
		data[0][1]="eryjuqy";
		data[1][0]="mngr128041";
		data[1][1]="mngr12";
		
		
				
		return data;
		
	}
	
}


