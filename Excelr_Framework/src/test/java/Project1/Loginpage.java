package Project1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
WebDriver driver;
	
	public Loginpage(WebDriver wb) {
		
		driver=wb;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (linkText ="Sign In") WebElement SigninBTN;
	@FindBy (id="email") WebElement Iemail;
	@FindBy (id="pass") WebElement Ipass;
	@FindBy (xpath="//button[@id='send2']") WebElement IloginBT;
	@FindBy (id="email") WebElement email;
	@FindBy (id="pass") WebElement pass;
	@FindBy (xpath="//button[@id='send2']") WebElement loginBT;
	
	public void url() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);
		SigninBTN.click();
	}
	public void enter_invalid_details() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Iemail.sendKeys("tom&jerry@gmail.com");
		Ipass.sendKeys("Cartoon@1");
		IloginBT.click();
	}
	public void Enter_valid_details() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		email.clear();
		email.sendKeys("badboy@gmail.com");
		pass.sendKeys("Project@1");
		loginBT.click();
		Thread.sleep(2000);
	}
}
