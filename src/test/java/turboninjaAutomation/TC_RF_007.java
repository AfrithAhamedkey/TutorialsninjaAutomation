package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {
	@Test
	public void verifyDifferentMethodsToNavigateRegisterAccount() {
		
		WebDriver driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Register Account']")).isDisplayed());
		
		 driver.findElement(By.xpath("//aside[@id='column-right']//a[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Register Account']")).isDisplayed());
		
		driver.quit();
		
	}

}
