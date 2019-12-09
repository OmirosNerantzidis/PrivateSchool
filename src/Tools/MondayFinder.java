/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import static Tools.DateUtil.addDays;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author omiro
 */
public class MondayFinder {

    public static Date mondayFinder(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // the above considers Sunday as Day 1 of the week

        Date mondayDate = date;
        switch (dayOfWeek) {
            case 1:
                mondayDate = addDays(date, -6);
                break;
            case 2:
                mondayDate = addDays(date, 0);
                break;
            case 3:
                mondayDate = addDays(date, -1);
                break;
            case 4:
                mondayDate = addDays(date, -2);
                break;
            case 5:
                mondayDate = addDays(date, -3);
                break;
            case 6:
                mondayDate = addDays(date, -4);
                break;
            case 7:
                mondayDate = addDays(date, -5);
                break;
            default:
            // code block - never used
        }

        return mondayDate;

    }

}
