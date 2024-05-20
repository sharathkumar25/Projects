package Project1;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POM_Calling {
	@Test
	public void Callingobjects() throws InterruptedException, AWTException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		Loginpage LP = new Loginpage(driver);//3 cases
		LP.url();
		LP.enter_invalid_details();
		LP.Enter_valid_details();
		
		Homepage sf = new Homepage(driver);//3 cases
		sf.Searchbar();
		sf.clickonLogo();
		sf.Verify_Ttile_URL();
		
		catogrysFunctionality cf = new catogrysFunctionality(driver);//7 cases
		cf.clickonwhatsnew();
		cf.Click_Women();
		cf.add_product_towishlist();
		cf.delete_product_fromwishlist();
		cf.Verify_product_Discripation();
		cf.add_compare();
		cf.delete_compare();
		
		AddtocartFunctionality af = new AddtocartFunctionality(driver);//5 cases
		af.select_product_Specification();
		af.addtocart();
		af.Select_shipingdetails();
		af.Select_Review_Payments();
		af.order_confirmation();
		
		accountFunctionality aff = new accountFunctionality(driver);//2 cases
		aff.Myaccount_Functionality();
		aff.Change_Accoutname();
		
		footerFunctionality ff = new footerFunctionality(driver);//7 cases
		ff.Clickon_searchitem();
		ff.Privacy_cookiepolicy();
		ff.AdvancedSearch();
		ff.Notes();
		ff.Practice_APITesting_usingMagento2();
		ff.Write_forus();
		ff.Subscribe();

	}

}
