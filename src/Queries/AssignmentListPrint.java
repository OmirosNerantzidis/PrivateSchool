/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.CourseList;

import Classes.Course;
import Classes.Assignment;
import static Tools.DateFormatter.dateFormatter;
import static Tools.EmptyListChecker.emptyListChecker;
import static Tools.EnterToContinue.enterToContinue;
import java.util.ArrayList;

/**
 *
 * @author omiro
 */
public class AssignmentListPrint {

    public static void assignmentListPrint() {

        ArrayList<Assignment> allAssignments = new ArrayList<>();

        for (Course course : CourseList.getCourseList()) {

            allAssignments.addAll(course.getCourseAssignmentList().getCourseAssignmentList());
        }

        System.out.println("");
        System.out.println("Assignments");
        System.out.println("-----------");
        System.out.println("");
        System.out.println("Course / Title / Description / Submission Date");
        System.out.println("----------------------------------------------");

        boolean listIsEmpty = emptyListChecker(allAssignments);

        if (listIsEmpty == false) {

            ArrayList<Assignment> perCourseAssignmentList = new ArrayList<>();

            for (Course course : CourseList.getCourseList()) {

                perCourseAssignmentList = course.getCourseAssignmentList().getCourseAssignmentList();

                int count = 0;

                for (Assignment assignment : perCourseAssignmentList) {
                    count++;
                    System.out.println(count + ") " + course.getTitle() + " / " + assignment.getTitle()
                            + " / " + assignment.getDescription()
                            + " / " + dateFormatter(assignment.getSubDateTime()));
                }

            }

        }

        enterToContinue();
        Menus.QueriesMenu.queriesMenu();

    }

}
