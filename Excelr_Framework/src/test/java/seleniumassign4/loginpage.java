package seleniumassign4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	
	public loginpage(WebDriver wb) {
		
		driver=wb;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (name="username") WebElement userNm;
	@FindBy (name="password") WebElement pass;
	@FindBy (xpath="//button[@type='submit']") WebElement loginBT;
	
	public void url() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}
	public void enterusername(String un) {
		userNm.sendKeys(un);
	}
	public void enterpassword(String pn) {
		pass.sendKeys(pn);
	}
	public void clickloginbtn() throws InterruptedException {
		loginBT.click();
		Thread.sleep(2000);
	}

}
