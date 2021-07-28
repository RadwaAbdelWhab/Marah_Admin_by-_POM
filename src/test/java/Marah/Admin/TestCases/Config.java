package Marah.Admin.TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import Bagisto.MarahAdmin.App;

public class Config extends App{
public Config() {
	super();
}

@BeforeSuite
public void start() {
	extent= new ExtentReports("F:\\workspace\\MarahAdmin\\TestReport\\index1.html");
	extent.addSystemInfo("os","windows");
}

@AfterSuite
public void end() {
	extent.flush();
	
}
}
