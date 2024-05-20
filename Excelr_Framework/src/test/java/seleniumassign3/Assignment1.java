package seleniumassign3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment1 {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/login.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	@Test
	public void userdetails() {
		driver.findElement(By.name("email")).sendKeys("Xyz1@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Abc@2024");
		driver.findElement(By.name("SubmitLogin")).click();
	}
	@AfterSuite
	public void exitsetup() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
