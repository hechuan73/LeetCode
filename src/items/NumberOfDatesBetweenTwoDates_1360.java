package items;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author hechuan
 */
public class NumberOfDatesBetweenTwoDates_1360 {

    /**
     * Using API.
     *
     * @param date1 date 1
     * @param date2 date 2
     * @return the days between date 1and 2
     */
    public int daysBetweenDates1(String date1, String date2) {
        return Math.abs((int) ChronoUnit.DAYS.between(LocalDate.parse(date2), LocalDate.parse(date1)));
    }

    /**
     * Mathematical solution without API.
     *
     * @param date1 date 1
     * @param date2 date 2
     * @return the days between date 1and 2
     */
    public int daysBetweenDates2(String date1, String date2) {
        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        return Math.abs(daysFrom1971(date1, days) - daysFrom1971(date2, days));
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private int daysFrom1971(String date, int[] days) {
        String[] values = date.split("-");
        int year = Integer.parseInt(values[0]);
        int month = Integer.parseInt(values[1]);
        int day = Integer.parseInt(values[2]);
        for (int i = 1971; i < year; i++) {
            day += isLeapYear(i) ? 366 : 365;
        }
        return day + (month > 2 && isLeapYear(year) ? days[month-1] + 1: days[month-1]);
    }
}
