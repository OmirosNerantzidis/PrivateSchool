/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.CourseList;
import Classes.Course;
import static Tools.DateFormatter.dateFormatter;
import static Tools.EmptyListChecker.emptyListChecker;
import static Tools.EnterToContinue.enterToContinue;

/**
 *
 * @author omiro
 */
public class CourseListPrint {

    public static void courseListPrint() {

        System.out.println("");
        System.out.println("Courses");
        System.out.println("-------");
        System.out.println("");
        System.out.println("Title / Stream / Type / Start Date / End Date");
        System.out.println("---------------------------------------------");

        boolean listIsEmpty = emptyListChecker(CourseList.getCourseList());

        if (listIsEmpty == false) {

            int count = 0;

            for (Course course : CourseList.getCourseList()) {
                count++;
                System.out.println(count + ") " + course.getTitle() + " / " + course.getStream() + " / " + course.getType() + " / " + dateFormatter(course.getStart_date()) + " / " + dateFormatter(course.getEnd_date()));
            }
        }

        enterToContinue();
        Menus.QueriesMenu.queriesMenu();

    }

}
