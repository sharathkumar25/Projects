package Project1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

public class AddtocartFunctionality {
WebDriver driver;
	
	public AddtocartFunctionality(WebDriver wb) {
		
		driver=wb;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath="//a[@Class='logo']" ) WebElement nlogo;
	@FindBy (xpath="//nav[@class='navigation']//child::ul/child::li[@class='level0 nav-3 category-item level-top parent ui-menu-item']//child::a//child::span") WebElement menBTN;
	@FindBy (xpath="//div[@Class='categories-menu']//child::ul//child::li[3]//child::a") WebElement teeBTN;
	@FindBy (xpath="//div[@id='option-label-size-143-item-170']" ) WebElement XLBTN;
	@FindBy (xpath="//div[@id='option-label-color-93-item-56']" ) WebElement orangeBTN;
	@FindBy (xpath="//div[@class='field qty']//child::input" ) WebElement QtyBTN;
	@FindBy (xpath="//div[@class='actions']//child::button[@title='Add to Cart']" ) WebElement AddtoBTN;
	@FindBy (xpath="/html/body/div[2]/header/div[2]/div[1]/a" ) WebElement cartBTN;
	@FindBy (xpath="//div[@class='actions']//child::div//child::button" ) WebElement processedBTN;
	@FindBy (xpath="//div[@Class='primary']/child::button[@Class='button action continue primary']") WebElement ShippingBTN;
	@FindBy (xpath="//button[@class='action primary checkout']") WebElement ReviewBTN;
	@FindBy (xpath="//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a") WebElement orderidBTN;
	
	
	public void select_product_Specification() throws InterruptedException {
		nlogo.click();
		menBTN.click();
		teeBTN.click();
		List<WebElement> Vlinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links:"+Vlinks.size());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		for(int i=0;i<Vlinks.size();i++) {
			WebElement currentlink = Vlinks.get(i);
			String Vlinknamee = currentlink.getText();
			if (Vlinknamee.equals("Balboa Persistence Tee")) {
				Vlinks.get(i).click();
				break;
			}
		}
		js.executeScript("window.scrollBy(0,500)");
		XLBTN.click();
		orangeBTN.click();
		QtyBTN.clear();
		QtyBTN.sendKeys("1");
		Thread.sleep(3000);
	}
	
	
	public void addtocart() throws InterruptedException {
		AddtoBTN.click();
		Thread.sleep(3000);
		cartBTN.click();
		processedBTN.click();
	}
	
	
	public void Select_shipingdetails() throws InterruptedException {
		Thread.sleep(3000);
		ShippingBTN.click();
		Thread.sleep(3000);
		String Actualtitle = driver.getTitle();
		String EXptitle = "Checkout";
		System.out.println(Actualtitle);
		if (Actualtitle.equals(EXptitle)) {
			System.out.println("Title are matched");
		}
		else {
			System.out.println("Titles are not matched");
		}
		System.out.println(driver.getCurrentUrl());
	}
	
	
	public void Select_Review_Payments() throws InterruptedException {
		Thread.sleep(5000);	
		ReviewBTN.click();
		}
	
	
	public void order_confirmation() throws IOException, InterruptedException {
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		File f = ((TakesScreenshot) js).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\Orderconfirmation.jpeg"));
		Thread.sleep(2000);
		orderidBTN.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,100)");
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		System.out.println(driver.getCurrentUrl());
	}
}
