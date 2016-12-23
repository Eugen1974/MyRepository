package others;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	public static final Logger LOGGER;

	static {
		LOGGER = Logger.getLogger(MyLogger.class.getName());
		LOGGER.setLevel(Level.ALL);
		try {
			FileHandler handler = new FileHandler("log/log.txt", 1000 * 1024, 5, true);
			handler.setFormatter(new SimpleFormatter()); // simple text but not
															// XML
			LOGGER.addHandler(handler);
		} catch (IOException | SecurityException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	private MyLogger() {
	}
}
