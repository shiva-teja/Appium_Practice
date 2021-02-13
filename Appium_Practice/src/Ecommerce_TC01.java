import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.*;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Ecommerce_TC01 extends base_ecommerce{
	
	

	public static void main(String[] args) throws MalformedURLException {
		
		login();
//		AndroidDriver<AndroidElement> driver=capabilities();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		AndroidDriver<AndroidElement> driver=capabilities();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		WebElement country=driver.findElementById("android:id/text1");
////		WebElement countrycanada=driver.findElementById("//android.widget.TextView[@text='Canada']");
////		WebElement country=driver.findElement(By.id("android:id/text1"));
//		WebElement nametextbox=driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']");
//		WebElement malegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Male']");
//		WebElement femalegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Female']");
////		WebElement letsshopbutton=driver.findElementByXPath("//android.widget.Button[@text='Let\'s  Shop']");
//		WebElement letsshopbutton=driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
//		
//		country.click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));").click();
////		countrycanada.click();
//		letsshopbutton.click();
//		
//		String msg=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
//		System.out.println(msg);
//		
//		
//		
//		nametextbox.sendKeys("Shivateja");
//		driver.hideKeyboard();
//		TouchAction t = new TouchAction(driver);
//		t.tap(tapOptions().withElement(element(malegenderradiobutton))).perform();
//		letsshopbutton.click();
		
		

	}
	public static void login() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		WebElement countrycanada=driver.findElementById("//android.widget.TextView[@text='Canada']");
		WebElement country=driver.findElement(By.id("android:id/text1"));
		WebElement nametextbox=driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']");
		WebElement malegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Male']");
		WebElement femalegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Female']");
//		WebElement letsshopbutton=driver.findElementByXPath("//android.widget.Button[@text='Let\'s  Shop']");
		WebElement letsshopbutton=driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		
		country.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));").click();
//		countrycanada.click();
		letsshopbutton.click();
		
		String msg=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(msg);
		
		
		
		nametextbox.sendKeys("Shivateja");
		driver.hideKeyboard();
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(malegenderradiobutton))).perform();
		letsshopbutton.click();
	}

}
