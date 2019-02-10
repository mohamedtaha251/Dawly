package com.dawly.app.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Converters {

    public static String dateFormatter(String date) {
        //date=date.substring(0,date.indexOf('T'));
        DateFormat df = new SimpleDateFormat("dd MMM , yyyy ", Locale.getDefault());
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);

        String returnedDate = "";
        Date startDate;
        try {
            startDate = dateFormatter.parse(date);
            returnedDate = df.format(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnedDate;
    }

    public static String historyDateFormatter(String date){
        //date=date.substring(0,date.indexOf('T'));
        DateFormat df = new SimpleDateFormat("dd MMM HH:mm ", Locale.getDefault());
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);

        String returnedDate="";
        Date startDate;
        try {
            startDate = dateFormatter.parse(date);
            returnedDate = df.format(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnedDate;
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }


    //Returns the number of days left between 2 dates
    public static long dateDifference(String startDate, String endDate) {
        long numberOfDays = 0;
        try {
            Date date1;
            Date date2;

            SimpleDateFormat parsingDate1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            SimpleDateFormat parsingDate2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            //Setting dates
            date1 = parsingDate1.parse(startDate);
            date2 = parsingDate2.parse(endDate);

            //Comparing dates
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            numberOfDays = differenceDates;
            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            Logger.logError("DateDiff::" + dayDifference);

        } catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }
    return numberOfDays;
    }


    //Returns the number of hours left between 2 dates
    public static long hoursDifference(String startDate, String endDate){
        long numberOfDays=0;
        try {
            Date date1;
            Date date2;

            SimpleDateFormat parsingDate1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.ENGLISH);
            SimpleDateFormat parsingDate2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.ENGLISH);
            //Setting dates
            date1 = parsingDate1.parse(startDate);
            date2 = parsingDate2.parse(endDate);

            //Comparing dates
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (60 * 60 * 1000);
            numberOfDays=differenceDates;
            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            Log.e("HERE", "HERE: " + dayDifference);

        } catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }
        return numberOfDays;
    }
    //Returns the number of days left between 2 dates
    public static long historyDateDifference(String startDate, String endDate){
        long numberOfDays=0;
        try {
            Date date1;
            Date date2;

            SimpleDateFormat parsingDate1 = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
            SimpleDateFormat parsingDate2 = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
            //Setting dates
            date1 = parsingDate1.parse(startDate);
            date2 = parsingDate2.parse(endDate);

            //Comparing dates
            long difference = date1.getTime() - date2.getTime();
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            numberOfDays=differenceDates;
            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            Log.e("HERE","HERE: " + dayDifference);

        } catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }
        return numberOfDays;
    }


}
