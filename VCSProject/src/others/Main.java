package others;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			e.printStackTrace();
			MyLogger.LOGGER.log(Level.SEVERE, "Block main", e);
		}

		try {
			InputStream in = new FileInputStream("file.txt");
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			MyLogger.LOGGER.log(Level.SEVERE, "Block InputStream", e);
		}

		System.out.println("\n" + MyLogger.LOGGER.getName() + "\n---------------"
				+ String.format("\n%8s%s", "ALL=", MyLogger.LOGGER.isLoggable(Level.ALL))
				+ String.format("\n%8s%s", "CONFIG=", MyLogger.LOGGER.isLoggable(Level.CONFIG))
				+ String.format("\n%8s%s", "FINE=", MyLogger.LOGGER.isLoggable(Level.FINE))
				+ String.format("\n%8s%s", "FINER=", MyLogger.LOGGER.isLoggable(Level.FINER))
				+ String.format("\n%8s%s", "FINEST=", MyLogger.LOGGER.isLoggable(Level.FINEST))
				+ String.format("\n%8s%s", "INFO=", MyLogger.LOGGER.isLoggable(Level.INFO))
				+ String.format("\n%8s%s", "OFF=", MyLogger.LOGGER.isLoggable(Level.OFF))
				+ String.format("\n%8s%s", "SEVERE=", MyLogger.LOGGER.isLoggable(Level.SEVERE))
				+ String.format("\n%8s%s", "WARNING=", MyLogger.LOGGER.isLoggable(Level.WARNING)));
	}
}