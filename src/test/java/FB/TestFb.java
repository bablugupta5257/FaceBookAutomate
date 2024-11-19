package FB;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ExtentReportManage.class)
public class TestFb extends BaseClass{

@Test
public void CreateUser() throws EncryptedDocumentException, IOException, InterruptedException {
	driver.findElement(By.linkText("Create new account")).click();
	Thread.sleep(4000);
	LoginAndCreateUserData lc = new LoginAndCreateUserData();
	 String cname = lc.readExceldata("Sheet1", 3, 1);
	driver.findElement(By.name("firstname")).sendKeys(cname);
	
	driver.findElement(By.name("lastname")).sendKeys(lc.readExceldata("Sheet1", 3, 2));
	 WebElement day = driver.findElement(By.id("day"));
	 WebElement month = driver.findElement(By.id("month"));
	 WebElement year = driver.findElement(By.id("year"));
	Select s = new Select(day);
	Select s1 = new Select(month);
	Select s2 = new Select(year);
	s.selectByValue(lc.readExceldataForNumeric("Sheet1", 3, 3));
	s1.selectByVisibleText(lc.readExceldata("Sheet1", 3, 4));
	s2.selectByVisibleText(lc.readExceldataForNumeric("Sheet1", 3, 5));
	
	String gender = lc.readExceldata("Sheet1", 3, 6);
	if(gender.equals("Male")) {
	driver.findElement(By.xpath("//label[.='Male']")).click();
	}
	else {
		driver.findElement(By.xpath("//label[.='Female']")).click();
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys(lc.readExceldataForNumeric("Sheet1", 3, 7));
	driver.findElement(By.id("password_step_input")).sendKeys(lc.readExceldata("Sheet", 3, 8));
	Thread.sleep(5000);
	
	driver.navigate().refresh();
}

@Test
public void Loginpage() {
	Reporter.log(" Login page added",true);

	//driver.findElement(by)
}
}