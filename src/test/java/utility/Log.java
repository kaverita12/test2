package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	public static Logger getlogData(String classname) {
		//logger=Logger.getLogger("EAAnswersHQ");
	//   PropertyConfigurator.configure("log4j.properties");
		return Logger.getLogger(classname);
		
	    
	}
	
	
}
