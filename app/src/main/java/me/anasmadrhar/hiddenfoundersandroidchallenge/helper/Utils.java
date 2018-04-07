package me.anasmadrhar.hiddenfoundersandroidchallenge.helper;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by anas on 4/7/18.
 */

public class Utils {
    @SuppressLint("SimpleDateFormat")
    public static String getLastMonthQuery() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -30);
        Date today30 = cal.getTime();

        return "created:>"+new SimpleDateFormat("yyyy-MM-dd").format(today30);
    }
}
