package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page 
{
	WebDriver ldriver;
	public login_page(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement login_btn;
	
	public void set_email(String uname) 
	{
		email.sendKeys(uname);
	}
	
	public void set_password(String pwd) 
	{
		password.sendKeys(pwd);
	}
	
	public void click_login() 
	{
		login_btn.click();
	}
	
	public void Login(String uname, String pwd) 
	{
		email.sendKeys(uname);
		password.sendKeys(pwd);
		login_btn.click();
	}
	
	@FindBy(xpath="//button[@type='button']")
	WebElement auth_thumbnail;
	
	public void click_auth_thumbnail() 
	{
		auth_thumbnail.click();
	}
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	WebElement thumbnail;
	
	public void click_thumbnail() 
	{
		thumbnail.click();
	}
	
	@FindBy(xpath="//span[text()='LogOut']")
	WebElement logout;
	
	public void click_logout() 
	{
		logout.click();
	}
	
	@FindBy(xpath="//span[text()='Yes']")
	WebElement confirm_logout;
	
	public void click_confirm_logout() 
	{
		confirm_logout.click();
	}
	
	@FindBy(xpath="//span[text()='Dev']")
	WebElement dev_client;
	
	public void click_dev_client() 
	{
		dev_client.click();
	}
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	WebElement forgot_password;
	
	public void click_forgot_password() 
	{
		forgot_password.click();
	}
	
	@FindBy(xpath="//span[text()='Send OTP']")
	WebElement send_otp;
	
	public void click_send_otp() 
	{
		send_otp.click();
	}
	
	@FindBy(xpath="//span[text()='star']")
	WebElement star;
	
	public void click_star() 
	{
		Actions actions = new Actions(ldriver);
		actions.moveToElement(star);
	}
	
	//@FindBy(xpath="(//a[@role='button'])[1]")
	@FindBy(xpath="//img[@alt='logo']")
	WebElement star1;
	
	public void click_star1() 
	{
//		Actions actions = new Actions(ldriver);
//		actions.moveToElement(star1);
		star1.click();
	}
	
	public boolean Login_btn_isenabled()
	{
		login_btn.isEnabled();
		return false;
	}
	
	@FindBy(xpath="(//button[@type='button'])[6]")
	WebElement dashboard_action;
	
	public void click_dashboard_action() 
	{
		dashboard_action.click();
	}
	
	@FindBy(xpath="//span[text()='Raise RFI']")
	WebElement raise_rfi_btn;
	
	public void click_raise_rfi_btn() 
	{
		raise_rfi_btn.click();
	}
	
	@FindBy(xpath="//input[@name='title']")
	WebElement rfititle;
	
	public void enter_rfi_tite(String rfi_title1) 
	{
		rfititle.sendKeys(rfi_title1);
	}
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement rfidesc;
	
	public void enter_rfi_desc(String rfi_desc1) 
	{
		rfidesc.sendKeys(rfi_desc1);
	}
	
	@FindBy(xpath="(//button[@type='button'])[12]")
	WebElement duedate;
	
	public void click_duedate() 
	{
		duedate.click();
	}
	
	@FindBy(xpath="//span[text()='OK']")
	WebElement ok;
	
	public void click_ok() 
	{
		ok.click();
	}
	
	@FindBy(xpath="//label[@for='selectedFile']")
	WebElement upload_file;
	
	public void click_upload_file() 
	{
		upload_file.click();
	}
	
	@FindBy(xpath="//span[text()=' Save ']")
	WebElement save_btn;
	
	public void click_save_btn() 
	{
		save_btn.click();
	}
	
	@FindBy(xpath="//span[text()='Cancel']")
	WebElement cancel_btn;
	
	public void click_cancel_btn() 
	{
		cancel_btn.click();
	}
	
	@FindBy(xpath="//*[@id='fuse-main']/div/div/div[2]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div")
	WebElement attach_btn;
	
	public void click_attach_btn() 
	{
		attach_btn.click();
	}
	
	@FindBy(xpath="//span[@role='button']")
	WebElement send_btn;
	
	public void click_send_btn() 
	{
		send_btn.click();
	}
	
	@FindBy(xpath="//*[@id='fuse-main']/div/div/div[1]/div/div[1]/button")
	WebElement back_btn;
	
	public void click_back_btn() 
	{
		back_btn.click();
	}
	
	@FindBy(xpath="//textarea[@placeholder='Type a message']")
	WebElement txt_comment;
	
	public void enter_text_comment(String text_comment) 
	{
		txt_comment.sendKeys(text_comment);
	}
	
	@FindBy(xpath="//span[text()='Close ']")
	WebElement close_rfi;
	
	public void click_close_rfi() 
	{
		close_rfi.click();
	}
	
//	@FindBy(xpath="(//button[@type='button'])[12]")
//	WebElement thumbnail;
//	
//	public void click_thumbnail() 
//	{
//		thumbnail.click();
//	}
	
	
}