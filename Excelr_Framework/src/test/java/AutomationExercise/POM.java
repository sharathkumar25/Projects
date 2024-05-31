package AutomationExercise;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class POM {
	
	@Test
	public void calling_POM() throws InterruptedException {
		ChromeOptions otp = new ChromeOptions();
		otp.addExtensions(new File("C:\\Users\\thand\\Downloads\\AdBlock.crx"));
		WebDriver driver = new ChromeDriver(otp);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		Signup_Login_Page sl = new Signup_Login_Page(driver);
		HomepageFunctionalitys hf = new HomepageFunctionalitys(driver);
		ProductFunctionality pf = new ProductFunctionality(driver);
		
		sl.GET_URL();
		sl.Registeruser();
		sl.VerifyLogout();
		sl.VerifyRegister_withExisting_Email();
		sl.VerifyLogin_withInvaliddetails();
		sl.VerifyLogin_withValiddetails();
		
		
//		hf.Verify_ContactUSFORM();
//		hf.Verify_TestcasesPage();
		
		
//		pf.VerifyallProducts_Productdetailspage();
//		pf.Searchproduct();
//		hf.VerifySubscriptionin_Homepage();
//		hf.VerifySubscriptionin_Cartpage();
		
		
		
		
		
		//driver.close();
	}

}
