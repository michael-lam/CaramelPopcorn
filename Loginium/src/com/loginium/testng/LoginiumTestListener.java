package com.loginium.testng;

//import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoginiumTestListener extends TestListenerAdapter {

	// private final Level REPORT = Level.forName("REPORT", 350);
	private static Logger log = LogManager.getLogger();

	@Override
	public void onTestSuccess(ITestResult tr) {
		// logTestcaseDetail(tr);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		log.info(tr.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// logTestcaseDetail(tr);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		// logTestcaseDetail(tr);
	}

	@Override
	public void onConfigurationFailure(ITestResult tr) {
		log.info(tr.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// log.log(REPORT, "Test done!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//
		// BufferedReader br;
		// try {
		// br = Files.newBufferedReader(Paths.get("logs/Report_Loginium.log"));
		// String line = br.readLine();
		// while(line!=null){
		// log.info(line);
		// line = br.readLine();
		// }
		//
		// br.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// log.log(REPORT, "testContext.getAllTestMethods()
		// "+testContext.getAllTestMethods().length);
		// log.log(REPORT, "testContext.getName() "+testContext.getName());
		// log.log(REPORT, " "+testContext.getPassedTests().size());
		//
		// for (ITestResult tr : testContext.getPassedTests().getAllResults()) {
		// logTestcaseDetail(tr);
		// }
		//
		// testContext.getSuite();
		// log.log(REPORT, " "+testContext.getName());
		// log.log(REPORT, " "+testContext.getName());
		// log.log(REPORT, " "+testContext.getName());
		// log.log(REPORT, " "+testContext.getName());
		// log.log(REPORT, " "+testContext.getName());
		// log.log(REPORT, " "+testContext.getName());
		// log.log(REPORT, " "+testContext.getName());
		// log.log(REPORT, " "+testContext.getName());

	}

	// private void logTestcaseDetail(ITestResult tr) {
	// String tc = tr.getMethod().getMethodName();
	// String tl = tr.getTestClass().getName();
	// String result;
	// switch (tr.getStatus()) {
	// case 1:
	// result = "SUCCESS";
	// break;
	// case 2:
	// result = "FAILURE";
	// break;
	// case 3:
	// result = "SKIP";
	// break;
	// case 4:
	// result = "SUCCESS_PERCENTAGE_FAILURE";
	// break;
	// case 16:
	// result = "STARTED";
	// break;
	// default:
	// result = "UNKNOWN";
	// break;
	// }
	//
	// String duration = new DecimalFormat("0.000").format(((tr.getEndMillis() -
	// tr.getStartMillis()) / 1000.0));
	// log.log(REPORT,
	// String.format("Testcase: %s, Testclass: %s, Result: %s, Duration: %s",
	// tc, tl, result, duration));
	// }

}
