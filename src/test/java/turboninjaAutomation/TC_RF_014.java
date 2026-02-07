package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_014 {
@Test
	public void verifyTheRedRequiredSymbol() {
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://tutorialsninja.com/demo");
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.linkText("Register")).click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	String starContentFN = (String) js.executeScript(
	    "return window.getComputedStyle(" +
	    "document.querySelector(\"label[for='input-firstname']\")," +
	    "'::before').getPropertyValue('content');"
	);

	String starContentLS = (String) js.executeScript(
		    "return window.getComputedStyle(" +
		    "document.querySelector(\"label[for='input-lastname']\")," +
		    "'::before').getPropertyValue('content');"
		);

	String starContentMail = (String) js.executeScript(
		    "return window.getComputedStyle(" +
		    "document.querySelector(\"label[for='input-email']\")," +
		    "'::before').getPropertyValue('content');"
		);


	String starContentTelephone = (String) js.executeScript(
		    "return window.getComputedStyle(" +
		    "document.querySelector(\"label[for='input-telephone']\")," +
		    "'::before').getPropertyValue('content');"
		);

	String starContentPassword = (String) js.executeScript(
		    "return window.getComputedStyle(" +
		    "document.querySelector(\"label[for='input-password']\")," +
		    "'::before').getPropertyValue('content');"
		);
	
	
	Assert.assertEquals("\"* \"",starContentFN);
	Assert.assertEquals("\"* \"",starContentLS);
	Assert.assertEquals("\"* \"",starContentMail);
	Assert.assertEquals("\"* \"",starContentTelephone);
	Assert.assertEquals("\"* \"",starContentPassword);
	
	driver.quit();
		
	}
}
