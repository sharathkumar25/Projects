package projectexmaplepackages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class project2 {
	WebDriver driver;
	@BeforeSuite
	public void login() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.linkText("Sign In")).click();
		Thread.sleep(3000);
	}
	@Test (priority = 1)
	public void invaliddetails() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.id("email")).sendKeys("tom&jerry@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Cartoon@1");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		//The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
		Thread.sleep(2000);

		
	}
	@Test (priority = 2)
	public void validdetails() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("badboy@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Project@1");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Thread.sleep(2000);
	}
	@Test (priority = 3)
	public void Searchbar() {
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("shirt");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links:"+links.size());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		for(int i=0;i<links.size();i++) {
			WebElement currentlink = links.get(i);
			String linknamee = currentlink.getText();
			if (linknamee.equals("Radiant Tee")) {
				links.get(i).click();
				break;
			}
		}
		js.executeScript("window.scrollBy(0,500)");
		
	}
	@Test (priority = 4)
	public void clickonLogo() throws InterruptedException {
		Thread.sleep(2000);
		WebElement logo = driver.findElement(By.xpath("//a[@Class='logo']"));
		logo.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		String Actualtitle = driver.getTitle();
		String EXptitle = "Home Page";
		System.out.println(Actualtitle);
		if (Actualtitle.equals(EXptitle)) {
			System.out.println("Title are matched");
		}
		else {
			System.out.println("Titles are not matched");
		}
		System.out.println(driver.getCurrentUrl());
	}
	@Test (priority = 5)
	public void clickonwhatsnewBTN() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='level-top ui-corner-all']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.navigate().back();
		Thread.sleep(2000);
	}
	@Test(priority = 6)
	public void Click_WomenBTN() throws InterruptedException {
		driver.findElement(By.xpath("//nav[@class='navigation']//child::li[2]//child::span[1]")).click();
		driver.findElement(By.xpath("//div[@Class='categories-menu']//child::li[2]//a")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
	}
	@Test(priority = 7)
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
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//div[@Class='product-social-links']//child::a//child::span")).click();
	}
	@Test (priority = 8)
	public void delete_product_fromwishlist() throws InterruptedException {
		Thread.sleep(2000);
		WebElement logo = driver.findElement(By.xpath("//a[@Class='logo']"));
		logo.click();
		driver.findElement(By.xpath("//span[@class='customer-name']//child::button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='customer-menu']//child::ul//child::li[2]")).click();
		Thread.sleep(3000);
		//WebElement delete = driver.findElement(By.xpath("//*[@id=\\\"item_2189\\\"]/div/strong/a"));
		//WebElement delete = driver.findElement(By.xpath("//span[@Class='product-image-wrapper']/child::img"));
		WebElement delete = driver.findElement(By.xpath("//div[@class='products-grid wishlist']/child::ol/li"));
		Actions act = new Actions(driver);
		act.moveToElement(delete).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='product-item-inner']//child::div[3]//child::a[2]")).click();
		System.out.println("Product got deleted from the wishlist");
		Thread.sleep(1000);
	}
	@Test(priority = 9)
	public void Verify_product_Discripation() throws InterruptedException {
		WebElement backtologo = driver.findElement(By.xpath("//a[@Class='logo']"));
		backtologo.click();
		driver.findElement(By.xpath("//nav[@class='navigation']//child::ul/child::li[@class='level0 nav-3 category-item level-top parent ui-menu-item']//child::a//child::span")).click();
		driver.findElement(By.xpath("//div[@Class='categories-menu']//child::ul//child::li[3]//child::a")).click();
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
		//WebElement movepic = driver.findElement(By.xpath("//div[@Class='fotorama__stage__shaft fotorama__grab']//child::div[2]"));
		WebElement movepic = driver.findElement(By.xpath("//div[@Class='fotorama__stage__shaft fotorama__grab']//child::div//child::img"));
		Actions mact = new Actions(driver);
		mact.moveToElement(movepic).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@Class='fotorama__arr fotorama__arr--next']//div")).click();
		Thread.sleep(1000);
		//mact.moveToElement(movepic).build().perform();
		//driver.findElement(By.xpath("//div[@Class='fotorama__arr fotorama__arr--prev']//div")).click();	
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath("//div[@id='tab-label-additional']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='product data items']//child::div[5]//child::a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='product data items']//child::div//child::a")).click();
		Thread.sleep(2000);
	}
	@Test (priority = 10)
	public void add_compare() throws InterruptedException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//div[@class='product-addto-links']//child::a[2]")).click();
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.linkText("comparison list")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@Class='cell remove product hidden-print']//child::a")).click();
		Thread.sleep(2000);
		WebElement accept = driver.findElement(By.xpath("//footer[@class='modal-footer']/child::button[2]"));
		accept.click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//footer[@Class='modal-footer']//child::button[@class='action-primary action-accept']")).click();
		}
	@Test (priority = 11)
	public void select_product_Specification() throws InterruptedException {
		WebElement backtologo = driver.findElement(By.xpath("//a[@Class='logo']"));
		backtologo.click();
		driver.findElement(By.xpath("//nav[@class='navigation']//child::ul/child::li[@class='level0 nav-3 category-item level-top parent ui-menu-item']//child::a//child::span")).click();
		driver.findElement(By.xpath("//div[@Class='categories-menu']//child::ul//child::li[3]//child::a")).click();
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
		driver.findElement(By.xpath("//div[@id='option-label-size-143-item-170']")).click();
		driver.findElement(By.xpath("//div[@id='option-label-color-93-item-56']")).click();
		driver.findElement(By.xpath("//div[@class='field qty']//child::input")).clear();
		driver.findElement(By.xpath("//div[@class='field qty']//child::input")).sendKeys("2");
		Thread.sleep(3000);
	}
	@Test (priority = 12)
	public void addtocart() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='actions']//child::button[@title='Add to Cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		//driver.findElement(By.xpath("//div[@data-block='minicart']//child::a")).click();
		driver.findElement(By.xpath("//div[@class='actions']//child::div//child::button")).click();
	}
	@Test(priority = 13)
	public void Select_shipingdetails() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@Class='primary']/child::button[@Class='button action continue primary']")).click();
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
	@Test(priority = 14)
	public void Select_Review_Payments() throws InterruptedException {
		Thread.sleep(5000);	
		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
		}
	@Test(priority = 15)
	public void order_confirmation() throws IOException, InterruptedException {
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		File f = ((TakesScreenshot) js).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\Orderconfirmation.jpeg"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a")).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,100)");
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		System.out.println(driver.getCurrentUrl());
	}
	@Test(priority = 16)
	public void Myaccount_Functionality() throws InterruptedException {
		driver.findElement(By.xpath("//a[@Class='logo']")).click();
		driver.findElement(By.xpath("//span[@class='customer-name']//child::button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='customer-menu']//child::ul//child::li[1]")).click();//account
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//div[@class='content block-collapsible-nav-content']/child::ul/child::li[2]/child::a")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='content block-collapsible-nav-content']/child::ul/child::li[3]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='content block-collapsible-nav-content']/child::ul/child::li[4]/child::a")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='content block-collapsible-nav-content']/child::ul/child::li[6]/child::a")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='content block-collapsible-nav-content']/child::ul/child::li[7]/child::a")).click();
		Thread.sleep(1500);
	}
	@Test(priority = 17)
	public void Change_Accoutname() throws InterruptedException {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Good");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Boy");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@Class='logo']")).click();
	}
	@Test(priority = 18)
	public void Clickon_searchitem() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//ul[@class='footer links']/child::li/child::a")).click();//searchitem
		driver.findElement(By.xpath("//ul[@class='search-terms']/child::li[30]/child::a")).click();//hoodie
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		}
	@Test(priority = 18)
	public void Privacy_cookiepolicy() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@class='footer links']/child::li[2]/child::a")).click();//privacy
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
	}
	@Test(priority = 19)
	public void AdvancedSearch() throws InterruptedException {
		driver.findElement(By.xpath("//ul[@class='footer links']/child::li[3]/child::a")).click();//advanced
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.id("sku")).sendKeys("24-UG06");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div/button")).click();
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
	}
	@Test(priority = 20)
	public void Notes() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='links']/child::div/child::ul/child::li[1]/child::a")).click();//notes
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(mainWindowHandle);
	}
	@Test(priority = 21)
	public void Practice_APITesting_usingMagento2() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='links']/child::div/child::ul/child::li[2]/child::a")).click();//notes
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().defaultContent();
		
	}
	@Test(priority = 22)
	public void Write_forus() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='links']/child::div/child::ul/child::li[3]/child::a")).click();//notes
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().defaultContent();
		
	}
	@Test(priority = 23)
	public void Subscribe() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='links']/child::div/child::ul/child::li[4]/child::a")).click();//notes
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String Actitile = driver.getTitle();
		System.out.println(Actitile);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().defaultContent();
		
	}
	
}
