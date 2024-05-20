package seleniumassign4;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_databyexcel {
	WebDriver driver;
	
	public Add_databyexcel(WebDriver Ad) {
		driver =Ad;
		PageFactory.initElements(driver, this);
	}
	
	//Repository
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]") WebElement userrole;
	@FindBy (xpath="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input") WebElement Empname;
	@FindBy (xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]") WebElement status;
	@FindBy (xpath =" //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input") WebElement username;
	@FindBy (xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input") WebElement password;
	@FindBy	(xpath="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input") WebElement Cpassword;
	@FindBy (xpath="//button[@Class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")WebElement SudmitBTN;
	@FindBy (xpath="//p[@Class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']") WebElement VD;

	
	public void selectuserrole() throws InterruptedException {
		userrole.click();
		userrole.sendKeys("admin");
		Thread.sleep(3000);
		userrole.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void EnterEmployename() throws InterruptedException {
		Empname.sendKeys("Sharathhh  Kumar");
		Thread.sleep(3000);
		Empname.sendKeys(Keys.ARROW_DOWN);
		Empname.sendKeys(Keys.ENTER);
	}
	public void Selectstatus() {
		status.click();
		status.sendKeys("Enabled");
		status.sendKeys(Keys.ENTER);
	}
	public void excelstup() throws IOException {
		String Filepath = "C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\Book1.xlsx";
		FileInputStream ExcelFile = new FileInputStream(Filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
		XSSFSheet sheet = workbook.getSheet("details");
		XSSFRow row=sheet.getRow(1);
		XSSFCell usernm=row.getCell(0);
		XSSFCell pass=row.getCell(1);
		XSSFCell cPass=row.getCell(2);
		
		System.out.println("UserName-->"+usernm+"    Password-->"+pass+"    Confirm Password-->"+cPass);
		username.sendKeys(usernm.toString());
  		password.sendKeys(pass.toString());
  		Cpassword.sendKeys(cPass.toString());
  		ExcelFile.close();
  	
	}
	public void ClickonSudmit() throws InterruptedException {
		Thread.sleep(2000);
		SudmitBTN.click();
		String textM=VD.getText();
		if(textM.contains("Successfully Saved")) 
			System.out.println("Sucessfully validated ");
	else 
		System.out.println("not Sucessfully validated ");
	
		}
}

