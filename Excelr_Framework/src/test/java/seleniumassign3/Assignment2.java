package seleniumassign3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment2 {

WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/login.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	@DataProvider (name = "Datasets")
	public Object[][]userdatails(){
		Object[][] details = new Object[1][2];
		details [0][0] = "Xyz1@gmail.com";
		details [0][1] = "Abc@2024";
		return details;
	}
	@Test (dataProvider ="Datasets")
	public void userdetails(String email, String password) {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();
	}
	@AfterSuite
	public void exitsetup() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
