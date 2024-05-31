package projectexmaplepackages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class automationexcerice {
	
	WebDriver driver;
	@BeforeSuite
	public void getURL() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		Thread.sleep(2000);
	}
	@Test (priority = 1)
	public void login() throws InterruptedException {
		String act = driver.getTitle();
		String exp = "Automation Exercise";
		if (act.equals(exp))
		System.out.println("title is matched");
		else 
		System.out.println("title is not matched");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@Class='nav navbar-nav']/child::li[4]/a")).click();
		WebElement e = driver.findElement(By.xpath("//div[@class='signup-form']"));
		if(e.isDisplayed()) {
			System.out.println("New User Signup! is displayyed");
		}
		else {
			System.out.println("not displyed");
		}
		driver.findElement(By.name("name")).sendKeys("tommy");
		driver.findElement(By.xpath("//div[@class='signup-form']/child::form/child::input[3]")).sendKeys("tommy&jonny@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='signup-form']/child::form/child::button")).click();
		Thread.sleep(2000);
		WebElement d = driver.findElement(By.xpath("//div[@class='login-form']"));
		if(d.isDisplayed()) {
			System.out.println("enter the details");
		}
		else
			System.out.println("not displayed");
	}
	

}
