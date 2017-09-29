package selenium.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebTest
{
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		//driver = new HtmlUnitDriver();
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void  tearDown() throws Exception
	{
		driver.close();
		driver.quit();
	}

	@Test
	public void participantCount() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		// http://geekswithblogs.net/Aligned/archive/2014/10/16/selenium-and-timing-issues.aspx
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(), 'Frustration of Software Developers')]/../../following-sibling::div//span[@class='backers']")));
		List<WebElement> spans = driver.findElements(By.xpath("//div//span[contains(text(), 'Frustration of Software Developers')]/../../following-sibling::div//span[@class='backers']"));
		String text = new String( spans.get(0).getText());
		
		assertEquals("55", text);
	}
	
	@Test
	public void Closed() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		// http://geekswithblogs.net/Aligned/archive/2014/10/16/selenium-and-timing-issues.aspx
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//a[@class='status']/span[.='CLOSED']"));

		assertNotNull(spans);
		assertEquals(5, spans.size());
	}
	
	
	@Test
	public void clickParticipate() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		// Checking count of Open status studies, matching its count with Participate button count
		// Then matching count of Participate button and Participate buttons with attribute data-href
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='OPEN']")));
		List<WebElement> spans = driver.findElements(By.xpath("//a[@class='status']/span[.='OPEN']"));
		List<WebElement> buttons = driver.findElements(By.xpath("//button[.='Participate']"));
		List<WebElement> buttonsClickable = driver.findElements(By.xpath("//button[.='Participate'][@data-href]"));
		
		assertEquals(buttons.size(), spans.size());
		assertEquals(buttonsClickable.size(), buttons.size());
	}
	
	
	@Test
	public void amazonPresent() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		// Checking the presence of amazon reward image using link /media/amazongc-micro.jpg
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[contains(text(), 'Software Changes Survey')]")));
		List<WebElement> spans = driver.findElements(By.xpath("//div//span[contains(text(), 'Software Changes Survey')]/../..//div[@class='award']//img[@src='/media/amazongc-micro.jpg']"));

		assertEquals(1,spans.size());
	}
}
