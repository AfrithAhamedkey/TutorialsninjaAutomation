package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {
	@Test
	public void verifyNotificationForMandatoryFieldsWhenDetailsNotProvidedInRegisterAccount() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String inputFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String inputLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String inputEmailWarning = "E-Mail Address does not appear to be valid!";
		String inputTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String inputPasswordWarning = "Password must be between 4 and 20 characters!";
		String privacyWarning = "Warning: You must agree to the Privacy Policy!";
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div[1]")).getText());
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div[@class='text-danger']")).getText(),inputLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div[@class='text-danger']")).getText(),inputFirstNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div[@class='text-danger']")).getText(),inputEmailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div[@class='text-danger']")).getText(),inputTelephoneWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div[@class='text-danger']")).getText(),inputPasswordWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),privacyWarning);
		
		driver.quit();
		
		
		
		
	}

}
