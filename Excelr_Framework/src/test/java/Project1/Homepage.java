package Project1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
WebDriver driver;
	
	public Homepage(WebDriver wb) {
		
		driver=wb;
		PageFactory.initElements(driver, this);
	}
	//Repository
	@FindBy (xpath ="//input[@id='search']") WebElement Searchfeild;
	@FindBy (id="email") WebElement Iemail;
	@FindBy (xpath="//a[@Class='logo']") WebElement logo;
	
public void Searchbar() {
	Searchfeild.sendKeys("shirt");
	Searchfeild.sendKeys(Keys.ENTER);
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
public void clickonLogo() throws InterruptedException {
	Thread.sleep(2000);
	logo.click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(2000);
}
	public void Verify_Ttile_URL() {
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
	
}
	
	

