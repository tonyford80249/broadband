package com.cdoe.util;

import java.util.GregorianCalendar;

/**
 *
 * @author Tony Ford
 */
public enum CalendarMonth {

    JANUARY("January", "01"),
    FEBRUARY("February", "02"),
    MARCH("March", "03"),
    APRIL("April", "04"),
    MAY("May", "05"),
    JUNE("June", "06"),
    JULY("July", "07"),
    AUGUST("August", "08"),
    SEPTEMBER("September", "09"),
    OCTOBER("October", "10"),
    NOVEMBER("November", "11"),
    DECEMBER("December", "12");
    private String text;
    private String calendarValue;

    private CalendarMonth(String text, String calendarValue) {
        this.text = text;
        this.calendarValue = calendarValue;
    }

    public String getText() {
        return text;
    }

    public String getCalendarValue() {
        return calendarValue;
    }

    /**
     *
     * @param month
     * @return
     */
    public static CalendarMonth getInstance(String month) {
        for (CalendarMonth candidate : JANUARY.values()) {
            if (candidate.name().equalsIgnoreCase(month)) {
                return candidate;
            }
        }

        return null;
    }

    /**
     *
     * @param month
     * @return
     */
    public static CalendarMonth getInstance(Integer month) {
        for (CalendarMonth candidate : JANUARY.values()) {
            if (Integer.parseInt(candidate.getCalendarValue()) == month) {
                return candidate;
            }
        }

        return null;
    }
    
    /**
     * 
     * @return 
     */
    public static CalendarMonth getCurrentMonth() {
      // Initialize GregorianCalendar
      GregorianCalendar cal = new GregorianCalendar();
      
      //int currYear = cal.get(GregorianCalendar.YEAR);
      //int currDOM = cal.get(GregorianCalendar.DAY_OF_MONTH);
      int currMnth = cal.get(GregorianCalendar.MONTH) + 1;  
      
      return getInstance(currMnth);
    }

    /**
     *
     * @return
     */
    public CalendarMonth next() {
        int select = this.ordinal() + 1;
        if (select > 11) {
            select = 0;
        }

        for (CalendarMonth candidate : values()) {
            if (candidate.ordinal() == select) {
                return candidate;
            }
        }

        return null;
    }

    /**
     *
     * @return
     */
    public CalendarMonth prev() {
        int select = this.ordinal() - 1;
        if (select < 0) {
            select = 11;
        }

        for (CalendarMonth candidate : values()) {
            if (candidate.ordinal() == select) {
                return candidate;
            }
        }

        return null;
    }
}
