import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends base{
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		
//		driver.findElementByXPath("//android.widget.CheckBox[@resource-id='android:id/checkbox']").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//		driver.findElementByXPath("//android.widget.LinearLayout[@resource-id='android:id/edittext_container']").sendKeys("HelloWorld");
		driver.findElementById("android:id/edit").sendKeys("HelloWorld");
//		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
