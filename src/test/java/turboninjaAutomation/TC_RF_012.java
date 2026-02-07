package turboninjaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_012 {
	@Test
	public void verifyInputViaKeyboard() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Actions action = new Actions(driver);
		
		for(int i =1;i<=23;i++) {
			action.sendKeys(Keys.TAB).perform();
			
		}
		
		action.sendKeys("Afrith").sendKeys(Keys.TAB).perform();
		action.sendKeys("Ahamed").sendKeys(Keys.TAB).perform();
		action.sendKeys(CommonUtils.genarateEmail()).sendKeys(Keys.TAB).perform();
		action.sendKeys("0123548").sendKeys(Keys.TAB).perform();
		action.sendKeys("1234").sendKeys(Keys.TAB).perform();
		action.sendKeys("1234").sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
		
		driver.quit();	

		
		
	
		
		
	}

}
