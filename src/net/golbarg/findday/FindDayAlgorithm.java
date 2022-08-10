package net.golbarg.findday;

public class FindDayAlgorithm {

	public static String findDayName(String day, String month, String year) {
		// get 2 last digit of year
		int year_last_two_digit = Integer.parseInt(year.substring(year.length() - 2, year.length()));

		// Divide by 4, discarding any fraction.
		year_last_two_digit = Integer.parseInt(year) / 4;

		// Add the day of the month
		int calculation = year_last_two_digit + Integer.parseInt(day);

		// Add the month's key value: JFM AMJ JAS OND 144 025 036 146
		calculation += monthValue(Integer.parseInt(month));

		// Subtract 1 for January or February of a leap year.
		calculation -= isLeapYear(Integer.parseInt(year), Integer.parseInt(month));
		System.out.println(monthRange(Integer.parseInt(year)));
		calculation += monthRange(Integer.parseInt(year));

		// Add the last two digits of the year.
		calculation += year_last_two_digit;

		// divide
		calculation = calculation / 7;
		// remind
		calculation = calculation % 7;

		return dayName(calculation);
	}

	private static int isLeapYear(int year, int month) {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			if (month == 1 || month == 2) {
				return 1;
			}
		}
		return 0;
	}

	private static int monthRange(int year) {
		if (year >= 1900 && year <= 1999) {
			return 0;
		} else if (year >= 2000 && year <= 2999) {
			return 6;
		} else if (year >= 1700 && year <= 1799) {
			return 4;
		} else if (year >= 1800 && year <= 1899) {
			return 2;
		} else {
			return year * 400;
		}

	}

	private static int monthValue(int month) {
		// JFM AMJ JAS OND 144 025 036 146
		switch (month) {
		case 1:
			return 1;
		case 2:
			return 4;
		case 3:
			return 4;
		case 4:
			return 0;
		case 5:
			return 2;
		case 6:
			return 5;
		case 7:
			return 0;
		case 8:
			return 3;
		case 9:
			return 6;
		case 10:
			return 1;
		case 11:
			return 4;
		case 12:
			return 6;
		}
		return -1;
	}

	private static String dayName(int number) {
		switch (number) {
		case 1:
			return "Saturday";
		case 2:
			return "Sunday";
		case 3:
			return "Monday";
		case 4:
			return "Tuesday";
		case 5:
			return "Wednesday";
		case 6:
			return "Thursday";
		case 7:
			return "Friday";
		}

		return "";
	}

	public static void main(String[] args) {
		String year = "2022", day = "10", month = "8";
		year = year.substring(year.length() - 2, year.length());

		System.out.println(year);
		int yeari = Integer.parseInt(year) / 4;

		System.out.println(yeari);
		yeari = yeari + Integer.parseInt(day);
		System.out.println(yeari);
		yeari += monthValue(yeari);
		yeari -= isLeapYear(Integer.parseInt(year), Integer.parseInt(month));
		yeari += 6;
		yeari += Integer.parseInt(year);
		yeari += monthRange(Integer.parseInt(year));
		yeari = yeari / 7;
		yeari = yeari % 7;
		System.out.println(dayName(yeari));
		System.out.println(findDayName(day, month, year));
	}
}
