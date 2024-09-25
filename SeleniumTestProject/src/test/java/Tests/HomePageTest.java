package Tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.HomePage;
import Page.SummitRegisterPage;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomePageTest  {
	private WebDriver driver;	
	private HomePage homepage;
    private SummitRegisterPage registerpage;
    
    
    @BeforeMethod
    public void setUp() {
    	driver=new ChromeDriver(); //launch Chrome browser
		driver.manage().window().maximize(); //Maximize the Chrome browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //added wait to WebElements
		driver.get("https://www.entrata.com/");//Navigate to website url
        homepage = new HomePage(driver);
        registerpage = new SummitRegisterPage(driver);
        homepage.acceptCookies();
    }
    
    @AfterMethod
    public void tearDown() {
		if(driver!=null) {
			driver.quit(); //close chrome browser all instances
		}
    }
    /**
     * Test to verify the page subtitle after navigation.
     */
	@Test(priority = 1)
	public void verifyHomePageSubtitle() 
	{
		String subTitle=homepage.getHomePageSubTitle();
		Assert.assertEquals(subTitle, "Property management software");
	}
	
	 
	/**
     * Test to navigate to 'watch demo' page
     */
	
	@Test(priority = 2)
	public void navigateToWatchDemo() 
	{
		homepage.clickWatchDemo();
		String header=homepage.getWatchDemoHeader();
		Assert.assertEquals(header, "Optimize Property Management with One Platform");
	}
	
	/**
     * Test to navigate to 'summit register form' and fill the details
	 * @throws InterruptedException 
     */
	
	@Test(priority = 3)
	public void fillSummitRegisterForm() 
	{
		//Navigate to summit register form
		homepage.clickSummit();
		homepage.switchToWindow(1);
		homepage.clickRegister();
		homepage.switchToWindow(2);
	
		//Set values in register form
		registerpage.setLastName("Last Name");
		registerpage.setCompanyName("company Name");
		registerpage.setEmail("Test@gmail.com");
		
		// Assertion to verify the input value
		Assert.assertEquals(registerpage.getlastNameValue(),"Last Name");
        Assert.assertEquals(registerpage.getCompanyValue(),"company Name");
        Assert.assertEquals(registerpage.getEmailValue(), "Test@gmail.com");
        
    }
}
	

