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
	@FindBy (xpath="//div[@class='features_items']/child::div[2]/child::div/child::div[2]/ul/li/a")WebElement FirstproductBTN;
	@FindBy (xpath="//div[@Class='product-information']")WebElement Validate2;
	@FindBy (id="search_product")WebElement Validate3;
	@FindBy (id="submit_search")WebElement SearchBTN;
	
	
	public void VerifyallProducts_Productdetailspage() throws InterruptedException {
		HomepageBTN.click();
		Thread.sleep(5000);
		ProductBTN.click();
		Thread.sleep(5000);
		String Allproduct= Validate1.getText();
		System.out.println(Allproduct);
		Assert.assertEquals(Allproduct, "ALL PRODUCTS");
		FirstproductBTN.click();
		String productindetail= Validate2.getText();
		System.out.println(productindetail);
		Assert.assertEquals(productindetail, "Blue Top");
		Assert.assertEquals(productindetail, "Category: Women > Tops");
		Assert.assertEquals(productindetail, "Rs. 500");
		Assert.assertEquals(productindetail, "Availability: In Stock");
		Assert.assertEquals(productindetail, "Condition: New");
		Assert.assertEquals(productindetail, "Brand: Polo");
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
	
		
		
	}


