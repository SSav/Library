package edu.spring.java.lesson.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class LogConfig {

	public static String logFile;
	public static Properties logProperties = new Properties();

	@SuppressWarnings("static-access")
	public LogConfig(String logFile) {
		this.logFile = logFile;
		try {
			logProperties.load(new FileInputStream(logFile));
			PropertyConfigurator.configure(logProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
