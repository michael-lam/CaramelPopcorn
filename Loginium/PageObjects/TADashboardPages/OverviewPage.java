package TADashboardPages;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OverviewPage {
	private static OverviewPage instance;
	private static ApplicationContext context;
	
	public static synchronized OverviewPage init() {
		if (instance == null) {
			context = new ClassPathXmlApplicationContext(
					new String[] { "TADashboardResources/OverviewPage.xml"});
			instance = (OverviewPage) context.getBean("OverviewPage");
		}
		return instance;
	}
	
	
}
