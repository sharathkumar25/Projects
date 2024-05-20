package Project1;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class catogrysFunctionality {
WebDriver driver;
	
	public catogrysFunctionality(WebDriver wb) {
		
		driver=wb;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath ="//a[@class='level-top ui-corner-all']") WebElement whatsnewBTN;
	@FindBy (xpath="//nav[@class='navigation']//child::li[2]//child::span[1]") WebElement womenBTN;
	@FindBy (xpath="//div[@Class='categories-menu']//child::li[2]//a") WebElement jacketBTN;
	@FindBy (xpath="//div[@Class='product-social-links']//child::a//child::span" ) WebElement ClickwishlistBTN;
	@FindBy (xpath="//a[@Class='logo']" ) WebElement nlogo;
	@FindBy (xpath="//span[@class='customer-name']//child::button" ) WebElement accountBTN;
	@FindBy (xpath="//div[@class='customer-menu']//child::ul//child::li[2]")WebElement wishlistBTN;
	//@FindBy (xpath="//*[@id=\"item_2189\"]/div/strong/a")WebElement forMouserollover;
	@FindBy (xpath="//div[@class='products-grid wishlist']/child::ol/li")WebElement forMouserollover;
	@FindBy (xpath="//div[@class='product-item-inner']//child::div[3]//child::a[2]")WebElement DeletewishlistBTN;
	@FindBy (xpath="//nav[@class='navigation']//child::ul/child::li[@class='level0 nav-3 category-item level-top parent ui-menu-item']//child::a//child::span")WebElement menBTN;
	@FindBy (xpath="//div[@Class='categories-menu']//child::ul//child::li[3]//child::a")WebElement teesBTN;
	@FindBy (xpath="//div[@Class='fotorama__stage__shaft fotorama__grab']//child::div//child::img")WebElement movepicture;
	@FindBy (xpath="//div[@Class='fotorama__arr fotorama__arr--next']//div")WebElement clickonpic;
	@FindBy (xpath="//div[@id='tab-label-additional']")WebElement moreinformation;
	@FindBy (xpath="//div[@class='product data items']//child::div[5]//child::a")WebElement ReviewBTN;
	@FindBy (xpath="//div[@class='product data items']//child::div//child::a")WebElement detailsBTN;
	@FindBy (xpath="//div[@class='product-addto-links']//child::a[2]")WebElement clickoncompare;
	@FindBy (linkText="comparison list")WebElement compareTab;
	@FindBy (xpath="//td[@Class='cell remove product hidden-print']//child::a")WebElement deletecompare;
	@FindBy (xpath="//footer[@class='modal-footer']/child::button[2]")WebElement acceptdelete;
	
	
	
	
	public void clickonwhatsnew() throws InterruptedException {
		Thread.sleep(2000);
		whatsnewBTN.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.navigate().back();
		Thread.sleep(2000);
	}
	public void Click_Women() throws InterruptedException {
		womenBTN.click();
		jacketBTN.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(2000);}
	
	public void add_product_towishlist() {
	    List<WebElement> Plink = driver.findElements(By.tagName("a"));
	    System.out.println(Plink.size());
	    for (int i = 0; i < Plink.size(); i++) {
	        WebElement currentPLink = Plink.get(i);
	        String plinkname = currentPLink.getText();
	        if (plinkname.equals("Ingrid Running Jacket")) {
	            currentPLink.click();
	            break; // Exit the loop after clicking the desired link
	        }
	    }
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		ClickwishlistBTN.click();
	}
	public void delete_product_fromwishlist() throws InterruptedException {
		Thread.sleep(2000);
		nlogo.click();
		accountBTN.click();
		Thread.sleep(2000);
		wishlistBTN.click();
		//WebElement delete = driver.findElement(By.xpath("//span[@Class='product-image-wrapper']/child::img"));
		Actions act = new Actions(driver);
		act.moveToElement(forMouserollover).build().perform();
		Thread.sleep(2000);
		DeletewishlistBTN.click();
		System.out.println("Product got deleted from the wishlist");
		Thread.sleep(1000);
	}
	public void Verify_product_Discripation() throws InterruptedException {
		nlogo.click();
		menBTN.click();
		teesBTN.click();
		List<WebElement> Vlinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links:"+Vlinks.size());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		for(int i=0;i<Vlinks.size();i++) {
			WebElement currentlink = Vlinks.get(i);
			String Vlinknamee = currentlink.getText();
			if (Vlinknamee.equals("Balboa Persistence Tee")) {
				Vlinks.get(i).click();
				break;
			}
		}
		js.executeScript("window.scrollBy(0,350)");
		//WebElement movepic = driver.findElement(By.xpath("//div[@Class='fotorama__stage__shaft fotorama__grab']//child::div[2]"));
		//WebElement movepic = driver.findElement(By.xpath("//div[@Class='fotorama__stage__shaft fotorama__grab']//child::div//child::img"));
		Actions mact = new Actions(driver);
		mact.moveToElement(movepicture).build().perform();
		Thread.sleep(2000);
		clickonpic.click();
		Thread.sleep(1000);
		//mact.moveToElement(movepic).build().perform();
		//driver.findElement(By.xpath("//div[@Class='fotorama__arr fotorama__arr--prev']//div")).click();	
		js.executeScript("window.scrollBy(0,700)");
		moreinformation.click();//moreinformation
		Thread.sleep(1000);
		ReviewBTN.click();//Reviews
		Thread.sleep(1000);
		detailsBTN.click();//details
		Thread.sleep(2000);
	}
	public void add_compare() throws InterruptedException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		clickoncompare.click();
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		compareTab.click();
	}
	public void delete_compare() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		deletecompare.click();
		Thread.sleep(2000);
		acceptdelete.click();
		Thread.sleep(2000);
	}

}
