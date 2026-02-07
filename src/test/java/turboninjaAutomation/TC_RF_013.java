package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_013 {
	@Test
	public void verifyFieldsInRegisterPageHavePlaceholders() {
		
		
		WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String placeholderFirstName = driver.findElement(By.id("input-firstname")).getAttribute("Placeholder");
		String placeholderLastName = driver.findElement(By.id("input-lastname")).getAttribute("Placeholder");

		String placeholderEmail = driver.findElement(By.id("input-email")).getAttribute("Placeholder");

		String placeholderTelephone = driver.findElement(By.id("input-telephone")).getAttribute("Placeholder");
		String placeholderPassword = driver.findElement(By.id("input-password")).getAttribute("Placeholder");

		String placeholderConfirmPassword = driver.findElement(By.id("input-confirm")).getAttribute("Placeholder");



		Assert.assertEquals("First Name",placeholderFirstName);
		Assert.assertEquals("Last Name",placeholderLastName);
		Assert.assertEquals("E-Mail",placeholderEmail);
		Assert.assertEquals("Telephone",placeholderTelephone);
		Assert.assertEquals("Password",placeholderPassword);
		Assert.assertEquals("Password Confirm",placeholderConfirmPassword);
		
		driver.quit();
		
		
		
	}

}
