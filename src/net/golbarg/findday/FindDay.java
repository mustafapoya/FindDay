package net.golbarg.findday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindDay {
	public static String findDayOfWeek(int day, int month, int year) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
		format.applyPattern("EEEE d MMM yyyy");
		return format.format(date);
	}
}
