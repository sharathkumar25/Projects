package AutomationExercise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CartFunctionality {
	WebDriver driver;
	public CartFunctionality(WebDriver wd) {
		driver=wd;
		PageFactory.initElements(driver, this);
		}
		
	//Repository
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[3]/a") WebElement CartpageBTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[2]/a")WebElement ProductBTN;
	@FindBy (xpath="//div[@class='features_items']/child::div[2]/child::div/div[1]/div/img")WebElement Hoverforcart;
	@FindBy (xpath="//div[@class='features_items']/child::div[2]/child::div/div[1]/div/a")WebElement Hoveraddtocart;
	@FindBy (xpath="//button[@class='btn btn-success close-modal btn-block']")WebElement ContShoppingBTN;
	@FindBy (xpath="//div[@class='features_items']/child::div[3]/child::div/div[1]/div/img")WebElement Hoverforcart2;
	@FindBy (xpath="//div[@class='features_items']/child::div[3]/child::div/div[1]/div/a")WebElement Hoveraddtocart2;
	@FindBy (xpath="//div[@class='modal-body']/child::p[2]/a")WebElement Hcartview;
	@FindBy (xpath="//td[@Class='cart_price']/p")WebElement price1;
	@FindBy (xpath="//td[@Class='cart_quantity']/button")WebElement qty1;
	@FindBy (xpath="//td[@Class='cart_total']/p")WebElement Tprice1;
	@FindBy (xpath="//tr[@id='product-2']/child::td[3]/p")WebElement price2;
	@FindBy (xpath="//tr[@id='product-2']/child::td[4]/button")WebElement qty2;
	@FindBy (xpath="//tr[@id='product-2']/child::td[5]/p")WebElement Tprice2;
	@FindBy (xpath="//div[@class='features_items']/child::div[2]/child::div/child::div[2]/ul/li/a")WebElement FirstproductBTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[1]/a") WebElement HomepageBTN;
	@FindBy (xpath="//div[@Class='product-information']/child::span/input")WebElement IncreaseQty;
	@FindBy (xpath="//div[@Class='product-information']/child::span/button/i")WebElement Addtocart;//inside product detaild page
	@FindBy (xpath="//td[@Class='cart_delete']/child::a/i")WebElement RemoveBTN;
	@FindBy (xpath="//p[@class='text-center']/b")WebElement Validate1;
	@FindBy (xpath="//div[@class='features_items']/child::div[2]/child::div/div[1]/div/a/i")WebElement HomapageFirstproduct;
	@FindBy (xpath="//div[@Class='modal-body']/p")WebElement Validate2;
	@FindBy (xpath="//section[@id='do_action']/descendant::div[3]/a")WebElement ProcessedtoCheckoutBTN;
	@FindBy (xpath="//div[@Class='modal-content']/descendant::p[2]/a")WebElement RegisterLoginBTN;
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
	@FindBy (xpath="//div[@id='ordermsg']/child::textarea[@class='form-control']")WebElement Messageorder;
	@FindBy (xpath="//*[@id=\"cart_items\"]/div/div[7]/a")WebElement PlaceorderBTN;
	@FindBy (xpath="//div[@Class='col-md-4']/child::form/child::div/child::div/input")WebElement Nameoncard;
	@FindBy (xpath="//div[@Class='col-md-4']/child::form/child::div[2]/child::div/input")WebElement CardNo;
	@FindBy (xpath="//div[@Class='col-md-4']/child::form/child::div[3]/child::div[1]/input")WebElement CVVBTN;
	@FindBy (xpath="//div[@Class='col-md-4']/child::form/child::div[3]/child::div[2]/input")WebElement Month;
	@FindBy (xpath="//div[@Class='col-md-4']/child::form/child::div[3]/child::div[3]/input")WebElement Year;
	@FindBy (xpath="//div[@Class='col-md-4']/child::form/child::div[5]/child::div/button")WebElement paynconfirm;
	@FindBy (xpath="//div[@Class='col-md-4']/child::form/child::div[4]/child::div/div")WebElement validate2;
	@FindBy (xpath="//div[@Class='col-sm-9 col-sm-offset-1']/child::a")WebElement invoiceBTN;
	@FindBy (xpath="//div[@Class='col-sm-9 col-sm-offset-1']/child::div/a")WebElement Downloadcontinue;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[5]/child::a")WebElement DeleteBTN;
	@FindBy (xpath="//a[@class='btn btn-primary']") WebElement Continue1BTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[4]/a") WebElement Signup_loginBTN;
	@FindBy (xpath="//div[@class='pull-right']/a")WebElement orderplacedpageContinueBTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[4]/a") WebElement LogoutBTN;
	@FindBy (xpath="//form[@action='/login']/child::input[2]") WebElement Loginemail;
	@FindBy (xpath="//form[@action='/login']/child::input[3]") WebElement Loginpassword;
	@FindBy (xpath="//form[@action='/login']/child::button") WebElement LoginBTN;
	@FindBy (id="search_product")WebElement Searchengine;
	@FindBy (xpath="//div[@Class='container']/child::button/i")WebElement SearchBTN;
	@FindBy (xpath="//div[@class='features_items']/child::div[2]/descendant::a/i")WebElement Addtocartfromsearchengine;
	@FindBy (xpath="//td[@Class='cart_description']/child::h4/a")WebElement Validate4;
	@FindBy (xpath="//div[@id='recommended-item-carousel']/child::div/child::div[2]/descendant::a/i")WebElement Recommendeditemsaddcart;
	@FindBy (xpath="//tr[@id='product-4']/child::td[2]/child::h4/a")WebElement Validate5;
	@FindBy (xpath="//ul[@id='address_delivery']/li[2]")WebElement Validate6;
	@FindBy (xpath="//ul[@id='address_delivery']/li[3]")WebElement Validate7;
	@FindBy (xpath="//ul[@id='address_delivery']/li[4]")WebElement Validate8;
	@FindBy (xpath="//ul[@id='address_delivery']/li[5]")WebElement Validate9;
	@FindBy (xpath="//ul[@id='address_delivery']/li[6]")WebElement Validate10;
	@FindBy (xpath="//ul[@id='address_delivery']/li[7]")WebElement Validate11;
	@FindBy (xpath="//ul[@id='address_delivery']/li[8]")WebElement Validate12;
	@FindBy (xpath="//ul[@Class='address alternate_item box']/child::li[2]")WebElement Validate13;
	@FindBy (xpath="//ul[@Class='address alternate_item box']/child::li[3]")WebElement Validate14;
	@FindBy (xpath="//ul[@Class='address alternate_item box']/child::li[4]")WebElement Validate15;
	@FindBy (xpath="//ul[@Class='address alternate_item box']/child::li[5]")WebElement Validate16;
	@FindBy (xpath="//ul[@Class='address alternate_item box']/child::li[6]")WebElement Validate17;
	@FindBy (xpath="//ul[@Class='address alternate_item box']/child::li[7]")WebElement Validate18;
	@FindBy (xpath="//ul[@Class='address alternate_item box']/child::li[8]")WebElement Validate19;
	

	
	
   public void AddProductin_Cart() throws InterruptedException {
	   ProductBTN.click();
	   Actions act = new Actions(driver);
	   act.moveToElement(Hoverforcart).build().perform();
	   Thread.sleep(1000);
	   Hoveraddtocart.click();
	   ContShoppingBTN.click();
	   act.moveToElement(Hoverforcart2).build().perform();
	   Hoveraddtocart2.click();
	   Hcartview.click();
	   String price = price1.getText();
	   Assert.assertEquals(price, "Rs. 500");
	   String qty = qty1.getText();
	   Assert.assertEquals(qty, "1");
	   String TotalPrice = Tprice1.getText();
	   Assert.assertEquals(TotalPrice, "Rs. 500");
	   String pricee = price2.getText();
	   Assert.assertEquals(pricee, "Rs. 400");
	   String qtyy = qty2.getText();
	   Assert.assertEquals(qtyy, "1");
	   String TotalPricee = Tprice2.getText();
	   Assert.assertEquals(TotalPricee, "Rs. 400");   
 }
   public void VerifyProductQuantity_inCart() {
	   HomepageBTN.click();
	   FirstproductBTN.click();
	   IncreaseQty.clear();
	   IncreaseQty.sendKeys("4");
	   Addtocart.click();
	   Hcartview.click();
	   String qty = qty1.getText();
	   Assert.assertEquals(qty, "4");
   }
   public void RemoveProducts_FromCart() {
	  String CartPage = driver.getTitle();
	  Assert.assertEquals(CartPage, "Automation Exercise - Checkout");
	  RemoveBTN.click();
	  String emptycart=Validate1.getText();
	  Assert.assertEquals(emptycart, "Cart is empty!");
	  HomepageBTN.click();
   }
   public void PlaceOrder_RegisterwhileCheckout() throws InterruptedException {
	   HomapageFirstproduct.click();
	   String Addedtocart = Validate2.getText();
	   Assert.assertEquals(Addedtocart, "Your product has been added to cart.");
	   Hcartview.click();
	   ProcessedtoCheckoutBTN.click();
	   RegisterLoginBTN.click();
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
		CartpageBTN.click();
		ProcessedtoCheckoutBTN.click();	
		Thread.sleep(2000);
		Messageorder.sendKeys("Please send as soon as possible");
		PlaceorderBTN.click();
		Nameoncard.sendKeys("Jerry");
		CardNo.sendKeys("4532 5632 7436");
		CVVBTN.sendKeys("233");
		Month.sendKeys("11");
		Year.sendKeys("2030");
		paynconfirm.click();
		String orderplacesmessage = validate2.getText();
		Assert.assertEquals(orderplacesmessage, "Your order has been placed successfully!");
   }
   public void DownloadInvoice_afterPurchase() {
	   invoiceBTN.click();
	   Downloadcontinue.click();
	   DeleteBTN.click();
	   Continue1BTN.click();
	   HomepageBTN.click();
   }
   public void PlaceOrder_RegisterbeforeCheckout() throws InterruptedException {
	   Signup_loginBTN.click();
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
		HomapageFirstproduct.click();
		Hcartview.click();
		String CartPage = driver.getTitle();
		Assert.assertEquals(CartPage, "Automation Exercise - Checkout");
		ProcessedtoCheckoutBTN.click();
		Messageorder.sendKeys("Please send as soon as possible");
		PlaceorderBTN.click();
		Nameoncard.sendKeys("Jerry");
		CardNo.sendKeys("4532 5632 7436");
		CVVBTN.sendKeys("233");
		Month.sendKeys("11");
		Year.sendKeys("2030");
		paynconfirm.click();
		String orderplacesmessage = validate2.getText();
		Assert.assertEquals(orderplacesmessage, "Your order has been placed successfully!");
		orderplacedpageContinueBTN.click();
		LogoutBTN.click();
		HomepageBTN.click();
   }
   public void Placeorder_LoginbeforeCheckout() {
	   Signup_loginBTN.click(); 
	   Loginemail.sendKeys("Tomcruise01@gmail.com");
		Loginpassword.sendKeys("Tom@0001");
		LoginBTN.click();
		String VName = verifyname.getText();
		Assert.assertEquals(VName, "Logged in as Tom");
		HomapageFirstproduct.click();
		Hcartview.click();
		String CartPage = driver.getTitle();
		Assert.assertEquals(CartPage, "Automation Exercise - Checkout");
		ProcessedtoCheckoutBTN.click();
		Messageorder.sendKeys("Please send as soon as possible");
		PlaceorderBTN.click();
		Nameoncard.sendKeys("Jerry");
		CardNo.sendKeys("4532 5632 7436");
		CVVBTN.sendKeys("233");
		Month.sendKeys("11");
		Year.sendKeys("2030");
		paynconfirm.click();
		String orderplacesmessage = validate2.getText();
		Assert.assertEquals(orderplacesmessage, "Your order has been placed successfully!");
		orderplacedpageContinueBTN.click();
		LogoutBTN.click();
		HomepageBTN.click();
   }
   public void SearchProductsand_VerifyCartAfterLogin() {
	   ProductBTN.click(); 
	   Searchengine.sendKeys("Men Tshirt");
		SearchBTN.click();
		Addtocartfromsearchengine.click();
		Hcartview.click();
		String verifythesearch=Validate4.getText();
		System.out.println(verifythesearch);
		Assert.assertEquals(verifythesearch, "Men Tshirt");
		Signup_loginBTN.click(); 
		Loginemail.sendKeys("Tomcruise01@gmail.com");
		Loginpassword.sendKeys("Tom@0001");
		LoginBTN.click();
		CartpageBTN.click();
		String Afterloginverifythesearch=Validate4.getText();
		System.out.println(Afterloginverifythesearch);
		Assert.assertEquals(Afterloginverifythesearch, "Men Tshirt");
		
   }
   public void Addtocart_fromRecommendeditems() throws InterruptedException {
	   HomepageBTN.click();
	   JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,9000)");
		Thread.sleep(3000);
		Recommendeditemsaddcart.click();
		Hcartview.click();
		String Addtocartofrecmmendded=Validate5.getText();
		System.out.println(Addtocartofrecmmendded);
		Assert.assertEquals(Addtocartofrecmmendded, "Stylish Dress");
		LogoutBTN.click();
		HomepageBTN.click();
   }
   public void Verifyaddressdetails_incheckoutpage() throws InterruptedException {
	   Signup_loginBTN.click();
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
		HomapageFirstproduct.click();
		Hcartview.click();
		String CartPage = driver.getTitle();
		Assert.assertEquals(CartPage, "Automation Exercise - Checkout");
		ProcessedtoCheckoutBTN.click();
		System.out.println("YOUR DELIVERY ADDRESS");
		String addressname=Validate6.getText();
		System.out.println(addressname);
		Assert.assertEquals(addressname, "Mr. Tomm Curise");
		String addresscompany=Validate7.getText();
		System.out.println(addresscompany);
		Assert.assertEquals(addresscompany, "TomboyscompanyLtd");
		String addressNo=Validate8.getText();
		System.out.println(addressNo);
		Assert.assertEquals(addressNo, "1-2-190");
		String addresscity=Validate9.getText();
		System.out.println(addresscity);
		Assert.assertEquals(addresscity, "hyerabad");
		String addressstate=Validate10.getText();
		System.out.println(addressstate);
		Assert.assertEquals(addressstate, "Hyderabad Telangana 500034");
		String addresscountry=Validate11.getText();
		System.out.println(addresscountry);
		Assert.assertEquals(addresscountry, "India");
		String addressphone=Validate12.getText();
		System.out.println(addressphone);
		Assert.assertEquals(addressphone, "987456321");
		System.out.println("YOUR Billing ADDRESS");
		String Baddressname=Validate13.getText();
		System.out.println(Baddressname);
		Assert.assertEquals(Baddressname, "Mr. Tomm Curise");
		String Baddresscompany=Validate14.getText();
		System.out.println(Baddresscompany);
		Assert.assertEquals(Baddresscompany, "TomboyscompanyLtd");
		String BaddressNo=Validate15.getText();
		System.out.println(BaddressNo);
		Assert.assertEquals(BaddressNo, "1-2-190");
		String Baddresscity=Validate16.getText();
		System.out.println(Baddresscity);
		Assert.assertEquals(Baddresscity, "hyerabad");
		String Baddressstate=Validate17.getText();
		System.out.println(Baddressstate);
		Assert.assertEquals(Baddressstate, "Hyderabad Telangana 500034");
		String Baddresscountry=Validate18.getText();
		System.out.println(Baddresscountry);
		Assert.assertEquals(Baddresscountry, "India");
		String Baddressphone=Validate19.getText();
		System.out.println(Baddressphone);
		Assert.assertEquals(Baddressphone, "987456321");
		DeleteBTN.click();
		Continue1BTN.click();
		HomepageBTN.click();
		
		
   }

}
