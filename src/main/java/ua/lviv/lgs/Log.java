package ua.lviv.lgs;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {

	// Initialize Log4j instance
	private static Logger Log = Logger.getLogger(Log.class);

	// Info Level Logs
	public static void info(String message) {
		BasicConfigurator.configure();
		Log.info(message);
	}
	

	// Warn Level Logs
	public static void warn(String message) {
		BasicConfigurator.configure();

		Log.warn(message);
	}

	// Error Level Logs
	public static void error(String message) {
		DOMConfigurator.configure("LogConfig.xml");
		Log.error(message);
	}

	// Fatal Level Logs
	public static void fatal(String message) {
		BasicConfigurator.configure();
		Log.fatal(message);
	}

	// Debug Level Logs
	public static void debug(String message) {
		BasicConfigurator.configure();
		Log.debug(message);
	}
}