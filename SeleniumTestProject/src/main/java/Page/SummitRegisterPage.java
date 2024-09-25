package Page;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SummitRegisterPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//SummitRegisterForm  WebElements
	By firstName=By.xpath("//input[@aria-label='First name']");
	By lastName=By.xpath("//input[@aria-label='Last name']");
	By companyName=By.xpath("//input[@aria-label='Company']");
	By email=By.xpath("//input[@aria-label='Email Address']");
	
	
	public SummitRegisterPage(WebDriver driver) 
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(60));	
	}
	
	// Scroll into view using JavaScriptExecutor
	private void scrollIntoView(WebElement element) 
	{
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	//Set value for First Name field
	public void setFirstName(String fname) 
	{
		scrollIntoView(driver.findElement(firstName));
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(firstName));
     	field.clear();
     	field.sendKeys(fname);
	}
	
	//Set value for Last Name field
	public void setLastName(String lname)
	{
		scrollIntoView(driver.findElement(lastName));
	 	WebElement field = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        field.clear();
        field.sendKeys(lname);
	}
	
	//Set value for company Name field
	public void setCompanyName(String compname)
	{
		scrollIntoView(driver.findElement(companyName));
	 	WebElement field = wait.until(ExpectedConditions.elementToBeClickable(companyName));
        field.clear();
        field.sendKeys(compname);
	}
	
	//Set value for Email field
	public void setEmail(String mail)
	{
		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		field.click();
	    field.clear(); 
		field.sendKeys(mail);
	}
	
	//Get entered value for First Name field
	public String getfirstNameValue()
	{
		return driver.findElement(firstName).getAttribute("value");
	}
	
	//Get entered value for Last Name field
	public String getlastNameValue()
	{
		return driver.findElement(lastName).getAttribute("value");
	}
	
	//Get entered value of Company Name field
	public String getCompanyValue()
	{
		return driver.findElement(companyName).getAttribute("value");
	}
	
	//Get entered value of Email field
	public String getEmailValue()
	{
		return driver.findElement(email).getAttribute("value");
	}
	

}
