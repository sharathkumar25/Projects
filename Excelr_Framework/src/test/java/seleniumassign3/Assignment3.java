package seleniumassign3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Assignment3 {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(groups = {"Smoke"})
	public void test1() throws InterruptedException {
		driver.findElement(By.xpath("//div[@Class='category-cards']/child::div[2]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/div/ul/li/span")).click();
		Thread.sleep(3000);
	}
	@Test(groups = {"Regression"})
	public void test2() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys("virat");
		driver.findElement(By.id("lastName")).sendKeys("kholi");
		driver.findElement(By.id("userEmail")).sendKeys("viratkholi@gmail.com");
		driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
		driver.findElement(By.id("userNumber")).sendKeys("9876543210");
		driver.findElement(By.id("dateOfBirthInput")).click();
		
		WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
		Select s = new Select(month); 
		s.selectByVisibleText("December");
		
		WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
		Select y = new Select(year); 
		y.selectByValue("2000");
		
		driver.findElement(By.xpath("//div[@Class='react-datepicker__day react-datepicker__day--025']")).click();
		Thread.sleep(2000);
		
		WebElement sub = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		sub.sendKeys("English");
		sub.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[text()='Music']")).click();
		driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\pic.png");
		WebElement L = driver.findElement(By.id("currentAddress"));
		L.sendKeys("1-1-100,centeral plaza Uttar Pradesh.");
		
        //driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).click();
        WebElement u = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]"));
        u.click();
        WebElement stateOption = driver.findElement(By.xpath("//div[@id='state']//div[contains(text(),'NCR')]"));
        stateOption.click();
        WebElement cityDropdown = driver.findElement(By.id("city"));
        cityDropdown.click();
        WebElement cityOption = driver.findElement(By.xpath("//div[@id='city']//div[contains(text(),'Delhi')]"));
        cityOption.click();
        Thread.sleep(2000);
     
	}
	@Test (groups = {"Regression"})
    public void test3() throws IOException, InterruptedException {
    driver.findElement(By.xpath("//button[@id='submit']")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	File f = ((TakesScreenshot) js).getScreenshotAs(OutputType.FILE);
	Files.copy(f, new File("C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\validatingOutput.jpeg"));
	Thread.sleep(3000);
	driver.close();
	
	}
}
