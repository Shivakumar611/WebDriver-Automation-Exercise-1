
/*Author:Shivakumar
 *Title:Automation scripts to automate various WebElements using JAVA
 * 
 */
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		AutomationDriver.exerciseOne(driver);
		AutomationDriver.exerciseTwo(driver);
		AutomationDriver.exerciseThree(driver);
		AutomationDriver.exerciseFour(driver);
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointtwo(driver);
		AutomationDriver.exerciseFive(driver);
		AutomationDriver.exerciseSix(driver);
		AutomationDriver.exerciseSeven(driver);
		AutomationDriver.exercisEight(driver);
		AutomationDriver.exerciseNine(driver);
	}


	/*
	 * MethodName:exerciseOne 
	 * ReturnType:Void 
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate Radio Buttons
	 */

	private static void exerciseOne(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://www.qaclickacademy.com/practice.php");

		driver.findElement(By.cssSelector("*[value='radio1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio1']")).isSelected());

		driver.findElement(By.cssSelector("input[value='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio2']")).isSelected());

		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio3']")).isSelected());

	}

	/*
	 * MethodName:exercisetwo 
	 * ReturnType:Void 
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate Suggestion Class
	 */

	private static void exerciseTwo(WebDriver driver) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("autocomplete")).sendKeys("Aus");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Australia")) {
				option.click();
				break;
			}
		}
		
	}

	/*
	 * MethodName:exerciseThree 
	 * ReturnType:Void 
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate DropDown
	 */

	private static void exerciseThree(WebDriver driver) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.name("dropdown-class-example")).click();
		driver.findElement(By.xpath("//option[@value='option1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("option[value='option2']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("option[value='option3']")).click();

	}

	/*
	 * MethodName:exerciseFour 
	 * ReturnType:Void 
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate CheckBox
	 */

	private static void exerciseFour(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("checkBoxOption1")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("checkBoxOption1")).click();

		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();

		driver.findElement(By.id("checkBoxOption3")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("checkBoxOption3")).click();
		Thread.sleep(1000);
	
	}
	
	/*
	 * MethodName:exerciseFourPointOne 
	 * ReturnType:Void 
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate CheckBox Select All
	 */

	public static void exerciseFourPointOne(WebDriver driver) {
	
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption2")).isSelected());
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption3")).isSelected());
	
	}

	/*
	 * MethodName:exerciseFourPointtwo 
	 * ReturnType:Void 
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate CheckBox DeSelect All
	 */

	private static void exerciseFourPointtwo(WebDriver driver) throws InterruptedException {
	
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption3")).isSelected());

	}

	/*
	 * MethodName:exercisefive 
	 * ReturnType:Void
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate Switch Window
	 */

	private static void exerciseFive(WebDriver driver) throws InterruptedException {
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("openwindow")).click();
		driver.manage().window().maximize();

		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String parentid = it.next();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(parentid);
		Thread.sleep(3000);
		
	}
	
	/*
	 * MethodName:exerciseSix 
	 * ReturnType:Void
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate Switch Tab
	 */
	
	private static void exerciseSix(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(2000);
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();

		String parent = it.next();
		String son = it.next();
		String daughter = it.next();
		Thread.sleep(2000);
		driver.switchTo().window(daughter);
		driver.close();
		driver.switchTo().window(parent);
	
	}
	
	/*
	 * MethodName:exerciseSeven 
	 * ReturnType:Void
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate Alert
	 */

	private static void exerciseSeven(WebDriver driver) throws InterruptedException {
	
		driver.findElement(By.id("name")).sendKeys("Automation");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("*[value='Alert']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();	
	
	}
	
	/*
	 * MethodName:exercisEight 
	 * ReturnType:Void
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate Mouse Hover and Select top
	 */
	
	private static void exercisEight(WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor javascrip = (JavascriptExecutor) driver;
		javascrip.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		javascrip.executeScript("document.querySelector('.tableFixHead').scrollBy(0,5000)");
		
	}
	
	/*
	 * MethodName:exerciseNine 
	 * ReturnType:Void
	 * ParameterCount:1
	 * ParameterType:WebDriver 
	 * Description:Method to Automate Mouse Hover and Select top
	 */
	
	private static void exerciseNine(WebDriver driver) throws InterruptedException {
	
		Actions a=new Actions(driver);
		Thread.sleep(3000);
		a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).click().build().perform();
		Thread.sleep(5000);
		a.moveToElement(driver.findElement(By.cssSelector("a[href='#top']"))).click().build().perform();
		
	}

}
