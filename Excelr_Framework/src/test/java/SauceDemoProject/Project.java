package SauceDemoProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class Project {
	WebDriver driver;
	String Filepath="C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\SwagLabs.xlsx";
	FileInputStream ExcelFile;
	XSSFWorkbook workbook;
	
	@BeforeSuite
	public void GetURL() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Test(priority = 1)
	public void VerifyLoginpage() {
		String verifytitle= driver.getTitle();
		System.out.println(verifytitle);
		Assert.assertEquals(verifytitle, "Swag Labs");
	}
	@Test(priority = 2)
	public void loginwith_Invaliddetails() throws IOException, InterruptedException {
		//String Filepath="C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\SwagLabs.xlsx";
		//FileInputStream ExcelFile = new FileInputStream(Filepath);
		//XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
		ExcelFile = new FileInputStream(Filepath);
		workbook = new XSSFWorkbook(ExcelFile);
		XSSFSheet sheet = workbook.getSheet("Logindetails");
		XSSFRow row = sheet.getRow(1);
		XSSFCell username = row.getCell(0);
		XSSFCell password = row.getCell(1);
		System.out.println("InvalidUsername -    "+username+"    Invalidpassword -   "+password);
		driver.findElement(By.id("user-name")).sendKeys(username.toString());
		driver.findElement(By.id("password")).sendKeys(password.toString());
		driver.findElement(By.id("login-button")).click();
		WebElement validate = driver.findElement(By.xpath("//div[@class='login-box']/descendant::h3"));
		String validateinvalid = validate.getText();
		System.out.println(validateinvalid);
		Assert.assertEquals(validateinvalid, "Epic sadface: Username and password do not match any user in this service");
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("password")).clear();
		ExcelFile.close();
	}
	@Test (priority = 3)
	public void Loginwith_Validdetails() throws IOException, InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1500);
		ExcelFile = new FileInputStream(Filepath);
		workbook = new XSSFWorkbook(ExcelFile);
		XSSFSheet sheet = workbook.getSheet("Validetails");
		XSSFRow row = sheet.getRow(1);
		XSSFCell username = row.getCell(2);
		XSSFCell pass = row.getCell(3);
		System.out.println("validUsername -    "+username+"    validpassword -   "+pass);
		driver.findElement(By.id("user-name")).sendKeys(username.toString());
		driver.findElement(By.id("password")).sendKeys(pass.toString());
		driver.findElement(By.id("login-button")).click();
		ExcelFile.close();
	}
	@Test (priority = 4)
	public void VerifyHomepage() {
		String VerifyHomepage = driver.getTitle();
		System.out.println("Verify homepage-"+VerifyHomepage);
		Assert.assertEquals(VerifyHomepage, "Swag Labs");
		List<WebElement> productlinks = driver.findElements(By.xpath("//div[@class='inventory_list']"));
		System.out.println("Total number of links"+productlinks.size());
		for(int i=0;i<productlinks.size();i++) {
			WebElement currentlink = productlinks.get(i);
			String Vlinknamee = currentlink.getText();
			System.out.println(Vlinknamee);}
		}
	
	@Test (priority=5)
	public void verifyproductdetail() {
		WebElement Productpage = driver.findElement(By.xpath("//div[@class='header_secondary_container']/child::div[3]/div"));
		String validateproductpage = Productpage.getText();
		System.out.println(validateproductpage);
		Assert.assertEquals(validateproductpage, "Products");
		
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[1]/div[1]")).click();//1stproduct
		WebElement productname = driver.findElement(By.xpath("//div[@class='inventory_item_container']/descendant::div[3]/div"));
		String validateproductname = productname.getText();
		System.out.println(validateproductname);
		Assert.assertEquals(validateproductname, "Sauce Labs Backpack");
		
		WebElement productdiscripation = driver.findElement(By.xpath("//div[@class='inventory_item_container']/descendant::div[3]/div[2]"));
		String validateproductdiscripation = productdiscripation.getText();
		System.out.println(validateproductdiscripation);
		Assert.assertEquals(validateproductdiscripation, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
		
		WebElement productprice = driver.findElement(By.xpath("//div[@class='inventory_item_container']/descendant::div[3]/div[3]"));
		String validateproductprice = productprice.getText();
		System.out.println(validateproductprice);
		Assert.assertEquals(validateproductprice, "$29.99");
		driver.findElement(By.xpath("//div[@class='inventory_details']/button")).click();//backbutton)
}
	@Test(priority=6)
	public void AddtoCart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[1]/div[1]")).click();
		driver.findElement(By.xpath("//div[@class='inventory_details_desc_container']/child::button")).click();
		driver.findElement(By.xpath("//div[@class='header_container']/descendant::a")).click();
		driver.getCurrentUrl();
		
		WebElement Cartqty = driver.findElement(By.xpath("//div[@class='cart_list']/descendant::div[3]/div"));
		String validateCartqty = Cartqty.getText();
		System.out.println(validateCartqty);
		Assert.assertEquals(validateCartqty, "1");
		
		WebElement Cartproductname = driver.findElement(By.xpath("//div[@class='cart_list']/descendant::a/div"));
		String validateCartproductname = Cartproductname.getText();
		System.out.println(validateCartproductname);
		Assert.assertEquals(validateCartproductname, "Sauce Labs Backpack");
		driver.findElement(By.xpath("//div[@class='cart_footer']/a")).click();//continueshopping
	}
	@Test(priority=7)
	public void RemoveProduct_fromCart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")).click();//2ndproductaddtocartBTN
		driver.findElement(By.xpath("//div[@id='header_container']/child::div[2]/a")).click();//mainpageaddtocart
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='cart_list']/child::div[3]/descendant::div[5]/button")).click();//remove1stproduct
		driver.findElement(By.xpath("//div[@class='cart_list']/child::div[4]/descendant::div[5]/button")).click();//remove2ndproduct
		System.out.println("Removed products from the cart Succesfully");
		driver.findElement(By.xpath("//div[@class='cart_footer']/a")).click();//continueshopping	
	}
	@Test(priority=8)
	public void Addextraproducts_tocart() {
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[1]/child::div[3]/descendant::button")).click();
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[2]/child::div[3]/descendant::button")).click();
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[3]/child::div[3]/descendant::button")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[4]/child::div[3]/descendant::button")).click();
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[5]/child::div[3]/descendant::button")).click();
		driver.findElement(By.xpath("//div[@class='inventory_list']/child::div[6]/child::div[3]/descendant::button")).click();
	}
	@Test(priority=9)
	public void Checkout() {
		driver.findElement(By.xpath("//div[@id='header_container']/child::div[2]/a")).click();//mainpageaddtocart
		driver.findElement(By.xpath("//div[@class='cart_footer']/a[2]")).click();//checkout
		driver.findElement(By.xpath("//div[@class='checkout_info']/child::input")).sendKeys("Sharath");
		driver.findElement(By.xpath("//div[@class='checkout_info']/child::input[2]")).sendKeys("Kumar");
		driver.findElement(By.xpath("//div[@class='checkout_info']/child::input[3]")).sendKeys("500001");
		driver.findElement(By.xpath("//div[@class='checkout_buttons']/child::input")).click();
	}
	@Test(priority=10)
	public void Checkout_overview() {
		WebElement checkoutoverview = driver.findElement(By.xpath("//div[@id='contents_wrapper']/child::div[2]"));
		String validatecheckoutoverview = checkoutoverview.getText();
		System.out.println(validatecheckoutoverview);
		Assert.assertEquals(validatecheckoutoverview, "Checkout: Overview");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		WebElement paymentinformation = driver.findElement(By.xpath("//div[@class='summary_info']/child::div[2]"));
		String validatepaymentinformation = paymentinformation.getText();
		System.out.println(validatepaymentinformation);
		Assert.assertEquals(validatepaymentinformation, "SauceCard #31337");
		
		WebElement shippinginfo = driver.findElement(By.xpath("//div[@class='summary_info']/child::div[4]"));
		String validateshippinginfo = shippinginfo.getText();
		System.out.println(validateshippinginfo);
		Assert.assertEquals(validateshippinginfo, "FREE PONY EXPRESS DELIVERY!");
		
		WebElement itemtotal = driver.findElement(By.xpath("//div[@class='summary_info']/child::div[5]"));
		String validateitemtotal = itemtotal.getText();
		System.out.println(validateitemtotal);
		Assert.assertEquals(validateitemtotal, "Item total: $129.94");
		
		WebElement Tax = driver.findElement(By.xpath("//div[@class='summary_info']/child::div[6]"));
		String validateTax = Tax.getText();
		System.out.println(validateTax);
		Assert.assertEquals(validateTax, "Tax: $10.40");
		
		WebElement TotalAmount = driver.findElement(By.xpath("//div[@class='summary_info']/child::div[7]"));
		String validateTotalAmount = TotalAmount.getText();
		System.out.println(validateTotalAmount);
		Assert.assertEquals(validateTotalAmount, "Total: $140.34");
		
		driver.findElement(By.xpath("//div[@class='summary_info']/child::div[8]/a[2]")).click();
	}
	@Test(priority=11)
	public void Orderconfirmation() {
		WebElement ordercompletetiontitle = driver.findElement(By.xpath("//div[@id='contents_wrapper']/child::div[2]"));
		String validateordercompletetiontitle = ordercompletetiontitle.getText();
		System.out.println("order title page - "+validateordercompletetiontitle);
		Assert.assertEquals(validateordercompletetiontitle, "Finish");
		
		WebElement orderconfirmation = driver.findElement(By.xpath("//div[@id='contents_wrapper']/child::div[3]/h2"));
		String validateorderconfirmation = orderconfirmation.getText();
		System.out.println(validateorderconfirmation);
		Assert.assertEquals(validateorderconfirmation, "THANK YOU FOR YOUR ORDER");
		
		WebElement orderinfo = driver.findElement(By.xpath("//div[@id='contents_wrapper']/child::div[3]/child::div"));
		String validateorderinfo = orderinfo.getText();
		System.out.println(validateorderinfo);
		Assert.assertEquals(validateorderinfo, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
		
	}
	@Test(priority=12)
	public void SidemenuBarmenu() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='bm-burger-button']/child::button")).click();//sidemenubar
		driver.findElement(By.xpath("//nav[@class='bm-item-list']/a")).click();//AllitemsBTN
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='bm-burger-button']/child::button")).click();//sidemenubar
		driver.findElement(By.xpath("//nav[@class='bm-item-list']/a[2]")).click();//AboutBTN
		String Aboutpagetitle = driver.getTitle();
		System.out.println(Aboutpagetitle);
		Assert.assertEquals(Aboutpagetitle, "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
		Thread.sleep(5000);
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='bm-cross-button']/child::button")).click();
	}
	@Test(priority=13)
	public void FilterOpitons() throws InterruptedException {
		WebElement filter = driver.findElement(By.xpath("//div[@class='header_secondary_container']/child::div[3]/child::select"));
		Select filtercheck = new Select(filter);
		filtercheck.selectByIndex(1);
		Thread.sleep(3000);
		filtercheck.selectByIndex(2);
		Thread.sleep(3000);
		filtercheck.selectByIndex(3);
	}
	@Test(priority=14)
	public void FooterSepcifications() {
		WebElement verifyfooter = driver.findElement(By.xpath("//footer[@class='footer']/child::div"));
		String validatefooter = verifyfooter.getText();
		System.out.println(validatefooter);
		Assert.assertEquals(validatefooter, "© 2020 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
	}
	@Test(priority=15)
	public void ScrollUpandDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,100)");
	}
	
	@Test(priority=16)
	public void Logout() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='bm-burger-button']/child::button")).click();//sidemenubar
		driver.findElement(By.xpath("//nav[@class='bm-item-list']/a[3]")).click();//logout
		Thread.sleep(5000);
		driver.close();
	}
	
}

