package Day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {

   public WebDriver sp;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		sp=new ChromeDriver();
		
		sp.manage().window().maximize();
		
		sp.manage().deleteAllCookies();
		
		sp.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@Test
	public void tc1()
	{
		String ActualURL="https://rahulshettyacademy.com/AutomationPractice/";
		
		String ActualTitle="Practice Page";
		
		String url= sp.getCurrentUrl();
		
		System.out.println("Current URL is :"+url);
		
		Assert.assertEquals(ActualURL, url);
		
		String title=sp.getTitle();
		
		System.out.println("Current Title Page is :"+title);
		
		Assert.assertEquals(ActualTitle, title);
		
	}
	
	@Test
	public void tc2() throws InterruptedException
	{
		WebElement radio2=sp.findElement(By.xpath("//input[contains(@value,'radio2')]"));
		
		radio2.click();
		
		boolean b2=radio2.isSelected();
		
		System.out.println("Is Radio button2 Selected ?"+b2);
		
		Thread.sleep(3000);
		
		TakesScreenshot tk2=(TakesScreenshot)sp;
		
		File src2=tk2.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src2, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//Radio2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc3() throws InterruptedException
	{
		WebElement dropDown=sp.findElement(By.xpath("//select[contains(@id,'dropdown-class-example')]"));
		
		Select s=new Select(dropDown);
		
		s.selectByVisibleText("Option2");
		
		Thread.sleep(3000);
		
		TakesScreenshot tk3=(TakesScreenshot)sp;
		
		File src3=tk3.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src3, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//DropDownOption2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void tc4() throws InterruptedException
	{
		WebElement CheckBox2=sp.findElement(By.xpath("//input[contains(@value,'option2')]"));
		
		CheckBox2.click();
		
		CheckBox2.isSelected();
		
		Thread.sleep(3000);
		
		TakesScreenshot tk4=(TakesScreenshot)sp;
		
		File src4=tk4.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src4,new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//SSCheckBox2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc5() throws InterruptedException
	{
		WebElement TextBox=sp.findElement(By.xpath("//input[contains(@id,'name')]"));
		
		TextBox.sendKeys("Yogesh");
		
		Thread.sleep(3000);
		
		sp.findElement(By.xpath("//input[contains(@id,'alertbtn')]")).click();
		
		Thread.sleep(3000);
		
		Alert a=sp.switchTo().alert();
		
		a.accept();
		
		Thread.sleep(3000);
	
		TextBox.sendKeys("Mane Yogesh");
		
		Thread.sleep(3000);

		sp.findElement(By.xpath("//input[contains(@id,'confirmbtn')]")).click();
		
		Thread.sleep(3000);
		
		Alert aa=sp.switchTo().alert();
		
		aa.dismiss();
	}
			
	
	@Test
	public void tc6()
	{
		List<WebElement>tg=sp.findElements(By.tagName("a"));
		
		int totalNoLink=tg.size();
		
		System.out.println("Total Number of Links are :"+totalNoLink);
		
		for(WebElement tgtx:tg)
		{
			String txtTgName=tgtx.getText();
			
			System.out.println("Links are as follows :"+txtTgName);
			
		}
		
	}
	
	
	@Test
	public void tc7() throws InterruptedException
	{
		JavascriptExecutor js7=(JavascriptExecutor)sp;
		
		js7.executeScript("window.scrollBy(0,550)");
		
		Thread.sleep(3000);
		 
		WebElement tx=sp.findElement(By.xpath("//input[contains(@id,'displayed-text')]"));
		
		tx.sendKeys("Yogesh Mane");
		
		sp.findElement(By.xpath("//input[contains(@id,'hide-textbox')]")).click();
		
		Boolean b7=tx.isDisplayed();
		
		System.out.println("Is text box field WebElement displayed? :"+b7);
		
		Thread.sleep(3000);
		
		sp.findElement(By.xpath("//input[contains(@id,'show-textbox')]")).click();
		
		Boolean b8=tx.isDisplayed();
	
		System.out.println("After Clicking on Show button is Text field displayed ? :"+b8);
		
		TakesScreenshot tk7=(TakesScreenshot)sp;
		
		File src7=tk7.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src7, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//Show-HideDisplayed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc8() throws InterruptedException
	{
		JavascriptExecutor js8=(JavascriptExecutor)sp;
		
		js8.executeScript("window.scrollBy(0,1350)");
		
		Thread.sleep(3000);
		
		WebElement frm=sp.findElement(By.xpath("//iframe[contains(@id,'courses-iframe')]"));
		
		sp.switchTo().frame(frm);
		
		Thread.sleep(3000);
		
		JavascriptExecutor js9=(JavascriptExecutor)sp;
		
		js9.executeScript("window.scrollBy(0,750)");
		
		Thread.sleep(3000);
		
		TakesScreenshot tk8=(TakesScreenshot)sp;
		
		File src8=tk8.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src8, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//ScrollingToFrameInFrame.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void tc9() throws InterruptedException
	{
		sp.findElement(By.xpath("//input[contains(@id,'autocomplete')]")).sendKeys("Ir");
		
		Thread.sleep(3000);
		
		List<WebElement>sug=sp.findElements(By.xpath("//li[contains(@class,'ui-menu-item')]"));
		
		int sugNo=sug.size();
		
		System.out.println("Total Number of Suggestions are :"+sugNo);
		
		for(WebElement autoSug:sug)
		{
			
			String txt= autoSug.getText();
			
			System.out.println("Autosuggestion are :"+txt);
			
			if(txt.contentEquals("Iran (Islamic Republic of)"))
			{
				autoSug.click();
				
				Thread.sleep(3000);
			}
		}
		
		TakesScreenshot tk9=(TakesScreenshot)sp;
		
		File src9=tk9.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src9, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//AutoSuggestionIRAN.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		sp.quit();
	}
	
}
