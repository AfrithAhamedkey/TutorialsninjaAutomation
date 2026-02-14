package turboninjaAutomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_015 {
	
	
	@Test
	public void verifyTheProvidedDetailsStoredInDatabase() throws SQLException {
		
		String dummymail = CommonUtils.genarateEmail();
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("http://localhost/shop/");
	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Register")).click();
	    driver.findElement(By.id("input-firstname")).sendKeys("Testing");
	    driver.findElement(By.id("input-lastname")).sendKeys("lastnametesting");
	    driver.findElement(By.id("input-email")).sendKeys(dummymail);
	    driver.findElement(By.id("input-password")).sendKeys("123456");
	    
	 
	   // driver.findElement(By.name("agree")).click();
	    WebElement element = driver.findElement(By.name("agree")); // The Privacy Policy checkbox
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	 // Locate the Continue button
	    WebElement continueBtn = driver.findElement(By.xpath("//button[text()='Continue']"));

	    // Use JavaScript to force the click
	  
	    js.executeScript("arguments[0].click();", continueBtn);
	    driver.quit();
	    
	    // JDBC Work.............
	    
	    String url = "jdbc:mysql://localhost:3306/opencartdb";
	    String username = "root";
	    String password = "";
	    String query = "SELECT firstname , lastname, email FROM customer ORDER BY customer_id DESC LIMIT 1";
	    
	    Connection con = DriverManager.getConnection(url, username, password);
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    
	    String firstname , lastname , email;
	    
	    while(rs.next()) {
	    	firstname = rs.getString("firstname");
             lastname = rs.getString("lastname");
             email = rs.getString("email");
             System.out.println(firstname+lastname+email);
             System.out.println(firstname+lastname+email);
      	     Assert.assertEquals(firstname, "Testing");
      	     Assert.assertEquals(lastname,"lastnametesting");
      	    Assert.assertEquals(email,dummymail);
	    }
	  
	    
	   
	
}
	}
