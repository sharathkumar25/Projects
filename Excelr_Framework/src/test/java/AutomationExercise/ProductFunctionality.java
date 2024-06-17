package AutomationExercise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductFunctionality {
	WebDriver driver;
	
	public ProductFunctionality(WebDriver wd) {
		driver = wd;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[1]/a") WebElement HomepageBTN;
	@FindBy (xpath="//ul[@Class='nav navbar-nav']/child::li[2]/a")WebElement ProductBTN;
	@FindBy (xpath="//div[@Class='col-sm-9 padding-right']/child::div/child::h2")WebElement Validate1;
	@FindBy (xpath="//div[@class='features_items']/child::div[2]/child::div/child::div[2]/ul/li/a"
			+ "")WebElement FirstproductBTN;
	@FindBy (xpath="//div[@Class='product-information']/child::h2")WebElement Validate2;
	@FindBy (xpath="//div[@Class='product-information']/child::p")WebElement Validate4;
	@FindBy (xpath="//div[@Class='product-information']/child::span/span")WebElement Validate5;
	@FindBy (xpath="//div[@Class='product-information']/child::p[2]")WebElement Validate6;
	@FindBy (xpath="//div[@Class='product-information']/child::p[3]")WebElement Validate7;
	@FindBy (xpath="//div[@Class='product-information']/child::p[4]")WebElement Validate8;
	@FindBy (id="search_product")WebElement Validate3;
	@FindBy (xpath="//div[@Class='left-sidebar']/descendant::h4/a")WebElement CatorgryWomenBTN;
	@FindBy (xpath="//div[@Class='left-sidebar']/descendant::div[4]/child::div/child::ul/li/a")WebElement DressBTN;
	@FindBy (xpath="//div[@Class='left-sidebar']/descendant::div[7]/h4/a")WebElement CatorgrymenBTN;
	@FindBy (xpath="//div[@id='Men']/child::div/child::ul/li/a")WebElement TshirtBTN;
	@FindBy (xpath="//div[@Class='left-sidebar']/child::div[3]/h2")WebElement Validate9;
	@FindBy (xpath="//div[@Class='left-sidebar']/child::div[3]/child::div/descendant::li[2]/a")WebElement HMBTN;
	@FindBy (xpath="//div[@Class='left-sidebar']/child::div[3]/child::div/descendant::li[1]/a")WebElement POLOBTN;
	@FindBy (xpath="//div[@Class='features_items']/child::div[5]/descendant::li/a")WebElement PoloViewProductBTN;
	@FindBy (xpath="//div[@Class='category-tab shop-details-tab']/descendant::li/a")WebElement Validate10;
	@FindBy (xpath="//form[@id='review-form']/child::span/input[1]")WebElement Reviewname;
	@FindBy (xpath="//form[@id='review-form']/child::span/input[1]")WebElement ReviewEmail;
	@FindBy (xpath="//textarea[@name='review']")WebElement ReviewMessage;
	@FindBy (xpath="//form[@id='review-form']/child::button")WebElement ReviewSudmitBTN;
	@FindBy (xpath="//form[@id='review-form']/child::div/descendant::div[2]/span")WebElement Validate11;
	@FindBy (xpath="//div[@Class='container']/child::button/i")WebElement SearchBTN;
	
	
	public void VerifyallProducts_Productdetailspage() throws InterruptedException {
		HomepageBTN.click();
		Thread.sleep(5000);
		ProductBTN.click();
		Thread.sleep(5000);
		String Allproduct= Validate1.getText();
		System.out.println(Allproduct);
		Assert.assertEquals(Allproduct, "ALL PRODUCTS");
		FirstproductBTN.click();
		String productname= Validate2.getText();
		Assert.assertEquals(productname, "Blue Top");
		String catogry = Validate4.getText();
		Assert.assertEquals(catogry, "Category: Women > Tops");
		String price = Validate5.getText();
		Assert.assertEquals(price, "Rs. 500");
		String Availability = Validate6.getText();
		Assert.assertEquals(Availability, "Availability: In Stock");
		String condition = Validate7.getText();
		Assert.assertEquals(condition, "Condition: New");
		String Brand = Validate8.getText();
		Assert.assertEquals(Brand, "Brand: Polo");
		System.out.println("All validate successfully");
		HomepageBTN.click();
	}
	public void Searchproduct() {
		ProductBTN.click();
		String Serach = Validate3.getText();
		System.out.println(Serach);
		Validate3.sendKeys("Men Tshirt");
		SearchBTN.click();
	}
	public void ViewCategoryProdcuts() {
		CatorgryWomenBTN.click();
		DressBTN.click();
		String Women= Validate1.getText();
		System.out.println(Women);
		Assert.assertEquals(Women, "WOMEN - DRESS PRODUCTS");
		CatorgrymenBTN.click();
		TshirtBTN.click();
		String men= Validate1.getText();
		System.out.println(men);
		Assert.assertEquals(men, "MEN - TSHIRTS PRODUCTS");
	}
	public void ViewandCartBrandProdcuts() {
		String Brand = Validate9.getText();
		Assert.assertEquals(Brand, "BRANDS");
		HMBTN.click();
		String HM= Validate1.getText();
		System.out.println(HM);
		Assert.assertEquals(HM, "BRAND - H&M PRODUCTS");
		POLOBTN.click();
		String polo= Validate1.getText();
		System.out.println(polo);
		Assert.assertEquals(polo, "BRAND - POLO PRODUCTS");
	}
	public void AddReviewonProduct() {
		PoloViewProductBTN.click();
		String Review= Validate10.getText();
		System.out.println(Review);
		Assert.assertEquals(Review, "WRITE YOUR REVIEW");
		Reviewname.sendKeys("Tom");
		ReviewEmail.sendKeys("Tomcruise01@gmail.com");
		ReviewMessage.sendKeys("A very nice brand product");
		ReviewSudmitBTN.click();
		String SuccessReview = Validate11.getText();
		System.out.println(SuccessReview);
		Assert.assertEquals(SuccessReview, "Thank you for your review.");
		HomepageBTN.click();
	}
	
		
		
	}


