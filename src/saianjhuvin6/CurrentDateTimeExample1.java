package saianjhuvin6;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CurrentDateTimeExample1 {
    public static void main(String[] args) throws Exception {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("10-01-2021");
        System.out.println(date);
        long ltime=date.getTime()+15*24*60*60*1000;
        Date today15=new Date(ltime);
        System.out.println(today15);
    }
}
