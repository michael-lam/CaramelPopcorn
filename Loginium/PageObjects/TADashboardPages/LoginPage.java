package TADashboardPages;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.loginium.element.Element;
import com.loginium.element.SelectElement;

public class LoginPage {
	private static LoginPage instance;
	private static ApplicationContext context;

	@Resource(name = "cbxRepository")
	private SelectElement cbxRepository;
	
	@Resource(name = "txtUsername")
	private Element txtUsername;

	@Resource(name = "txtPassword")
	private Element txtPassword;

	@Resource(name = "btnLogin")
	private Element btnLogin;

	public static LoginPage init() {
		if (instance == null) {
			context = new ClassPathXmlApplicationContext(
					new String[] { "TADashboardResources/LoginPage.xml"});
			instance = (LoginPage) context.getBean("LoginPage");
		}
		return instance;		
	}
	
	public OverviewPage loginWithValidAccount(String username, String password, String repository)
	{
		submitLoginForm(username, password, repository);
		return OverviewPage.init();
	}
	
	public LoginPage loginWithInValidAccount(String username, String password, String repository)
	{
		submitLoginForm(username, password, repository);
		return LoginPage.init();
	}
		
	private void submitLoginForm(String username, String password, String repository)
	{
		cbxRepository.selectByVisibleText(repository);
		txtUsername.type(username);
		txtPassword.type(password);
		btnLogin.click();
	}
}
