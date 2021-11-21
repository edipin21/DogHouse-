

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MyDate {
	private int year, month, day;
	private final static int[] DAYS_MONTHS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public MyDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
		
	}
	
	public MyDate(MyDate other) {
		day=other.day;
		month=other.month;
		year=other.year;
	}
	public MyDate(Scanner scan) {
		String []theDate= scan.nextLine().split(", ");
		day=Integer.valueOf(theDate[0]);
		month=Integer.valueOf(theDate[1]);
		year=Integer.valueOf(theDate[2]);

		
		
	}

	public void setYear(int Year) {
		if (Year >= 2000 && Year <= 2020) {
			this.year = Year;
		} else
			this.year = 2020;

	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else
			this.month = 1;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day <= DAYS_MONTHS[month - 1]) {
			this.day = day;
		} else
			this.day = 1;
	}

	public int getYear() {
		return year;
	}

	public int daysCount(MyDate d) {
		LocalDate enter = LocalDate.of(year, month, day);
		LocalDate out = LocalDate.of(d.year, d.month, d.day);
		Period period = Period.between(enter, out);
		int diff = Math.abs(period.getDays() + period.getMonths() * DAYS_MONTHS[month - 1] + period.getYears() * 365);
		return diff;
	}
	public String toString() {
		String str;
		str=day+"/ "+month+"/"+year ;
				return str;
	}

	public  void save(PrintWriter writer) {
		writer.print(day+",");
		writer.print(month+",");
		writer.println(year);

	}

}
