import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CricbuzzChrome extends basechrome{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://facebook.com");
//		driver.findElementByXPath("//input[@id='m_login_email']").sendKeys("shivateja37@gmail.com");
//		driver.findElementByXPath("//input[@id='m_login_password']").sendKeys("Shiv@007");
//		driver.findElementByXPath("//button[@value='Log In']").click();
		
		driver.get("https://m.cricbuzz.com/");
		driver.findElementByXPath("//a[@href='#menu']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//a[@title='Cricbuzz Home']").click();
		if(driver.findElementByXPath("//img[@title='Cricbuzz Logo']").isDisplayed())
		{
			System.out.println("TRue");
		}
		else {
			System.out.println("False");
		}
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,480)","");
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));

		
		
	}

}
