package Reporting;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class Reporter {
	
	private static ExtentReports Extent;
	
	public static ExtentReports getInsatance() {
		
		if(Extent==null) {
			Date d=new Date();
			String FileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			Extent=new ExtentReports("D:\\ExtentReports\\"+FileName,true);
			
			Extent.loadConfig(new File(System.getProperty("user.dir")+"\\ReportsConfig.xml"));
			Extent.addSystemInfo("Selenium Version", "Selenium 3.12");
			Extent.addSystemInfo("Environment","Testing");
		}
		


		
return Extent;
	}

}
