package com.java.pract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareDates {
public static void main(String args[]) {
String date1String = "25 JUL 2019 11:23";
String date2String = "7/18/2019 11:23:31";
try{
SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");
SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
Date date1 = dateFormat.parse(date1String);
Date date2 = dateFormat2.parse(date2String);

System.out.println(date1.toString()+"::"+date2.toString());

Integer.getInteger("10");
Integer.valueOf("10");
if (date1.compareTo(date2) > 0) {
System.out.println(date1 + " is After " + date2);
} else if (date1.compareTo(date2) < 0) {
System.out.println(date1 + " is Before " + date2);
} else if (date1.compareTo(date2) == 0) {
System.out.println(date1 + " is Equal to " + date2);
}
}catch (Exception e){
e.printStackTrace();
}
}
}