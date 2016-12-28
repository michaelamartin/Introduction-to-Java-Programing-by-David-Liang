package Chapter_13;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MyCalendar{
    /** Print the calendar title for the given month. */
    public static void printMonthTitle(Calendar calendar) {
        String monthName = new SimpleDateFormat("MMMM").format(calendar.getTime());
  	System.out.println("         " + monthName);
        System.out.printf("%28s", "----------------------------");
        System.out.println();
        for (String day : new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"})
            System.out.printf("%4s", day);
        System.out.println();
    }
  
    /** Print the calendar body for the given month. */
    public static void printMonthBody(Calendar calendar) {
        // Get start day of the week for the first date in the month
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
     
        // Get number of days in the month
        int numberOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    
        // Pad space before the first day of the month
        for (int i = 0; i < startDay; i++)
            System.out.printf("%4s", "");
    
        for (int i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);
            if ((i + startDay) % 7 == 0)
        	System.out.println();
        }
        System.out.println(); 
    }
    
    /** Testing */    
    public static void main(String[] args) {  
        if (args.length != 2) {
            System.out.println("Error: enter 2 arguments representing the month and year.");
            System.out.println("Ex: 5 2016 (May 2016).");
            System.exit(1);
        }
        else {
            int month = Integer.parseInt(args[0]) - 1;	
            int year = Integer.parseInt(args[1]);            
            Calendar calendar = new GregorianCalendar(year, month, 1);
            printMonthTitle(calendar);
            printMonthBody(calendar);
        }
    }
}