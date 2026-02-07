package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_011 {

	@Test
	public void verifyWarningMessageForInvalidPhoneNumber() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Afrith");
		driver.findElement(By.id("input-lastname")).sendKeys("Ahamed");
		
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.genarateEmail());
		
		driver.findElement(By.id("input-telephone")).sendKeys("abcd"); 
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.id("input-telephone-Warning")).isDisplayed());
		
		Assert.assertFalse(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
	
		
		
		
		driver.quit();
		
		
	}
}
