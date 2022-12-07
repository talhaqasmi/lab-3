package lab3p;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class lab3AT {
	WebDriver driver;
	@BeforeMethod
	public void site() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver"  , "C:\\Users\\4407\\Desktop\\SELINIUM\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://omayo.blogspot.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test(priority=0)
	public void field1() throws InterruptedException {
		WebElement text1=driver.findElement(By.id("ta1"));
		Thread.sleep(3000);
		text1.sendKeys("M Talha Tanveer Qasmi");
		String letters1=text1.getAttribute("value");
		System.out.println(letters1);
		Thread.sleep(3000);
		}
	@Test(priority=1)
	public void field2() throws InterruptedException {
		WebElement text2 = driver.findElement(By.cssSelector("#HTML11 > div.widget-content > textarea"));
		String letters=text2.getAttribute("value");
		System.out.println("Entered text is: " + letters);
		Thread.sleep(3000);
		text2.clear();
		WebElement description = driver.findElement(By.cssSelector("#HTML11 > div.widget-content > textarea"));
		Thread.sleep(3000);
		description.sendKeys("I am very passionate.");
		String letters3=description.getAttribute("value");
		System.out.println(letters3);
		Thread.sleep(3000);
		}
	@Test(priority=2)
	public void tableData() throws InterruptedException {
		List<WebElement> tablerows = driver.findElements(By.xpath("//*[@id='HTML30']")); 

		for (WebElement singlerow :tablerows ) { 
		    List<WebElement> smallbox = singlerow.findElements(By.tagName("div")); 
		    for (WebElement allTable : smallbox) {         
		    System.out.println("Data from the Table is:" +"\n"+allTable.getText());
		    Thread.sleep(3000);
		    }
		 }
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#HTML31 > div.widget-content > form > input[type=text]:nth-child(1)")).sendKeys("mtalhatanveer");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#HTML31 > div.widget-content > form > input[type=password]:nth-child(4)")).sendKeys("mttq1234");
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("#HTML31 > div.widget-content > form > button")).click();
	    Thread.sleep(3000);
	    System.out.println("logged in succeccfully");
	}
	@Test(priority=3)
	public void frames() throws InterruptedException {
		//WebElement scroll = driver.findElement(By.id("iframe1"));
		//Actions act = new Actions(driver);
		//act.dragAndDropBy(scroll, 200,500);
		String origional=driver.getWindowHandle();
		WebElement F1=driver.findElement(By.id("iframe1"));
		Thread.sleep(3000);
		driver.switchTo().frame(F1);
		Thread.sleep(3000);
		driver.switchTo().window(origional);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "omayo (QAFox.com)");
		WebElement F2=driver.findElement(By.id("iframe2"));
		Thread.sleep(3000);
		driver.switchTo().frame(F2);
		Thread.sleep(3000);
		driver.switchTo().window(origional);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "omayo (QAFox.com)");
		System.out.println("Frames Shifted succeccfully");
		}
	@Test(priority=4)
	public void frames_login() throws InterruptedException {
		driver.findElement(By.cssSelector("#HTML42 > div.widget-content > form > input[type=text]:nth-child(1)")).sendKeys("mtalhatanveer");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#HTML42 > div.widget-content > form > input[type=password]:nth-child(2)")).sendKeys("mttq1234");
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("#HTML42 > div.widget-content > form > input[type=button]:nth-child(3)")).click();
	    Thread.sleep(3000);
	    Alert myalert=driver.switchTo().alert();
	    myalert.accept();
	    Thread.sleep(3000);
	    Assert.assertEquals(driver.getTitle(), "omayo (QAFox.com)");
	    System.out.println("logged in succeccfully");
		}
	@Test(priority=5)
	public void dropDown() throws InterruptedException{
		WebElement dropp1=driver.findElement(By.cssSelector("#HTML14 > div.widget-content"));
		Actions drp1=new Actions(driver);
		drp1.moveToElement(dropp1).perform();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#multiselect1 > option:nth-child(3)")).click();
		Thread.sleep(3000);
		WebElement dropp2=driver.findElement(By.cssSelector("#HTML1 > div.widget-content"));
		dropp2.click();
		Thread.sleep(3000);
		Actions drp2=new Actions(driver);
		drp2.moveToElement(dropp2).perform();
		driver.findElement(By.cssSelector("#ironman4")).click();
		Thread.sleep(3000);
		WebElement text2preLoadText = driver.findElement(By.id("textbox1"));
		text2preLoadText.clear();
		Thread.sleep(3000);
		text2preLoadText.sendKeys("Hello World");
		String newWords=text2preLoadText.getAttribute("value");
		System.out.println(newWords);
		Thread.sleep(3000);
		driver.findElement(By.id("but2")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#HTML10 > div.widget-content > button:nth-child(1)")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#HTML10 > div.widget-content > button:nth-child(2)")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#HTML10 > div.widget-content > button:nth-child(3)")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("alert2")).click();
		Thread.sleep(3000);
		Alert alert2=driver.switchTo().alert();
		Thread.sleep(3000);
	    alert2.accept();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "omayo (QAFox.com)");
		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
		Thread.sleep(3000);
		//handling popup window
		Set<String> window=driver.getWindowHandles();
		Iterator it=window.iterator();
		String parentWindow=(String) it.next();
		String childWindow=(String) it.next();
		driver.switchTo().window(childWindow);
		WebElement para1 = driver.findElement(By.xpath("//p[@id='para1']"));
		System.out.println(para1.getText());
		Thread.sleep(3000);
		WebElement para2 = driver.findElement(By.xpath("//p[@id='para2']"));
		System.out.println(para2.getText());
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentWindow);
		Thread.sleep(4000);
		//clicking on try it button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(4000);
		//double clicking
		Actions act = new Actions(driver);
		WebElement doubleClick = driver.findElement(By.xpath("//button[text()=' Double click Here   ']")); 
		act.doubleClick(doubleClick ).perform();
		Thread.sleep(4000);
		//handling alert
		Alert alert3=driver.switchTo().alert();
		Thread.sleep(3000);
	    alert3.accept();
		Thread.sleep(3000);
		//checkbox
		driver.findElement(By.xpath("//button[text()='Check this']")).click();
		Thread.sleep(11000);
		driver.findElement(By.id("dte")).click();
		Thread.sleep(3000);
		}
	@Test(priority=6)
	public void bioData() throws InterruptedException {
		driver.findElement(By.id("radio1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("alert1")).click();
		Thread.sleep(3000);
		//handling alert
		Alert alert4=driver.switchTo().alert();
		Thread.sleep(3000);
	    alert4.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='checkbox1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='checkbox2']")).click();
		Thread.sleep(3000);
		//getting text from Readonly TextBox
		WebElement readBox = driver.findElement(By.xpath("//*[@id='rotb']"));
		String text3=readBox.getAttribute("value");
		System.out.println("Entered text is: " + text3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='prompt']")).click();
		Thread.sleep(3000);
		//handling alert and sending data
		driver.switchTo().alert().sendKeys("M Talha Tanveer Qasmi");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		//filling textbox 1
		WebElement box1 = driver.findElement(By.cssSelector("#HTML24 > div.widget-content > input"));
		Thread.sleep(3000);
		box1.sendKeys("I am very passionate.");
		Thread.sleep(5000);
		//filling textbox 1
	    WebElement box2 = driver.findElement(By.cssSelector("#HTML28 > div.widget-content > input"));
		Thread.sleep(3000);
		box2.sendKeys("cureMD organization");
		Thread.sleep(5000);
		//selecting car
		driver.findElement(By.xpath("//*[@value='Car']")).click();
		Thread.sleep(3000);
		//selecting bag
		driver.findElement(By.xpath("//*[@value='Bag']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@value='Book']")).click();
		Thread.sleep(3000);
		//doubleclicking on double click
		Actions dblClick = new Actions(driver);
		WebElement doubleClick = driver.findElement(By.xpath("//p[text()='Double-click']"));  
		dblClick.doubleClick(doubleClick ).perform();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		Thread.sleep(3000);	
	}
	@AfterMethod
	public void closetab() {
		driver.close();
	}
		
}
