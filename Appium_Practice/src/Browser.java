import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Browser extends basechrome{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		driver.findElementByXPath("//input[@id='m_login_email']").sendKeys("shivateja37@gmail.com");
		driver.findElementByXPath("//input[@id='m_login_password']").sendKeys("Shiv@007");
		driver.findElementByXPath("//button[@value='Log In']").click();
		
	}

}
