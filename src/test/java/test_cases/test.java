package test_cases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://test.exponentialists.ai");
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("n.poornima@agathsya.net");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Raise RFI']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[text()='']")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//span[text()='Raise RFI']")).click();
//		Thread.sleep(4000);


	}
}