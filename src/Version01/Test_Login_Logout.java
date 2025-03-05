package Version01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Login_Logout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\AutoTest\\chromedriver-win64\\chromedriver.exe");
		String url = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Account/Login";

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.id("OpenIdConnect")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("hoang.2174802010796@vanlanguni.vn");
		driver.findElement(By.id("idSIButton9")).click();
	}
}
