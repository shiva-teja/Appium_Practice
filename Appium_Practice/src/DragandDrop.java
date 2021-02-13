import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragandDrop extends base{
public static void main(String[] args) throws MalformedURLException {
	AndroidDriver<AndroidElement> driver=capabilities();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
	WebElement ele1=driver.findElementsByClassName("android.view.View").get(0);
	WebElement ele2=driver.findElementsByClassName("android.view.View").get(1);
	
	TouchAction t =new TouchAction(driver);
	t.longPress(element(ele1)).moveTo(element(ele2)).release().perform();
	System.out.println(driver.findElementByXPath("//*[@text='Dropped!']").isDisplayed()
			);
}
}
