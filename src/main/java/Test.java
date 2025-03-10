import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author yao 2022/9/21
 */
@Data
public class Test {

    public static int calculateDays(int year, int month, int day) {
        int sumDays = 0;
        switch (month) {
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) sumDays += 29;
                else sumDays += 28;
            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
        }
        return sumDays;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(Integer.MAX_VALUE);
/*        int year = 2024;
        int month = 7;
        int day = 22;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(year + "-" + month + "-" + day);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        System.out.println(calculateDays(year, month, day));*/
    }

}