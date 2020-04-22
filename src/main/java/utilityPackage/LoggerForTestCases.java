package utilityPackage;

import java.util.logging.Logger;

public class LoggerForTestCases {
	
	 private static Logger Log = Logger.getLogger(LoggerForTestCases.class.getName());
	 
	 public static void info(String message) {
		 Log.info(message);
		 }
	 public static void warn(String message) {
		 Log.warning(message);
		 }
	}
