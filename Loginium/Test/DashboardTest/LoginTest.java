package DashboardTest;

import java.net.MalformedURLException;

import org.testng.annotations.Test;
import TADashboardPages.LoginPage;

public class LoginTest extends TestBase{

	@Test
	public void Login1() throws MalformedURLException, InterruptedException
	{
		LoginPage loginPage = LoginPage.init();		
		Thread.sleep(1000);
		loginPage.loginWithValidAccount("administrator", "", "SampleRepository");	
	}
//	
//	@Test
//	public void Login2() throws InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();		
//		loginPage.loginWithInValidAccount("administrator", "1", "TestRepository");		
//		Thread.sleep(2000);
//	}
//	
//	@Test
//	public void Login3() throws MalformedURLException, InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();		
//		loginPage.loginWithValidAccount("administrator", "", "SampleRepository");	
//		Thread.sleep(1500);
//	}
//	
//	@Test
//	public void Login4() throws InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();		
//		Thread.sleep(3000);
//		loginPage.loginWithInValidAccount("administrator", "1", "TestRepository");		
//	}
//	
//	@Test
//	public void Login5() throws MalformedURLException, InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();		
//		Thread.sleep(5000);
//		loginPage.loginWithValidAccount("administrator", "", "SampleRepository");	
//	}
//	
//	@Test
//	public void Login6() throws InterruptedException
//	{
//		Thread.sleep(1500);
//		LoginPage loginPage = LoginPage.init();		
//		loginPage.loginWithInValidAccount("administrator", "1", "TestRepository");		
//	}
//	
//	@Test
//	public void Login7() throws MalformedURLException, InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();	
//		Thread.sleep(4000);
//		loginPage.loginWithValidAccount("administrator", "", "SampleRepository");	
//	}
//	
//	@Test
//	public void Login8() throws InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();		
//		loginPage.loginWithInValidAccount("administrator", "1", "TestRepository");		
//		Thread.sleep(3500);
//	}
//	
//	@Test
//	public void Login9() throws MalformedURLException, InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();		
//		Thread.sleep(2000);
//		loginPage.loginWithValidAccount("administrator", "", "SampleRepository");	
//	}
//	
//	@Test
//	public void Login10() throws InterruptedException
//	{
//		LoginPage loginPage = LoginPage.init();		
//		Thread.sleep(2500);
//		loginPage.loginWithInValidAccount("administrator", "1", "TestRepository");		
//	}
	
	
}
