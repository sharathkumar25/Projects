package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class footerFunctionality {
WebDriver driver;
	
	public footerFunctionality(WebDriver wb) {
		
		driver=wb;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath ="//ul[@class='footer links']/child::li/child::a") WebElement fsearchBTN;
	@FindBy (xpath="//ul[@class='search-terms']/child::li[30]/child::a") WebElement HoddieBTN;
	@FindBy (xpath="//ul[@class='footer links']/child::li[2]/child::a") WebElement privacyandcookieBTN;
	@FindBy (xpath="//ul[@class='footer links']/child::li[3]/child::a") WebElement AdvancedsearchBTN;
	@FindBy (id="sku") WebElement SKUBTN;
	@FindBy (xpath="//*[@id=\"form-validate\"]/div/div/button") WebElement AsearchBTN;
	@FindBy (xpath="//div[@class='links']/child::div/child::ul/child::li[1]/child::a") WebElement notesBTN;
	@FindBy (xpath="//div[@class='links']/child::div/child::ul/child::li[2]/child::a") WebElement ApitestBTN;
	@FindBy (xpath="//div[@class='links']/child::div/child::ul/child::li[3]/child::a") WebElement WriteforusBTN;
	@FindBy (xpath="//div[@class='links']/child::div/child::ul/child::li[4]/child::a") WebElement SuscribeBTN;
	@FindBy (xpath="//a[@Class='logo']" ) WebElement nlogo;
	
	public void Clickon_searchitem() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		fsearchBTN.click();
		HoddieBTN.click();
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		}
	public void Privacy_cookiepolicy() throws InterruptedException {
		privacyandcookieBTN.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
	}
	public void AdvancedSearch() throws InterruptedException {
		AdvancedsearchBTN.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		SKUBTN.sendKeys("24-UG06");
		Thread.sleep(2000);
		AsearchBTN.click();
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
	}
	public void Notes() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		notesBTN.click();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;}}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(mainWindowHandle);
	}
	public void Practice_APITesting_usingMagento2() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		ApitestBTN.click();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;}}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(mainWindowHandle);
		
	}
	public void Write_forus() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		WriteforusBTN.click();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;}}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(mainWindowHandle);
		
	}
	public void Subscribe() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		SuscribeBTN.click();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;}}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(mainWindowHandle);
		nlogo.click();
		
	}

}
