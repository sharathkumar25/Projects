package day01_12032024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class orangehrmforTestNG {
	WebDriver driver;
	
	@BeforeSuite
	public void findpage() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}
	@Test (priority = 2)
	public void verifypage(){
		String name = driver.findElement(By.xpath("//h6[@Class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		if(name.equals("Dashboard")){
			System.out.println("Titile is matched");
		}
		else {
			System.out.println("Title is not matched");
		}	
	}
	@Test (priority = 3)
	public void logout() {
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterSuite
	public void applicationclose() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
