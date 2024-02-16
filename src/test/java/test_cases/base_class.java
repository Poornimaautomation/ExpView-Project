package test_cases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.XlUtils;

public class base_class 
{
	public String auth_URL;
	public String dev_URL;
	public String uat_URL;
	public String email1;
	public String password1;
	public String rfi_title;
	public String rfi_desc;
	
	
	static String path = System.getProperty("user.dir")+"/Excel/Test_data.xlsx";

	public static WebDriver driver;
	public static Select selectobject;
	public static Logger logger= LogManager.getLogger(base_class.class);

	@Parameters("browser")
	@BeforeClass
	public void browser_setup(String br) throws IOException
	{
		if(br.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(br.equals("fire")) {
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	@Parameters("server")
	@BeforeClass
	public void server_setup(String srvr) throws IOException
	{
		if(srvr.equals("auth_server")) {
			//Dev server URL path
			String auth_URL = XlUtils.getCellData(path,"URL", 1, 1);
			this.auth_URL=auth_URL;
			driver.get(auth_URL);
		}
		else if(srvr.equals("dev_server")) {
			//Dev server URL path
			String dev_URL = XlUtils.getCellData(path,"URL", 2, 1);
			this.dev_URL=dev_URL;
			driver.get(dev_URL);
		}
		else if(srvr.equals("uat_server")) {
			//UAT server URL path
			String uat_URL = XlUtils.getCellData(path,"URL", 3, 1);
			this.uat_URL=uat_URL;
			driver.get(uat_URL);
		}
		
		//Valid email and valid password
		String email1 = XlUtils.getCellData(path,"Login", 1, 1);
		String password1 = XlUtils.getCellData(path,"Login", 1, 2);
		
		String rfi_title = XlUtils.getCellData(path,"RFI", 1, 1);
		String rfi_desc = XlUtils.getCellData(path,"RFI", 1, 2);

		this.email1=email1;
		this.password1=password1;
		this.rfi_title=rfi_title;
		this.rfi_desc=rfi_desc;
		
		
	}

	@AfterClass
	public void tearDown() throws InterruptedException
	{
//		Thread.sleep(5000);
//		driver.quit();
	}

	public void capturescreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		//System.out.println("ScreenShot taken");
	}

	// It will execute after every test execution 
	@AfterMethod
	public void screenShot(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			try {

				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				//String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
				FileUtils.copyFile(src, new File("./Screenshots/" + result.getName() +/* "-" + timeStamp + */".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}

}