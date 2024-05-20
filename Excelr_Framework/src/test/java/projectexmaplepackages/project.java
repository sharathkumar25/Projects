package projectexmaplepackages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class project {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Registration - 1
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Bad");
		driver.findElement(By.name("lastname")).sendKeys("Boy");
		driver.findElement(By.name("email")).sendKeys("Badd@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Project@1");
		driver.findElement(By.name("password_confirmation")).sendKeys("Project@1");
		driver.findElement(By.xpath("//button[@Class='action submit primary']")).click();
		String  W = driver.getTitle();
		System.out.println(W);
		String q = driver.getCurrentUrl();
		System.out.println(q);
		Thread.sleep(2000);
		driver.close();
		
	}

}
