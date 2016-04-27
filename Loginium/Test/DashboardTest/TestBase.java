package DashboardTest;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.loginium.driver.DriverManager;
import com.loginium.driver.DriverSetting;
import com.loginium.testng.LoginiumTestListener;

@Listeners(LoginiumTestListener.class)
@Test
public abstract class TestBase {
	
	private static ApplicationContext context;
	protected DriverSetting driverSetting;
	
	@BeforeSuite
	public void beforeSuite() {
			context = new ClassPathXmlApplicationContext("BrowserSetting.xml");
	}

	@Parameters({ "driverSettingID" })
	@BeforeMethod
	public void beforeMethod(String driverSettingID) throws MalformedURLException, UnexpectedException {
		driverSetting = (DriverSetting) context.getBean(driverSettingID);
		DriverManager.createWebDriver(driverSetting);
//		DriverManager.getWebDriver().manage().window().maximize();
		DriverManager.getWebDriver().get("http://192.168.171.236/TADashboard/login.jsp");
	}

	@AfterMethod
	public void afterMethod(ITestResult tr) {		
		DriverManager.getWebDriver().quit();
	}
}
