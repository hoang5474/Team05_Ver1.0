package DoAnCuoiKy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChucNangHocKy {
    @Test
    public static void setup() throws InterruptedException {
		// TODO Auto-generated method stub
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		String url = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Account/Login";

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"OpenIdConnect\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("i0116")).sendKeys("toan.197ct22622@vanlanguni.vn");
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("i0118")).sendKeys("VLU197ct22622");
		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id=\"idBtn_Back\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Học kỳ và ngành")).click();
		Thread.sleep(2000);
		//tạo học kỳ
		driver.findElement(By.xpath("//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		// nhap hoc ky
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("993");
		Thread.sleep(2000);
		//chon ngay bat dau
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[4]")).click();
		Thread.sleep(2000);
		//luu hoc ky da tao
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000);

		//tim hoc ky 818
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("818");
		Thread.sleep(2000);
		//chinh sua hoc ky
		driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
		Thread.sleep(2000);
		//Chinh sua tuan bat dau
		driver.findElement(By.xpath("//*[@id=\"start_week\"]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"start_week\"]")).sendKeys("6");
		Thread.sleep(1000);
		//chon ngay bat dau
		// driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[6]")).click();
		// Thread.sleep(2000);
		//chon tiet toi da
		driver.findElement(By.xpath("//*[@id=\"max_lesson\"]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"max_lesson\"]")).sendKeys("5");
		Thread.sleep(1000);
		//Chon lop toi da
		driver.findElement(By.xpath("//*[@id=\"max_class\"]")).clear();
        Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"max_class\"]")).sendKeys("9");
		Thread.sleep(2000);
		//luu chinh sua
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000);

		// xoa hoc ky va nganh
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("993");
		Thread.sleep(2000);
		// hoan tat xoa
		driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[6]/button[1]")).click();
		Thread.sleep(2000);

		driver.quit();
	}
}
