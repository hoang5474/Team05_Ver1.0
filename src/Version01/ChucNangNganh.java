package DoAnCuoiKy;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ChucNangNganh {
	WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
    }
    
    @Test
    public void MajorModule() throws InterruptedException {
    	// Đăng nhập microsoft
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
		
		// Kiểm tra Text mục quản lý ngành
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		verifyTitle("Quản lý ngành");
		verifyCurrentUrl("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Major");
		verifyTextClass("card-title", "Quản lý ngành");
		verifyTextClass("dataTables_filter", "Tìm kiếm:");
		verifyPlaceholder("//*[@id=\"tblMajor_filter\"]/label/input", "Nhập tìm kiếm...");
		verifyText("//*[@id=\"tblMajor\"]/thead/tr/th[2]", "MÃ NGÀNH");
		verifyText("//*[@id=\"tblMajor\"]/thead/tr/th[3]", "TÊN NGÀNH");
		verifyText("//*[@id=\"tblMajor\"]/thead/tr/th[4]", "TÊN VIẾT TẮT");
		verifyText("//*[@id=\"tblMajor\"]/thead/tr/th[5]", "CTĐT");
		selectRowsPerPageAndCount(10);
		selectRowsPerPageAndCount(25);
		selectRowsPerPageAndCount(50);
		selectRowsPerPageAndCount(-1);
		
		//Kiểm tra text của chức năng thêm ngành
		verifyButtonText("//*[@id=\"tblMajor_wrapper\"]/div[1]/div[2]/div/div[2]/button", "Thêm ngành mới");
		driver.findElement(By.xpath("//*[@id=\"tblMajor_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		verifyTextClass("ui-dialog-title", "Quản lý ngành học");
		verifyText("//*[@id=\"major-form\"]/div[1]/label", "Mã ngành:");
		verifyText("//*[@id=\"major-form\"]/div[2]/label", "Tên ngành:");
		verifyText("//*[@id=\"major-form\"]/div[3]/label", "Tên viết tắt:");
		verifyText("//*[@id=\"major-form\"]/div[4]/label", "CTĐT:");
		verifyText("//*[@id=\"select2-program_type-container\"]/span", "---- Chọn CTĐT ----");
		verifyPlaceholder("//*[@id=\"id\"]", "Nhập mã ngành");
		verifyPlaceholder("//*[@id=\"name\"]", "Nhập tên ngành");
		verifyPlaceholder("//*[@id=\"abbreviation\"]", "Nhập tên viết tắt của ngành");
		verifyButtonText("//*[@id=\"btnClose\"]", "Huỷ");
		verifyButtonText("//*[@id=\"major-form\"]/div[5]/button[2]", "Lưu");
		        
		driver.findElement(By.xpath("//*[@id=\"major-form\"]/div[5]/button[2]")).click();
		Thread.sleep(1000);
		verifyErrorTextById("id-error", "Bạn chưa nhập mã ngành");
		verifyErrorTextById("name-error", "Bạn chưa nhập tên ngành");
		verifyErrorTextById("abbreviation-error", "Bạn chưa nhập tên viết tắt của ngành");
		verifyErrorTextById("program_type-error", "Bạn chưa chọn CTĐT");
		     
		driver.findElement(By.xpath("//*[@id=\"id\"]")).click();
		driver.findElement(By.id("id")).sendKeys("@#$");
		verifyErrorTextById("id-error", "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!");
		driver.findElement(By.id("id")).clear();
		driver.findElement(By.id("btnClose")).click();
		Thread.sleep(2000);
		CreateAndFindNewMajor();
		  
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblMajor\"]/tbody/tr/td[6]/a[1]/i")).click();
		       
		Thread.sleep(2000);
		        
		}
		    
		   
	@AfterTest
	public void teardown() {
		driver.quit();
	}
		
	// Hàm kiểm tra text
	public void verifyText(String xpath, String expectedText) {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    String actualText = element.getText().trim();
	    // Tạo thông báo lỗi tự động nếu text không khớp
	    String errorMessage = "❌ Chữ '" + expectedText + "' không hiển thị đúng! (Thực tế: '" + actualText + "')";
	    Assert.assertEquals(actualText, expectedText, errorMessage);
	    System.out.println("✅ Chữ '" + expectedText + "' hiển thị đúng!");
	 }
	    
	 // Hàm kiểm tra text bằng class
	 public void verifyTextClass(String className, String expectedText) {
	     WebElement element = driver.findElement(By.className(className));
	     String actualText = element.getText().trim();
	     String errorMessage = "❌ Chữ '" + expectedText + "' không hiển thị đúng! (Thực tế: '" + actualText + "')";
	     Assert.assertEquals(actualText, expectedText, errorMessage);
	     System.out.println("✅ Chữ '" + expectedText + "' hiển thị đúng!");
	 }
	 
	//Hàm kiểm tra URL
	public void verifyCurrentUrl(String expectedUrl) {
	    String actualUrl = driver.getCurrentUrl();
	    String errorMessage = "❌ URL không đúng! (Thực tế: " + actualUrl + ")";
	    Assert.assertEquals(actualUrl, expectedUrl, errorMessage);
	    System.out.println("✅ URL hợp lệ: " + actualUrl);
	 }
	    
	 //Hàm kiểm tra Title
	 public void verifyTitle(String expectedTitle) {
	     String actualTitle = driver.getTitle();
	     String errorMessage = "❌ Title không đúng! (Thực tế: '" + actualTitle + "')";
	     Assert.assertEquals(actualTitle, expectedTitle, errorMessage);
	     System.out.println("✅ Title hợp lệ: " + actualTitle);
	 }
	    
	 // Hàm kiểm tra text của button
	 public void verifyButtonText(String xpath, String expectedText) {
	     WebElement button = driver.findElement(By.xpath(xpath));
	     String actualText = button.getText().trim();
	     // Kiểm tra text có đúng không
	     String errorMessage = "❌ Button text không đúng! (Thực tế: '" + actualText + "', Mong đợi: '" + expectedText + "')";
	     Assert.assertEquals(actualText, expectedText, errorMessage);
	     System.out.println("✅ Button text hiển thị đúng: " + actualText);
	  }
	    
	  //Hàm kiểm tra chữ nổi
	  public void verifyPlaceholder(String xpath, String expectedPlaceholder) {
	      WebElement element = driver.findElement(By.xpath(xpath));
	      String actualPlaceholder = element.getAttribute("placeholder").trim();
	      String errorMessage = "❌ Placeholder '" + expectedPlaceholder + "' không đúng! (Thực tế: '" + actualPlaceholder + "')";
	      Assert.assertEquals(actualPlaceholder, expectedPlaceholder, errorMessage);
	      System.out.println("✅ Placeholder '" + expectedPlaceholder + "' hiển thị đúng!");
	  }
	    
	  public void verifyErrorTextById(String id, String expectedErrorText) {
	      WebElement element = driver.findElement(By.id(id));
	      String actualText = element.getText().trim();
	      String errorMessage = "❌ Lỗi '" + expectedErrorText + "' không hiển thị đúng! (Thực tế: '" + actualText + "')";
	      Assert.assertEquals(actualText, expectedErrorText, errorMessage);
	      System.out.println("✅ Lỗi '" + expectedErrorText + "' hiển thị đúng!");
	  }
	  
	  // Hàm kiểm tra phần tử con DropdownList
	  public void verifyDropdownOptions(String dropdownXPath, String optionListXPath, List<String> expectedOptions) {
	      // Click vào dropdown để mở danh sách
	      WebElement dropdown = driver.findElement(By.xpath(dropdownXPath));
	      dropdown.click();
	      // Lấy danh sách các tùy chọn
	      List<WebElement> options = driver.findElements(By.xpath(optionListXPath));
	      List<String> actualOptions = new ArrayList<>();
	      for (WebElement option : options) {
	          actualOptions.add(option.getText().trim());
	      }
	      // So sánh danh sách thực tế với danh sách mong đợi
	      Assert.assertEquals(actualOptions, expectedOptions, "❌ Dropdown không chứa đúng các tùy chọn!");
	      System.out.println("✅ Dropdown chứa đúng các tùy chọn: " + actualOptions);
	   }
	    
	    // Hàm tạo mã ngành, tên ngành và tên viết tắt
	    public String generateUniqueString(String base) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ssmmHHddMMyyyy");
	        String timestamp = LocalDateTime.now().format(formatter);
	        return base + "-" + timestamp;
	    }
	    
	    // Hàm tạo ngành học mới
	    public void CreateAndFindNewMajor() throws InterruptedException {
	        String majorCode = generateUniqueString("id");
	        String majorName = generateUniqueString("name");
	        String shortName = generateUniqueString("T");
	        
	        driver.findElement(By.xpath("//*[@id=\"tblMajor_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click(); // Nhấp vào nút thêm ngành
	        Thread.sleep(1000);
	        WebElement codeInput = driver.findElement(By.id("id"));
	        WebElement nameInput = driver.findElement(By.id("name"));
	        WebElement shortNameInput = driver.findElement(By.id("abbreviation"));
	        
	        codeInput.sendKeys(majorCode);
	        nameInput.sendKeys(majorName);
	        shortNameInput.sendKeys(shortName);
	        driver.findElement(By.id("select2-program_type-container")).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(By.className("select2-results__option")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"major-form\"]/div[5]/button[2]")).click(); // Nhấp lưu
	        Thread.sleep(2000);
	        System.out.println("✔ Đã tạo ngành học: " + majorName + " (" + majorCode + ")");
	        // Tìm kiếm mã ngành vừa tạo
	        searchMajor(majorCode);
	        Thread.sleep(2000);

	        // Kiểm tra xem mã ngành có trong bảng hay không
	        boolean isPresent = isMajorPresent(majorCode);
	        if (isPresent) {
	            System.out.println("✔ Ngành học đã được thêm vào bảng: " + majorName + " (" + majorCode + ")");
	        } else {
	            System.out.println("❌ LỖI: Ngành học KHÔNG xuất hiện trong bảng sau khi tìm kiếm!");
	        }
	    }
	    
	 // Hàm tìm kiếm mã ngành
	 public void searchMajor(String majorCode) throws InterruptedException {
	     WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']")); // Ô tìm kiếm
	     searchBox.clear();
	     searchBox.sendKeys(majorCode);
	     Thread.sleep(1000); // Đợi kết quả hiển thị
	 }
	    
	 // Hàm kiểm tra mã ngành có trong bảng hay không
	 public boolean isMajorPresent(String majorCode) {
	     List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
	     for (WebElement row : rows) {
	          WebElement codeCell = row.findElement(By.cssSelector("td:nth-child(2)")); // Cột 2 chứa mã ngành
	          if (codeCell.getText().trim().equals(majorCode)) {
	             return true;
	          }
	      }
	      return false;
	  }
	    
	  // Hàm chọn số dòng hiển thị và đếm số dòng trong tbody
	  public void selectRowsPerPageAndCount(int rows) throws InterruptedException {
	  Select select = new Select(driver.findElement(By.name("tblMajor_length"))); // Tìm thẻ select
	  select.selectByValue(String.valueOf(rows)); // Chọn số dòng
	  Thread.sleep(2000); // Đợi bảng cập nhật

	  // Đếm số dòng hiển thị trong tbody
	  List<WebElement> rowsInTable = driver.findElements(By.cssSelector("tbody tr"));
	  int actualRowCount = rowsInTable.size();

	  System.out.println("✔ Đã chọn hiển thị " + rows + " dòng.");
	  System.out.println("✔ Số dòng thực tế trong bảng: " + actualRowCount);
	  }
	    
}