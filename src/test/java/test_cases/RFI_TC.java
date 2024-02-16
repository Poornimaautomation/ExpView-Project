package test_cases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import page_object.login_page;
import utilities.XlUtils;

public class RFI_TC extends base_class{
	login_page lp;
	WebDriverWait wait;
	
	String[] files=new String[] {"D:\\Poornima_Data\\Automation\\AutoIT scripts\\RFI_comment_image.exe",
								"D:\\Poornima_Data\\Automation\\AutoIT scripts\\RFI_comment_pdf.exe"};

	//Test Case-1 (To verify login by valid email and password)
	@Test(priority=1)
	public void Verify_valid_Login() throws InterruptedException, IOException{
		lp=new login_page(driver);
		wait = new WebDriverWait(driver, 10);
		lp.Login(email1, password1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Successfully Logged In')]")));	
		lp.click_dashboard_action();
	}

	/*//Test Case-2 (To verify raise RFI)
	@Test(priority=2)
	public void Verifyraise_RFI() throws InterruptedException, IOException{
		Thread.sleep(3000);
//		lp.click_dashboard_action();
		int j=1; //j is no. of rows
		for(int i=1;i<=2;i++) //i is no. of RFI's
		{
			Thread.sleep(3000);
			lp.click_raise_rfi_btn();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='title']")).sendKeys(XlUtils.getCellData(path,"RFI", j, 1));
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(XlUtils.getCellData(path,"RFI", j, 2));
			lp.click_duedate();
			lp.click_ok();
			for(int k=1;k<=2;k++) //k is no. of Files
			{
				Thread.sleep(2000);
				lp.click_upload_file();
				Runtime.getRuntime().exec(files[k-1]);
				Thread.sleep(4000);
			}
			lp.click_save_btn();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'RFI created successfully')]")));
			Thread.sleep(2000);
			//		lp.click_cancel_btn();
			j=j+1;
		}
	}
	
	//Test Case-3 (To verify RFI comment)
	@Test(priority=3)
	public void Verify_rfi_comment() throws InterruptedException, IOException{
		Thread.sleep(3000);
		int j=1;
		for(int i=1;i<=2;i++) //i is no. of RFI's
		{
		String title = XlUtils.getCellData(path,"RFI", j, 1);
		driver.findElement(By.xpath("//td[text()='"+title+"']")).click();
			for(int k=1;k<=2;k++) //k is no. of Files
			{
				Thread.sleep(3000);
				lp.click_attach_btn();
				Runtime.getRuntime().exec(files[k-1]);
				Thread.sleep(4000);
				lp.click_send_btn();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='progressbar']")));
				Thread.sleep(2000);
			}
			lp.click_back_btn();
			j=j+1;
		}
	}*/
	
	//Test Case-4 (To verify close RFI without comment)
	@Test(priority=4)
	public void Verify_close_rfi_without_comment() throws InterruptedException, IOException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[text()='Open']")).click();
		Thread.sleep(3000);
		lp.click_close_rfi();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Please comment before closing the RFI')]")));
		Thread.sleep(2000);
		lp.click_back_btn();
	}
	
	//Test Case-5 (To verify close RFI with comment)
	@Test(priority=5)
	public void Verify_close_rfi_with_comment() throws InterruptedException, IOException{
		Thread.sleep(3000);
		for(int i=1;i<=2;i++) //i is no. of RFI's
		{
			driver.findElement(By.xpath("//td[text()='Open']")).click();
			Thread.sleep(3000);
			lp.enter_text_comment("Hi");
			lp.click_send_btn();
			Thread.sleep(3000);
			lp.click_close_rfi();
		}
	}
	
//	//Test Case-6 (To verify Logout functionality)
//	@Test(priority=6)
//	public void Verify_logout() throws InterruptedException, IOException{
//		Thread.sleep(3000);
//		lp.click_thumbnail();
//		lp.click_logout();
//		lp.click_confirm_logout();
//		lp.click_confirm_logout();
//	}

}
