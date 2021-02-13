import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC02 extends base_ecommerce{
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		WebElement countrycanada=driver.findElementById("//android.widget.TextView[@text='Canada']");
		WebElement country=driver.findElement(By.id("android:id/text1"));
		WebElement nametextbox=driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']");
		WebElement malegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Male']");
		WebElement femalegenderradiobutton=driver.findElementByXPath("//android.widget.RadioButton[@text='Female']");
		//		WebElement letsshopbutton=driver.findElementByXPath("//android.widget.Button[@text='Let\'s  Shop']");
		WebElement letsshopbutton=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));

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
		Thread.sleep(3000);

		if(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).isDisplayed())
		{
			//			driver.findElement(By.xpath("android.widget.TextView[@text='Nike Blazer Mid \'77'"))
			//			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"Air Jordan 9 Retro\"));");
			//			List<AndroidElement> addtocarts=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
			//			WebElement
			//			for(WebElement ele:addtocarts)
			//			{
			//				if())
			//				ele.click();
			//			}



			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))"));

			int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			for (int i=0;i<count;i++)
			{
				String prod=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				if(prod.equalsIgnoreCase("Air Jordan 9 Retro"))
				{
					driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
					break;	
				}
			}

		


		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String lastpageText=    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		Assert.assertEquals("Air Jordan 9 Retro", lastpageText);
	}
	}

}
