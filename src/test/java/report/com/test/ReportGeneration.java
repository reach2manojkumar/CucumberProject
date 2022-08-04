package report.com.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportGeneration {
	
	
	
	public static void reportTestCase(String jsonreport) {
		// TODO Auto-generated method stub
		// mention the file path of jvm report
		File f = new File(System.getProperty("user.dir") + "\\report.com\\JVMreport");
		// add configuration
		Configuration c= new Configuration(f, "project");
		c.addClassifications("Platform","Windows");
		c.addClassifications("JDK Version","1.8");
		c.addClassifications("Sprint ", "10");
		
		
		//Add Json file path into Lsit <String >
		List<String> l=new ArrayList<String>();
		l.add(jsonreport);
		
		
		//report generation 
		ReportBuilder r=new ReportBuilder(l,c);
		r.generateReports();
		
	}

	

}
