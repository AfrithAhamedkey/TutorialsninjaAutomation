package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class TC_RF_016 {
	WebDriver driver = new ChromeDriver();
		@Test
		public void verifyMandatoryFieldsGivingErrorMessageinWhenEnteringSpaces() {
			
			
			
			driver.manage().window().maximize();
			
			driver.get("https://tutorialsninja.com/demo");
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-firstname")).sendKeys("     ");
			driver.findElement(By.id("input-lastname")).sendKeys("     ");
			driver.findElement(By.id("input-email")).sendKeys("     ");
			driver.findElement(By.id("input-telephone")).sendKeys("     ");
			driver.findElement(By.id("input-password")).sendKeys("1234");
			driver.findElement(By.id("input-confirm")).sendKeys("1234");
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			String inputFirstNameWarning = "First Name must be between 1 and 32 characters!";
			String inputLastNameWarning = "Last Name must be between 1 and 32 characters!";
			String inputEmailWarning = "E-Mail Address does not appear to be valid!";
			String inputTelephoneWarning = "Telephone must be between 3 and 32 characters!";

			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div[@class='text-danger']")).getText(),inputLastNameWarning);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div[@class='text-danger']")).getText(),inputFirstNameWarning);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div[@class='text-danger']")).getText(),inputEmailWarning);
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div[@class='text-danger']")).getText(),inputTelephoneWarning);
			
				
			
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();	
			
		}
}
