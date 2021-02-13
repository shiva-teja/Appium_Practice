import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import org.junit.Assert;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Ecommerce_TC03 extends base_ecommerce{
	
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
				AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement country=driver.findElement(By.id("android:id/text1"));
		WebElement nametextbox=driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']");
		WebElement malegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Male']");
		WebElement femalegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Female']");
		WebElement letsshopbutton=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		
		country.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));").click();
//		countrycanada.click();
//		letsshopbutton.click();
//		
//		String msg=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
//		System.out.println(msg);
		
		
		
		nametextbox.sendKeys("Shivateja");
		driver.hideKeyboard();
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(malegenderradiobutton))).perform();
		letsshopbutton.click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		String price1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		String price2=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		
		double total_expected=Float.parseFloat(price1.replace("$", ""))+Float.parseFloat(price2.replace("$", ""));
		double total_actual=Float.parseFloat(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$", ""));
		
		if(total_expected==total_actual)
		{
			System.out.println("True");
		}
		else {
			System.out.println("Fail");
		}
	}

}
