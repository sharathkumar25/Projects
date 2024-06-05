package AutomationExercise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomepageFunctionalitys {
	WebDriver driver;
	public HomepageFunctionalitys(WebDriver wd) {
		driver=wd;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[8]/a")WebElement contactusBTN;
	@FindBy (xpath="//div[@class='contact-form']/child::h2")WebElement HValidate1;
	@FindBy (xpath="//form[@class='contact-form row']/child::div/input")WebElement CNameBTN;
	@FindBy (xpath="//form[@class='contact-form row']/child::div[2]/input")WebElement CEmailBTN;
	@FindBy (xpath="//form[@class='contact-form row']/child::div[3]/input")WebElement CSubjectBTN;
	@FindBy (xpath="//form[@class='contact-form row']/child::div[4]/textarea")WebElement CTextBTN;
	@FindBy (xpath="//form[@class='contact-form row']/child::div[5]/input")WebElement CChoseFileBTN;
	@FindBy (xpath="//form[@class='contact-form row']/child::div[6]/input")WebElement CSudmitBTN;
	@FindBy (xpath="//div[@class='contact-form']/div[2]")WebElement HValidate2;
	@FindBy (xpath="//div[@id='form-section']/a")WebElement HomeBTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[5]/a")WebElement TestcasesBTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[1]/a") WebElement HomepageBTN;
	@FindBy (xpath="//div[@Class='single-widget']/h2") WebElement Validate3;
	@FindBy (xpath="//div[@Class='single-widget']/child::form/child::input[2]")WebElement Enteremail;
	@FindBy (xpath="//div[@Class='single-widget']/child::form/child::button")WebElement emailBTN;
	@FindBy (xpath="//div[@Class='alert-success alert']")WebElement successvalidate;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[3]/a") WebElement CartpageBTN;
	@FindBy (xpath="//a[@id='scrollUp']/i") WebElement ScrollupBTN;
	@FindBy (xpath="//div[@Class='carousel-inner']/descendant::h2")WebElement Validate4;
	
	
	public void Verify_ContactUSFORM() throws InterruptedException {
		contactusBTN.click();
		String getintouch = HValidate1.getText();
		Assert.assertEquals(getintouch, "GET IN TOUCH");
		CNameBTN.sendKeys("Tom");
		CEmailBTN.sendKeys("Tomcruise01@gmail.com");
		CSubjectBTN.sendKeys("Test-Project - P45");
		CTextBTN.sendKeys("This email regards to test the Contact us functionality through regression testing");
		CChoseFileBTN.sendKeys("C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\1.png");
		CSudmitBTN.click();
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		//need to add alert code before running the test case
		String Successvalidate = HValidate2.getText();
		Assert.assertEquals(Successvalidate, "Success! Your details have been submitted successfully.");
		HomeBTN.click();
		Thread.sleep(2000);
		String act = driver.getTitle();
		Assert.assertEquals(act, "Automation Exercise");
		
	}
	public void Verify_TestcasesPage() {
		TestcasesBTN.click();
		String act = driver.getTitle();
		Assert.assertEquals(act, "Automation Practice Website for UI Testing - Test Cases");
		
	}
	public void VerifySubscriptionin_Homepage() {
		HomepageBTN.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		String VSubscription = Validate3.getText();
		System.out.println(VSubscription);
		Assert.assertEquals(VSubscription, "SUBSCRIPTION");
		Enteremail.sendKeys("xyz@gmail.com");
		emailBTN.click();
		String SuccessMessage = successvalidate.getText();
		Assert.assertEquals(SuccessMessage, "You have been successfully subscribed!");
		System.out.println(SuccessMessage);
		js.executeScript("window.scrollBy(0,100)");
	}
	public void VerifySubscriptionin_Cartpage() {
		CartpageBTN.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		String VSubscription = Validate3.getText();
		System.out.println(VSubscription);
		Assert.assertEquals(VSubscription, "SUBSCRIPTION");
		Enteremail.sendKeys("xyz@gmail.com");
		emailBTN.click();
		String SuccessMessage = successvalidate.getText();
		Assert.assertEquals(SuccessMessage, "You have been successfully subscribed!");
		System.out.println(SuccessMessage);
		js.executeScript("window.scrollBy(0,100)");
		HomepageBTN.click();
	}
	public void VerifyScrollUpusingArrowButton_andScrollDownfunctionality() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,9000)");
		String VSubscription = Validate3.getText();
		System.out.println(VSubscription);
		Assert.assertEquals(VSubscription, "SUBSCRIPTION");
		ScrollupBTN.click();
	}
	public void VerifyScrollUpwithoutArrow_buttonandScrollDownfunctionality() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,9000)");
		String VSubscription = Validate3.getText();
		System.out.println(VSubscription);
		Assert.assertEquals(VSubscription, "SUBSCRIPTION");
		js.executeScript("window.scrollBy(0,4000)");
		js.executeScript("window.scrollBy(0,200)");
		String fullfledgedpractice = Validate4.getText();
		Assert.assertEquals(fullfledgedpractice, "Full-Fledged practice website for Automation Engineers");
	}
		
}

