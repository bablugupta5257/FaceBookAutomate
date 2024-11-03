package FB;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class BaseClass {
	public static WebDriver driver;
	
	
@BeforeSuite
public void DataBaseConnection() {
	Reporter.log("DataBase : Data Base Connected successfully",true);
}

@BeforeTest
public void LaunchBrowser() throws IOException, InterruptedException {
	FileInputStream f = new FileInputStream("./TestData/commonProperty.properties");
	Properties p = new Properties();
	p.load(f);
	if(p.getProperty("Browser").equals("Chrome")) {
	driver = new ChromeDriver();
	}
	else if(p.getProperty("Browser").equals("Edge")){
		driver = new EdgeDriver();
	}
	else if(p.getProperty("Browser").equals("Safari")) {
		driver = new SafariDriver();
	}
	else if(p.getProperty("Browser").equals("InternetExplorer")) {
		driver = new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	driver.get("https://www.facebook.com/");
	
	Reporter.log(" Browser Launch : Browser Launched successfully!",true);
	Thread.sleep(4000);
	
}
@BeforeMethod
public void login_Actitime() throws IOException {
/*	
	driver.findElement(By.id("email")).sendKeys("11rahulyadav.ry@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("rahul@123");
	driver.findElement(By.name("login")).click();
	*/
		 Reporter.log("Login : Login successfull!",true);
		 
	}


@AfterMethod
public void Logout() {
	
	Reporter.log("Logout : Successefully Logout!",true);
}

@AfterTest
public void CloseDriver() {
	driver.close();
	Reporter.log("Close : Driver closed successfully!",true);
}

@AfterSuite
public void DatabaseDisconect() {
	Reporter.log("DataBase : Database Disconnected successfully!",true);
}

}
