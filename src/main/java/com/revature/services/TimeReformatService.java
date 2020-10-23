package com.revature.services;




import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@Service
public class TimeReformatService {

    public String reformatTime(String oldTime){
        String[] timeArray = oldTime.split(":");
        int h = parseInt(timeArray[0]);
        int m = parseInt(timeArray[1]);
        return timeInWords(h, m);
    }

    public String getMinute(int t){
        String minute = "";
        switch (t) {
            case 1:
                minute = "one";
                break;
            case 2:
                minute = "two";
                break;
            case 3:
                minute = "three";
                break;
            case 4:
                minute = "four";
                break;
            case 5:
                minute = "five";
                break;
            case 6:
                minute = "six";
                break;
            case 7:
                minute = "seven";
                break;
            case 8:
                minute = "eight";
                break;
            case 9:
                minute = "nine";
                break;
            case 10:
                minute = "ten";
                break;
            case 11:
                minute = "eleven";
                break;
            case 12:
                minute = "twelve";
                break;
            case 13:
                minute = "thirteen";
                break;
            case 14:
                minute = "fourteen";
                break;
            case 16:
                minute = "sixteen";
                break;
            case 17:
                minute = "seventeen";
                break;
            case 18:
                minute = "eighteen";
                break;
            case 19:
                minute = "nineteen";
                break;
            case 20:
                minute = "twenty";
                break;
            case 21:
                minute = "twenty one";
                break;
            case 22:
                minute = "twenty two";
                break;
            case 23:
                minute = "twenty three";
                break;
            case 24:
                minute = "twenty four";
                break;
            case 25:
                minute = "twenty five";
                break;
            case 26:
                minute = "twenty six";
                break;
            case 27:
                minute = "twenty seven";
                break;
            case 28:
                minute = "twenty eight";
                break;
            case 29:
                minute = "twenty nine";
                break;
            default:
                break;
        }
        return minute;
    }

    public String getHour(int h){
        String hour = "";
        switch(h){
            case 1:
                hour = "one";
                break;
            case 2:
                hour = "two";
                break;
            case 3:
                hour = "three";
                break;
            case 4:
                hour = "four";
                break;
            case 5:
                hour = "five";
                break;
            case 6:
                hour = "six";
                break;
            case 7:
                hour = "seven";
                break;
            case 8:
                hour = "eight";
                break;
            case 9:
                hour = "nine";
                break;
            case 10:
                hour = "ten";
                break;
            case 11:
                hour = "eleven";
                break;
            case 12:
                hour = "twelve";
                break;

        }
        return hour;
    }

    public String timeInWords(int h, int m) {
        String hour = "";
        String time = "";
        String minute = "";

        if (m == 0) {
            hour = getHour(h);
            time = hour + " o' clock";
        } else if (m == 15) {
            hour = getHour(h);
            time = "quarter past " + hour;
        } else if (m == 30) {
            hour = getHour(h);
            time = "half past " + hour;
        } else if (m == 45) {
            hour = getHour(h + 1);
            time = "quarter to " + hour;
        } else if (m < 30 && m != 15) {
            hour = getHour(h);
            minute = getMinute(m);
            if (minute == "one") {
                time = minute + " minute past " + hour;
            } else {
                time = minute + " minutes past " + hour;
            }
        } else if (m > 30 && m != 45) {
            hour = getHour(h + 1);
            int t = 60 - m;
            minute = getMinute(t);
            if (minute == "one") {
                time = minute + " minute to " + hour;
            } else {
                time = minute + " minutes to " + hour;
            }
        }
        return time;
    }
}
