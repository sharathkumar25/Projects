package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountFunctionality {
WebDriver driver;
	
	public accountFunctionality(WebDriver wb) {
		
		driver=wb;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath="//a[@Class='logo']" ) WebElement nlogo;
	@FindBy (xpath="//span[@class='customer-name']//child::button" ) WebElement accountBTN;
	@FindBy (xpath="//div[@class='customer-menu']//child::ul//child::li[1]") WebElement myaccountBTN;
	@FindBy (xpath="//div[@class='content block-collapsible-nav-content']/child::ul/child::li[2]/child::a") WebElement myordersBTN;
	@FindBy (xpath="//div[@class='content block-collapsible-nav-content']/child::ul/child::li[3]") WebElement mydownloadableBTN;
	@FindBy (xpath="//div[@class='content block-collapsible-nav-content']/child::ul/child::li[4]/child::a") WebElement wishltBTN;
	@FindBy (xpath="//div[@class='content block-collapsible-nav-content']/child::ul/child::li[6]/child::a") WebElement myaddresssBTN;
	@FindBy (xpath="//div[@class='content block-collapsible-nav-content']/child::ul/child::li[7]/child::a") WebElement accountinfoBTN;
	@FindBy (id="firstname" ) WebElement Fname;
	@FindBy (id="lastname" ) WebElement lname;
	@FindBy (xpath="//*[@id=\"form-validate\"]/div/div[1]/button") WebElement namechangeBTN;
	
	
	public void Myaccount_Functionality() throws InterruptedException {
		nlogo.click();
		accountBTN.click();
		Thread.sleep(2000);
		myaccountBTN.click();//account
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("window.scrollBy(0,200)");
		myordersBTN.click();
		Thread.sleep(1500);
		mydownloadableBTN.click();
		Thread.sleep(1500);
		wishltBTN.click();
		Thread.sleep(1500);
		myaddresssBTN.click();
		Thread.sleep(1500);
		accountinfoBTN.click();
		Thread.sleep(1500);
	}
	public void Change_Accoutname() throws InterruptedException {
		Fname.clear();
		Fname.sendKeys("Good");
		lname.clear();
		lname.sendKeys("Boy");
		namechangeBTN.click();
		Thread.sleep(3000);
		nlogo.click();
	}

}
