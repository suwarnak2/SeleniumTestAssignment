package Page;


import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//HomePage WebElements
	By btnAcceptCookies = By.xpath("//*[@id='cookie-accept']");
	By txtSubtitle=By.xpath("//div[text()='Property management software']");
	By lnkRegister=By.xpath("//a[text()='Register Now']");
	By btnWatchDemo=By.xpath("//div[text()='Watch Demo']");
	By txtHeader=By.xpath("//h1[contains(text(),'Optimize Property')]");
	By lnkSummit = By.xpath("//a[text()='Summit']");
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));	
	}
	
	//Click on WebElement using java script
	private void click(WebElement element) 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
	
	//Accept cookies for Website
	public void acceptCookies() 
	{
	     WebElement button = wait.until(ExpectedConditions.elementToBeClickable(btnAcceptCookies));
	     button.click();
	}
	 
	//Switch to multiple tabs using index
	public void switchToWindow(int index)
	{
	      ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	      driver.switchTo().window(tabs.get(index));
	}
	
	//Get HomePage subtitle
	public String getHomePageSubTitle()
	{
		return driver.findElement(txtSubtitle).getText();	 
	}
	
	//Click on 'Summit' link
	public void clickSummit()
	{
		WebElement link = driver.findElement(lnkSummit);
		click(link);
	}
	
	//Click on 'Watch Demo' button
	public void clickWatchDemo()
	{
		WebElement button = driver.findElement(btnWatchDemo);
        click(button);
	}
	
	//Get 'Watch Demo' page header
	public String getWatchDemoHeader()
	{
		return driver.findElement(txtHeader).getText();
	}
	
	//Click on Register link
	public void clickRegister()
	{
		driver.findElement(lnkRegister).click();
	}

}
