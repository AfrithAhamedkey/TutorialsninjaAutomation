package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_010 {
	@Test
	public void verifyWarningMessageForInvalidMailAddress() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Afrith");
		driver.findElement(By.id("input-lastname")).sendKeys("Ahamed");
		WebElement email = driver.findElement(By.id("input-email"));


		
		//driver.findElement(By.id("input-email")).sendKeys(CommonUtils.genarateEmail());
		
		driver.findElement(By.id("input-telephone")).sendKeys("123456789");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
		driver.findElement(By.name("agree")).click();
		
		email.sendKeys("afrith");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String err1 = email.getAttribute("validationMessage");
		Assert.assertTrue(err1.length() > 0);
		
		email.clear();
		email.sendKeys("afrith@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String err2= email.getAttribute("validationMessage");
		Assert.assertTrue(err2.length() > 0);
		
	
		email.clear();
		email.sendKeys("afrith@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String err3= email.getAttribute("validationMessage");
		Assert.assertTrue(err3.length()>0);
		
		email.clear();
		email.sendKeys("afrith@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//String err3= email.getAttribute("validationMessage");
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']")).isDisplayed());
		

		driver.quit();
	}

}
