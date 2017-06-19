package northeasternuniversity.cxplatform.utilities;

import java.util.Calendar;

public class DateChecker {

	private Calendar currentDate;

	public DateChecker() {
		currentDate = Calendar.getInstance();
	}

	public int parseMonthToNumber(String monthToValidate) {
		int monthNumber = -1;
		if (monthToValidate.contains("Jan"))
			monthNumber = 0;
		else if (monthToValidate.contains("Feb"))
			monthNumber = 1;
		else if (monthToValidate.contains("Mar"))
			monthNumber = 2;
		else if (monthToValidate.contains("Apr"))
			monthNumber = 3;
		else if (monthToValidate.contains("May"))
			monthNumber = 4;
		else if (monthToValidate.contains("Jun"))
			monthNumber = 5;
		else if (monthToValidate.contains("Jul"))
			monthNumber = 6;
		else if (monthToValidate.contains("Aug"))
			monthNumber = 7;
		else if (monthToValidate.contains("Sep"))
			monthNumber = 8;
		else if (monthToValidate.contains("Oct"))
			monthNumber = 9;
		else if (monthToValidate.contains("Nov"))
			monthNumber = 10;
		else if (monthToValidate.contains("Dec"))
			monthNumber = 11;

		return monthNumber;

	}

	public Boolean validateMonthIsCorrect(String month) {
		int monthNumber = this.parseMonthToNumber(month);
		int currentMonthNumber = currentDate.get(Calendar.MONTH);
		if (monthNumber < currentMonthNumber)
			return false;
		else
			return true;

	}
	
	public Boolean validateDayIsCorrect(String day) {
		int dayNumber = Integer.parseUnsignedInt(day);
		int currentDayNumber = currentDate.get(Calendar.DAY_OF_MONTH);
		if (dayNumber < currentDayNumber)
			return false;
		else
			return true;
	}
}
