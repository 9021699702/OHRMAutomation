package com.OHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTest {


public WebDriver driver = new ChromeDriver();

private WebElement actualmsg;
@Test
  public void Login() throws InterruptedException {
	 driver.manage().window().maximize();
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  
		
		//Identify Title
				String exptitle = "OrangeHRM";
				String acttitle = driver.getTitle();
				Assert.assertEquals(acttitle, exptitle);
				
				// login Function
				driver.findElement(By.name("username")).sendKeys("Admin");
			 	 driver.findElement(By.name("password")).sendKeys("admin123");
				 driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
				 Thread.sleep(2000);
				 
		   
		}
  @Test
  public void forgotpass() {
	 
	   driver.findElement(By.xpath("//div[@id='forgotPasswordLink']/a")).click();
		actualmsg = null;
		String actual=actualmsg.getText();
		System.out.println("Actual message:"+actual);
		
		String expected="Forgot your password?";
		
		if(actual.equals(expected))
		{
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		

	  
  }
  
  @Test
  public void search() {
	  WebElement search = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input"));
		search.sendKeys("PIM");
		WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span"));
		searchResult.click();

	  
  }
	@Test
	public void pim(){		
				
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")).sendKeys("PIM");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")).click();
				
		}
	@Test
	public void addemployee(){
				
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
	driver.findElement(By.name("firstName")).sendKeys("PP");
	driver.findElement(By.name("lastName")).sendKeys("Desai");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
			
		}
		
	@Test
	public void directory() {
	driver.findElement(By.xpath("*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]")).click();
	driver.findElement(By.xpath("*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]/button/i")).click();
	driver.findElement(By.xpath("*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("pp");
	driver.findElement(By.xpath("*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")).click();
	 WebElement job = driver.findElement(By.xpath("*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
	Actions act1 = new Actions(driver);
	act1.moveToElement(job).click().perform();
	}
				
	@Test	
	public void leave() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/leave");
		
		WebElement apply = driver.findElement(By.xpath("//a[@id='menu_leave_applyLeave']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(apply).click().perform();
		// to select the leave type
		WebElement leaveType = driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
		Select sel=new Select(leaveType);
		sel.selectByVisibleText("US - Personal");
		Thread.sleep(3000);
		// to print the leave balance
		WebElement balance = driver.findElement(By.xpath("//div[@id=\'applyleave_leaveBalance\']"));
		String leaves=balance.getText();
		System.out.println(leaves.substring(0,1));
		// to enter from,to and comment, click on apply
		WebElement fromDate = driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
		fromDate.click();
		fromDate.sendKeys("2020-11-24");
		Actions act2=new Actions(driver);
		act2.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		
		WebElement toDate= driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
		act2.sendKeys(Keys.TAB).perform();
		toDate.click();
		toDate.clear();
		act2.sendKeys("2020-11-28").perform();
		toDate.sendKeys("2020-11-28");
		act2.sendKeys(Keys.ESCAPE).perform();
		
		
		WebElement leaveComment = driver.findElement(By.xpath("//textarea[@id='applyleave_txtComment']"));
		leaveComment.sendKeys("Please approve leave ASAP");
		
		WebElement applyButton = driver.findElement(By.xpath("//input[@id='applyBtn']"));
		applyButton.click();
		
		Thread.sleep(3000);
		
			}
	@Test
	public void timsheet() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/timesheet");
		
  WebElement time = driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']/b"));
		Actions act=new Actions(driver);
		act.moveToElement(time).perform();
		
		WebElement timeSheets = driver.findElement(By.xpath("//a[@id='menu_time_Timesheets']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(timeSheets).click().perform();
		WebElement mytimeSheets = driver.findElement(By.xpath("//a[@id='menu_time_viewMyTimesheet']"));
		act1.moveToElement(mytimeSheets).click().perform();
		
		
		WebElement sheetWeek = driver.findElement(By.xpath("//select[@id='startDates']"));
		Select sel=new Select(sheetWeek);
		sel.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement status = driver.findElement(By.xpath("//*[@id=\"timesheet_status\"]/h2"));
		System.out.println(status.getText());
		
		// to edit and add
		WebElement edit = driver.findElement(By.xpath("//input[@id='btnEdit']"));
		edit.click();
		Thread.sleep(3000);
		
		WebElement row = driver.findElement(By.xpath("//input[@id='initialRows_0_projectName']"));
		row.clear();
		row.sendKeys("gl");
		
		String searchText = "Global Corp and Co - Global Software phase - 1";
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div[4]"));

		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		Thread.sleep(3000);
		for (WebElement option : options)
		{
		    if (option.getText().equals(searchText))
		    {
		        option.click(); 
		        break;
		    }
		}
		
		
		Thread.sleep(4000); 	
		WebElement activity = driver.findElement(By.xpath("//select[@id='initialRows_0_projectActivityName']"));
		Select sel1=new Select(activity);
		sel1.selectByValue("7");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='initialRows_0_0']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_1']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_2']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_3']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_4']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_5']")).sendKeys("0:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_6']")).sendKeys("0:00");
		
		driver.findElement(By.xpath("//input[@id='submitSave']")).click();
		
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		
		Thread.sleep(3000);
		
		WebElement newstatus = driver.findElement(By.xpath("//*[@id=\"timesheet_status\"]/h2"));
		System.out.println(newstatus.getText());
		
	}
	
	@Test
	public void contactinfo() throws InterruptedException {
		WebElement myInfo = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b"));
		myInfo.click();
		
		WebElement oldName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
		System.out.println(oldName.getText());
		
		WebElement editBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
		editBtn.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
		firstName.clear();
		firstName.sendKeys("Michael");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
		lastName.clear();
		lastName.sendKeys("Jhulelal");
		
		WebElement dob = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
		dob.clear();
		dob.sendKeys("1998-12-17");
		
		WebElement saveBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
		saveBtn.click();
		
		Thread.sleep(4000);
		
		WebElement newName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
		System.out.println(newName.getText());
		
		Thread.sleep(3000);
		
	}
  }

