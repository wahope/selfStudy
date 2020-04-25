package com.selfStudy.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/9 15:44
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
public class DateUtil {
    /**
     * 时间戳转换成日期格式字符串
     * @paramseconds 精确到秒的字符串
    * @param
     * @return
     */

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @paramdate 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }

    /** 
    * 将Date类型时间转换为字符串 
    * @param date 
    * @return 
    */
    public static String dateToString(Date date){
        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd HH:mm:ss");
        time = formater.format(date);
        return time;
    }


//    public static void main(String[] args) {
//        String timeStamp = timeStamp();
//        System.out.println("timeStamp="+timeStamp); //运行输出:timeStamp=1470278082
//        System.out.println(System.currentTimeMillis());//运行输出:1470278082980
//        //该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数
//
//        String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");
//        System.out.println("date="+date);//运行输出:date=2016-08-04 10:34:42
//
//        String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
//        System.out.println(timeStamp2);  //运行输出:1470278082
//    }
}
