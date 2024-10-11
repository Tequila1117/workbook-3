package com.pluralsight.dates;

import java.time.LocalDateTime; // Import LocalDateTime class for date and time
import java.time.ZoneId; // Import ZoneId class to work with time zones
import java.time.format.DateTimeFormatter; // Import DateTimeFormatter class for formatting dates

public class FormatDates {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format 1 is MM/dd/yyyy
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate1 = currentDateTime.format(format1);
        System.out.println(formattedDate1); // Shows the date in format MM/dd/yyyy

        // Format 2 is yyyy-MM-dd
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate2 = currentDateTime.format(format2);
        System.out.println(formattedDate2); // Shows the date in format yyyy-MM-dd

        // Format 3 is Month day, year
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate3 = currentDateTime.format(format3);
        System.out.println(formattedDate3); // Shows the date in format Month day, year

        // Format 4 is Day of the week, Month day, year HH:mm in GMT
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/London"));
        String formattedDate4 = now.format(format4);
        System.out.println(formattedDate4); // Shows the date in GMT/UTC time

        // Challenge: Show this format "5:02 on 05-Sep-2021 in local time zone"
        DateTimeFormatter formatChallenge = DateTimeFormatter.ofPattern("h:mm a 'on' dd-MMM-yyyy");
        String formattedChallenge = currentDateTime.format(formatChallenge);
        System.out.println(formattedChallenge); // Display the date in local time zone
    }
}