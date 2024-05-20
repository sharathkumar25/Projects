package seleniumassign4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String Filepath = "C:\\Users\\thand\\OneDrive\\Desktop\\Sharath\\jyothi\\Book2.xlsx";
		
		FileInputStream ExcelFile = new FileInputStream(Filepath);
		try (XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile)) {
			XSSFSheet sheet = workbook.getSheet("poi");
			XSSFRow row=sheet.getRow(1);
			XSSFCell username=row.getCell(0);
			XSSFCell password=row.getCell(1);
			
			System.out.println("UserName-->"+username+"    Password-->"+password);
			
			driver.findElement(By.name("username")).sendKeys(username.toString());
			driver.findElement(By.name("password")).sendKeys(password.toString());
		}
		driver.findElement(By.xpath("//button[@Class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@Class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();
		ExcelFile.close();
		
		
		
	}

}
