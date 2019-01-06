package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	private DateFormatter() {
	};

	public static String formatDateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
}
