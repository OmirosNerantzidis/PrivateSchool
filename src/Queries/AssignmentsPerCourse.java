/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.CourseList;
import Classes.Assignment;
import static Menus.QueriesMenu.queriesMenu;
import static Tools.DateFormatter.dateFormatter;
import static Tools.IntRangeChecker.intRangeChecker;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class AssignmentsPerCourse {

    static ArrayList<Integer> realIndeces;

    public static void assignmentPerCourse() {

        Scanner assignmentsPerCourseInputFinish = new Scanner(System.in);

        // Print list of Courses
        if (CourseList.getCourseList().isEmpty()) { // Checks if there are available Courses to choose from
            System.out.println("");
            System.out.println("");
            System.out.println("There are no Courses available to show assignments for.");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            System.out.println("");
            String assignmentsPerCourseString = assignmentsPerCourseInputFinish.nextLine();
            if (assignmentsPerCourseString.length() == 0) {
                Menus.QueriesMenu.queriesMenu();
            } else {
                Menus.QueriesMenu.queriesMenu();
            }
        }
        int assignmentCourseChoiceInputInt = -1;

        do {
            Scanner assignmentCourseChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("");
            System.out.println("Available Courses with at least 1 assignment");
            System.out.println("--------------------------------------------");

            // Dynamically prints a menu excluding Courses that don't have assignments
            // In parallel, it creates an Array with the real indices of the printed options
            realIndeces = new ArrayList<>();
            for (int i = 0; i < CourseList.getCourseList().size(); i++) {
                if (CourseList.getCourseList().get(i).getCourseAssignmentList().getCourseAssignmentList().size() > 0) {

                    realIndeces.add(i);

                    System.out.println((realIndeces.size()) + ") " + CourseList.getCourseList().get(i).getTitle());
                }
            }

            if (realIndeces.isEmpty()) {
                System.out.println("None of the Courses have assignments set");
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Course you want to see its Assignments");
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            assignmentCourseChoiceInputInt = intRangeChecker(0, realIndeces.size(), assignmentCourseChoiceInput);
            if (assignmentCourseChoiceInputInt == 0) {
                queriesMenu();
            }

        } while (assignmentCourseChoiceInputInt < 0 || assignmentCourseChoiceInputInt > realIndeces.size());

        int workingCourseRealIndex = realIndeces.get(assignmentCourseChoiceInputInt - 1);

        ArrayList<Assignment> assignmentsPerCourseList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseAssignmentList().getCourseAssignmentList();

        if (assignmentsPerCourseList.isEmpty()) {

            System.out.println("");
            System.out.println("");
            System.out.print("There are no Assignments available for this Course");
            System.out.println("");
            System.out.println("");

        } else {

            System.out.println("");
            System.out.println("Assignments of Course: " + CourseList.getCourseList().get(workingCourseRealIndex).getTitle());
            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Course / Title / Description / Submission Date");
            System.out.println("----------------------------------------------");

            for (int i = 0; i < assignmentsPerCourseList.size(); i++) {

                Assignment assignment = assignmentsPerCourseList.get(i);

                System.out.println((i + 1) + ") " + assignment.getTitle() + " / "
                        + assignment.getDescription() + " / "
                        + dateFormatter(assignment.getSubDateTime())
                );
            }
        }

        System.out.println("");
        System.out.println("Press Enter to go to the previous menu");
        System.out.println("");
        System.out.println("");
        String assignmentsPerCourseString = assignmentsPerCourseInputFinish.nextLine();
        if (assignmentsPerCourseString.length() == 0) {
            Menus.QueriesMenu.queriesMenu();
        } else {
            Menus.QueriesMenu.queriesMenu();
        }
    }
}
