package seleniumassign4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminmodule {
	WebDriver driver;

	public Adminmodule(WebDriver cd) {
		driver = cd;
		PageFactory.initElements(driver, this);
	}
	
	//Repository
	@FindBy (xpath="//span[@Class='oxd-text oxd-text--span oxd-main-menu-item--name']") WebElement AdminBTN;
	@FindBy (xpath="//button[@Class='oxd-button oxd-button--medium oxd-button--secondary']") WebElement addBTN;
	
	
	public void clickloginadmin() {
		AdminBTN.click();
	}
	public void ClickonAddBTN() throws InterruptedException {
		Thread.sleep(2000);
		addBTN.click();
		Thread.sleep(2000);
	}

}
