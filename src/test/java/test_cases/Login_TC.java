package test_cases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page_object.login_page;

public class Login_TC extends base_class{
	login_page lp;
	WebDriverWait wait;

	//Test Case-1 (To verify auth login by valid email and valid password)
	@Test(priority=1)
	public void Verify_valid_auth_Login() throws InterruptedException, IOException{
		lp=new login_page(driver);
		wait = new WebDriverWait(driver, 20);
		lp.Login(email1, password1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Successfully Logged In')]")));	
		Thread.sleep(2000);
//		lp.click_dev_client();
//		Thread.sleep(9000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Client Authentication')]")));	
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Successfully Logged In')]")));	

	}
	
	//Test Case-2 (To verify auth logout)
	@Test(priority=2)
	public void Verify_auth_logout() throws InterruptedException, IOException{
		Thread.sleep(3000);
		lp.click_auth_thumbnail();
		Thread.sleep(2000);
		lp.click_logout();
		Thread.sleep(2000);
		lp.click_confirm_logout();
	}
	
//	//Test Case-2 (To verify login by invalid email and valid password)
//	@Test(priority=2)
//	public void VerifyInvalidLogin2() throws InterruptedException, IOException{
//		driver.navigate().refresh();
//		lp.Login(email2, password2);
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Invalid email or password')]")));	
//	}
//	
//	//Test Case-3 (To verify login by invalid email and invalid password)
//	@Test(priority=3)
//	public void VerifyInvalidLogin3() throws InterruptedException, IOException{
//		driver.navigate().refresh();
//		lp.Login(email3, password3);
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Invalid email or password')]")));	
//	}
//	
//	//Test Case-4 (To verify login by valid email and invalid password)
//	@Test(priority=4)
//	public void VerifyValidLogin() throws InterruptedException, IOException{
//		driver.navigate().refresh();
//		lp.Login(email4, password4);
//		Thread.sleep(3000);		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Successfully Logged In')]")));		
//	}
//	
//	//Test Case-5 (To verify login by Negative Email-Id)
//	@Test(priority=5)
//	public void VerifyInvalidEmail1() throws InterruptedException, IOException{
//		
//		LoginPage lp=new LoginPage(driver);
//		lp.click_thumbnail();
//		lp.click_log_out();
//		Thread.sleep(2000);
//		lp.click_forgot_password();
//		Thread.sleep(1000);
//		lp.set_email(invalid_email);
//		Thread.sleep(1000);
//		lp.click_send_otp();
//		Thread.sleep(1000);
//		driver.switchTo().alert().accept();
//		if(driver.getPageSource().contains("You must enter a valid email")){
//			Assert.assertTrue(true);
//			}
//		else{
//			//capturescreenshot(driver, "logintest5");
//			Assert.assertTrue(false);
//		}	
//	}
//	
//	//Test Case-6 (To verify login by Negative Email-Id)
//	@Test(priority=6)
//	public void VerifyInvalidEmail1() throws InterruptedException, IOException{
//		
//		LoginPage lp=new LoginPage(driver);
//		Thread.sleep(3000);
//		//lp.click_star();
//		lp.click_star1();
//		Thread.sleep(5000);
//
//	}
//	
//	//Test Case-5 (To verify login by Negative Email-Id)
//	@Test(priority=5)
//	public void VerifyInvalidEmail1() throws InterruptedException, IOException{
//		
//		Login_page lp=new Login_page(driver);
//		lp.click_thumbnail();
//		lp.click_log_out();
//		String email = XlUtils.getCellData(path,"Login", 1, 3);
//		lp.set_email(email);
//		Thread.sleep(1000);
//		if(driver.getPageSource().contains("You must enter a valid email")){
//			Assert.assertTrue(true);
//			}
//		else{
//			//capturescreenshot(driver, "logintest5");
//			Assert.assertTrue(false);
//		}	
//	}
//	
//	//Test Case-6 (To verify login by Negative Email-Id)
//	@Test(priority=6)
//	public void VerifyInvalidEmail2() throws InterruptedException, IOException{
//		
//		Login_page lp=new Login_page(driver);
//		driver.navigate().refresh();
//		String email = XlUtils.getCellData(path,"Login", 2, 3);
//		lp.set_email(email);
//		Thread.sleep(1000);
//		if(driver.getPageSource().contains("You must enter a valid email")){
//			Assert.assertTrue(true);
//			}
//		else{
//			//capturescreenshot(driver, "logintest6");
//			Assert.assertTrue(false);
//		}	
//	}
//	
//	//Test Case-7 (To verify login by Negative Email-Id)
//	@Test(priority=7)
//	public void VerifyInvalidEmail3() throws InterruptedException, IOException{
//		
//		Login_page lp=new Login_page(driver);
//		driver.navigate().refresh();
//		String email = XlUtils.getCellData(path,"Login", 3, 3);
//		lp.set_email(email);
//		Thread.sleep(1000);
//		if(driver.getPageSource().contains("You must enter a valid email")){
//			Assert.assertTrue(true);
//			}
//		else{
//			//capturescreenshot(driver, "logintest7");
//			Assert.assertTrue(false);
//		}	
//	}
//	
//	//Test Case-8 (To verify login by Negative Email-Id)
//	@Test(priority=8)
//	public void VerifyInvalidEmail4() throws InterruptedException, IOException{
//		
//		Login_page lp=new Login_page(driver);
//		driver.navigate().refresh();
//		String email = XlUtils.getCellData(path,"Login", 4, 3);
//		lp.set_email(email);
//		Thread.sleep(1000);
//		if(driver.getPageSource().contains("You must enter a valid email")){
//			Assert.assertTrue(true);
//			}
//		else{
//			//capturescreenshot(driver, "logintest8");
//			Assert.assertTrue(false);
//		}	
//	}
//	
//	//Test Case-9 (To verify login by Positive Email-Id)
//	@Test(priority=9)
//	public void VerifyValidEmail1() throws InterruptedException, IOException{
//		
//		Login_page lp=new Login_page(driver);
//		driver.navigate().refresh();
//		String email = XlUtils.getCellData(path,"Login", 1, 2);
//		lp.set_email(email);
//		Thread.sleep(1000);
//		if(driver.getPageSource().contains("You must enter a valid email")){
//			//capturescreenshot(driver, "logintest9");
//			Assert.assertTrue(false);
//			}
//		else{
//			Assert.assertTrue(true);
//		}	
//	}
//	
//	//Test Case-10 (To verify login by Positive Email-Id)
//	@Test(priority=10)
//	public void VerifyValidEmail2() throws InterruptedException, IOException{
//		
//		Login_page lp=new Login_page(driver);
//		driver.navigate().refresh();
//		String email = XlUtils.getCellData(path,"Login", 2, 2);
//		lp.set_email(email);
//		Thread.sleep(1000);
//		if(driver.getPageSource().contains("You must enter a valid email")){
//			//capturescreenshot(driver, "logintest10");
//			Assert.assertTrue(false);
//			}
//		else{
//			Assert.assertTrue(true);
//		}	
//	}
	
	
//	//Test Case- (To verify if login button is enabled by entering valid email without password)
//	@Test(enabled=false)
//	public void logintest__() throws InterruptedException, IOException{
//		
//		Login_page lp=new Login_page(driver);
//		lp.click_thumbnail();
//		lp.click_log_out();
//		String email = XlUtils.getCellData(path,"Login", 1, 0);
//		lp.set_email(email);
//		if(lp.Login_btn_isenabled()){
//			Assert.assertTrue(true);
//			}
//		else{
//			//capturescreenshot(driver, "logintest");
//			Assert.assertTrue(false);
//		}	
//	}
	
	
	
}