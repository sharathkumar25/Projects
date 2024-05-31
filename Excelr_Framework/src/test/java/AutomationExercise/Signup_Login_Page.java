package AutomationExercise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Signup_Login_Page{
	WebDriver driver;
	
	public Signup_Login_Page(WebDriver wd) {
		
		driver=wd;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[4]/a") WebElement Signup_loginBTN;
	@FindBy (xpath="//div[@class='signup-form']/child::h2") WebElement Visible_Signup;
	@FindBy (name="name")WebElement Signupname;
	@FindBy (xpath="//div[@class='signup-form']/child::form/child::input[3]") WebElement Signupemail;
	@FindBy (xpath="//div[@class='signup-form']/child::form/child::button") WebElement SignupBTN;
	@FindBy (xpath="//div[@class='login-form']/child::h2") WebElement Visible2;
	@FindBy (id="id_gender1")WebElement mrBTN;
	@FindBy (id="password")WebElement PassBTN;
	@FindBy (id="days") WebElement DayBTN;
	@FindBy (id="months") WebElement monthBTN;
	@FindBy (id="years") WebElement yearBTN;
	@FindBy (xpath="//div[@class='checkbox']/descendant::span/child::input") WebElement Signupcheckbox;
	@FindBy (xpath="//input[@id='optin']") WebElement Specialoffercheckbox;
	@FindBy (id="first_name") WebElement FirstnameBTN;
	@FindBy (id="last_name") WebElement LastnameBTN;
	@FindBy (id="company") WebElement CompanyBTN;
	@FindBy (id="address1") WebElement Address1BTN;
	@FindBy (id="address2") WebElement Address2BTN;
	@FindBy (id="country") WebElement CountryBTN;
	@FindBy (id="state") WebElement StateBTN;
	@FindBy (id="city") WebElement CityBTN;
	@FindBy (id="zipcode") WebElement ZipcodeBTN;
	@FindBy (id="mobile_number") WebElement NumberBTN;
	@FindBy (xpath="//button[@class='btn btn-default']") WebElement createaccountBTN;
	@FindBy (xpath="//h2[@class='title text-center']") WebElement Validate3;
	@FindBy (xpath="//a[@class='btn btn-primary']") WebElement ContinueBTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[10]") WebElement verifyname;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[4]/a") WebElement LogoutBTN;
	@FindBy (xpath="//div[@class='signup-form']/child::form/child::p") WebElement Validate4;
	@FindBy (xpath="//div[@class='login-form']/child::h2") WebElement Validate5;
	@FindBy (xpath="//form[@action='/login']/child::input[2]") WebElement Loginemail;
	@FindBy (xpath="//form[@action='/login']/child::input[3]") WebElement Loginpassword;
	@FindBy (xpath="//form[@action='/login']/child::button") WebElement LoginBTN;
	@FindBy (xpath="//form[@action='/login']/child::p") WebElement Validate6;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[5]/child::a")WebElement DeleteBTN;
	@FindBy (xpath="//h2[@class='title text-center']") WebElement Validate7;
	@FindBy (xpath="//a[@class='btn btn-primary']") WebElement Continue1BTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[1]/a") WebElement HomepageBTN;
	
	
	
	public void GET_URL() {
		driver.get("https://automationexercise.com/");	
	}
	public void Registeruser() throws InterruptedException {
		String act = driver.getTitle();
		Assert.assertEquals(act, "Automation Exercise");
		Signup_loginBTN.click();
		String text = Visible_Signup.getText();
		Assert.assertEquals(text, "New User Signup!");
		Signupname.sendKeys("Tom");
		Signupemail.sendKeys("Tomcruise01@gmail.com");
		SignupBTN.click();
		Thread.sleep(2000);
		String text1 = Visible2.getText();
		Assert.assertEquals(text1, "ENTER ACCOUNT INFORMATION");
		mrBTN.click();
		PassBTN.sendKeys("Tom@0001");
		Select sday = new Select(DayBTN);
		sday.selectByIndex(24);
		Select smonth = new Select(monthBTN);
		smonth.selectByIndex(10);
		Select syear = new Select(yearBTN);
		syear.selectByVisibleText("2000");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Signupcheckbox.click();
		Specialoffercheckbox.click();
		FirstnameBTN.sendKeys("Tomm");
		LastnameBTN.sendKeys("Curise");
		CompanyBTN.sendKeys("TomboyscompanyLtd");
		Address1BTN.sendKeys("1-1-100");
		Address2BTN.sendKeys("Hitex city");
		Select scountry = new Select(CountryBTN);
		scountry.selectByVisibleText("India");
		StateBTN.sendKeys("Telangana");
		CityBTN.sendKeys("Hyderabad");
		ZipcodeBTN.sendKeys("500084");
		NumberBTN.sendKeys("9876543210");
		createaccountBTN.click();
		Thread.sleep(1000);
		String Accountcreated = Validate3.getText();
		Assert.assertEquals(Accountcreated, "ACCOUNT CREATED!");
		ContinueBTN.click();
		String VName = verifyname.getText();
		Assert.assertEquals(VName, "Logged in as Tom");
		
	}
	public void VerifyLogout() {
		LogoutBTN.click();
		HomepageBTN.click();
		String act = driver.getTitle();
		Assert.assertEquals(act, "Automation Exercise");
		System.out.println("Navigated Main Page Successfully");
	}
	public void VerifyRegister_withExisting_Email() {
		Signup_loginBTN.click();
		String text = Visible_Signup.getText();
		Assert.assertEquals(text, "New User Signup!");
		Signupname.sendKeys("Tom");
		Signupemail.sendKeys("Tomcruise01@gmail.com");
		SignupBTN.click();
		String Emailexits= Validate4.getText();
		Assert.assertEquals(Emailexits, "Email Address already exist!");
	}
	public void VerifyLogin_withInvaliddetails() {
		String Validatelogin = Validate5.getText();
		Assert.assertEquals(Validatelogin, "Login to your account");
		Loginemail.sendKeys("Tommmmmmmm1@gmail.com");
		Loginpassword.sendKeys("Tommm@1234");
		LoginBTN.click();
		String Incorrectdetails= Validate6.getText();
		Assert.assertEquals(Incorrectdetails, "Your email or password is incorrect!");
		Signup_loginBTN.click();
	}
	public void VerifyLogin_withValiddetails() throws InterruptedException {
		Loginemail.sendKeys("Tomcruise01@gmail.com");
		Loginpassword.sendKeys("Tom@0001");
		LoginBTN.click();
		String VName = verifyname.getText();
		Assert.assertEquals(VName, "Logged in as Tom");
		DeleteBTN.click();
		Thread.sleep(2000);
		String Deleted = Validate7.getText();
		Assert.assertEquals(Deleted, "ACCOUNT DELETED!");
		Continue1BTN.click();
		
		
	}
	

}
