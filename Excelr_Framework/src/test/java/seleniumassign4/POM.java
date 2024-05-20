package seleniumassign4;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POM {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		loginpage lp = new loginpage(driver);
		Adminmodule Am = new Adminmodule(driver);
		Add_databyexcel ad = new Add_databyexcel(driver);
		
		lp.url();
		lp.enterusername("Admin");
		lp.enterpassword("admin123");
		lp.clickloginbtn();
		
		Am.clickloginadmin();
		Am.ClickonAddBTN();
		
		ad.selectuserrole();
		ad.EnterEmployename();
		ad.Selectstatus();
		ad.excelstup();
		ad.ClickonSudmit();
		
		
	}

}
