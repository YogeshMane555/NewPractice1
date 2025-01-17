package Day1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test1 {
	
	public WebDriver sp;

	@BeforeTest
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
		String expectedTitle="Practice Page";
		
		String Actualtitle=sp.getTitle();
		
		System.out.println("Title of Webpage is :"+Actualtitle);
		
		Assert.assertEquals(Actualtitle, expectedTitle);
		
		
		String expectedURL="https://rahulshettyacademy.com/AutomationPractice/";
		
		String ActualURL=sp.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, expectedURL);
		
		System.out.println("Current URL is :"+ActualURL);
	}
	
	@Test
	public void tc2()
	{
		WebElement Radio1=sp.findElement(By.xpath("//input[contains(@value,'radio3')]"));
		
		Radio1.click();
		
		Boolean b1=Radio1.isSelected();
		
		System.out.println("Is Radio button 3 Selected ?:"+b1);
			
		Assert.assertTrue(true);
	}
	
	@Test
	public void tc3()
	{
		WebElement DropDown=sp.findElement(By.xpath("//select[contains(@id,'dropdown-class-example')]"));
		
		Select s=new Select(DropDown);
		
		s.selectByVisibleText("Option3");
		
		TakesScreenshot tk3=(TakesScreenshot)sp;
		
		File src3=tk3.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src3, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//DropDown.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void tc4()
	{
		WebElement checkBox3=sp.findElement(By.xpath("//input[contains(@id,'checkBoxOption3')]"));
		
		checkBox3.click();
		
		Boolean b4=checkBox3.isSelected();
		
		System.out.println("Is Checkbox 3 selected ?:"+b4);
		
		Assert.assertTrue(true);
		
		TakesScreenshot t4=(TakesScreenshot)sp;
		
		File src4=t4.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src4, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//CheckBox3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void tc5() throws InterruptedException
	{
		JavascriptExecutor js5=(JavascriptExecutor)sp;
		
		js5.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		WebElement textBox=sp.findElement(By.xpath("//input[contains(@name,'show-hide')]"));
		
		textBox.sendKeys("YOGESH");
		
		sp.findElement(By.xpath("//input[contains(@id,'hide-textbox')]")).click();
		
		sp.findElement(By.xpath("//input[contains(@id,'show-textbox')]")).click();
		
		Boolean b5=textBox.isDisplayed();
		
		System.out.println("Is Textbox visible ?:"+b5);
		
	}
		
	@Test
	public void tc6() throws InterruptedException
	{
		WebElement AlertText= sp.findElement(By.xpath("//input[contains(@id,'name')]"));
		
		AlertText.sendKeys("Yogesh Mane");
		
		Thread.sleep(3000);
		
		sp.findElement(By.xpath("//input[contains(@id,'alertbtn')]")).click();
		
		Alert a=sp.switchTo().alert();
		
		a.accept();	
		
		Thread.sleep(3000);
		
		AlertText.sendKeys("Mane Yogesh");
		
		Thread.sleep(3000);
		
		sp.findElement(By.xpath("//input[contains(@id,'confirmbtn')]")).click();
		
		Alert aa=sp.switchTo().alert();
		
		aa.dismiss();
	}
	
	@Test
	public void tc7()
	{
		List<WebElement> tg=sp.findElements(By.tagName("a"));
		
		int totalNumberOfTag=tg.size();
		
		System.out.println("Total Number of Tags are :"+totalNumberOfTag);
		
		for(WebElement texttg:tg)
		{
			String tagName=texttg.getText();
			
			System.out.println("Tag Names are :"+tagName);
		}
		
	}
	
	
	@Test
	public void tc8() throws InterruptedException
	{
		JavascriptExecutor js8=(JavascriptExecutor)sp;
		
		js8.executeScript("window.scrollBy(0,1350)");
		
		WebElement frame=sp.findElement(By.xpath("//iframe[contains(@id,'courses-iframe')]"));
		
		sp.switchTo().frame(frame);
		
		Thread.sleep(3000);
		
		JavascriptExecutor js9=(JavascriptExecutor)sp;
		
		js9.executeScript("window.scrollBy(0,650)");
		
		Thread.sleep(3000);
		
		TakesScreenshot tk8=(TakesScreenshot)sp;
		
		File src8=tk8.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src8, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//Frame.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void tc9() throws InterruptedException
	{
		WebElement AutoSugText=sp.findElement(By.xpath("//input[contains(@id,'autocomplete')]"));
		
		AutoSugText.sendKeys("IN");
		
		Thread.sleep(3000);
		
		List<WebElement> auto=sp.findElements(By.xpath("//li[contains(@class,'ui-menu-item')]"));
		
		int autoNumber=auto.size();
		
		System.out.println("Total Number of Autosuggestions are :"+autoNumber);
		
		for(WebElement autoText:auto)
		{
			String AutuSuggestion =autoText.getText();
			
			System.out.println("Automation Text are :"+AutuSuggestion);
			
			if(AutuSuggestion.contentEquals("Finland"))
			{
				autoText.click();
				
				Thread.sleep(3000);
			}
		}
		
		TakesScreenshot tk9=(TakesScreenshot)sp;
		
		File src9=tk9.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src9, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//AutoSuggestion.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void tc10() throws InterruptedException
	{
		Set<String>s=sp.getWindowHandles();
		
		Iterator<String>ss=s.iterator();
		
		String Parent=ss.next();
				
		sp.switchTo().window(Parent);
		
		sp.findElement(By.xpath("//button[contains(@id,'openwindow')]")).click();
		
		Thread.sleep(3000);
		
		String ActualTitle="QAClick Academy - A Testing Academy to Learn, Earn and Shine";
		
		String NewWindTitle=sp.getTitle();
		
		System.out.println("New Window Title is :"+NewWindTitle);
		
		Assert.assertEquals(ActualTitle, NewWindTitle);
				
		TakesScreenshot tk10=(TakesScreenshot)sp;
		
		File src10=tk10.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src10, new File("C://Users//yogemane//eclipse-workspace//NewPractice//TakesScreenshot//NewWindow.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		sp.quit();
	}
	
}
