/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.CourseList;
import Classes.Student;
import static Menus.QueriesMenu.queriesMenu;
import static Tools.DateFormatter.dateFormatter;
import static Tools.IntRangeChecker.intRangeChecker;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class StudentsPerCourse {

    static ArrayList<Integer> realIndeces;

    public static void studentsPerCourse() {

        Scanner studentsPerCourseInputFinish = new Scanner(System.in);

        // Print list of Courses
        if (CourseList.getCourseList().isEmpty()) { // Checks if there are available Courses to choose from
            System.out.println("");
            System.out.println("");
            System.out.println("There are no Courses available to show students for.");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            System.out.println("");
            String studentsPerCourseString = studentsPerCourseInputFinish.nextLine();
            if (studentsPerCourseString.length() == 0) {
                Menus.QueriesMenu.queriesMenu();
            } else {
                Menus.QueriesMenu.queriesMenu();
            }
        }
        int studentsCourseChoiceInputInt = -1;

        do {
            Scanner studentsCourseChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("");
            System.out.println("Available Courses with at least 1 student");
            System.out.println("--------------------------------------------");

            // Dynamically prints a menu excluding Courses that don't have Students
            // In parallel, it creates an Array with the real indices of the printed options
            realIndeces = new ArrayList<>();
            for (int i = 0; i < CourseList.getCourseList().size(); i++) {
                if (CourseList.getCourseList().get(i).getCourseStudentList().getCourseStudentList().size() > 0) {

                    realIndeces.add(i);

                    System.out.println((realIndeces.size()) + ") " + CourseList.getCourseList().get(i).getTitle());
                }
            }

            if (realIndeces.isEmpty()) {
                System.out.println("None of the Courses have students set");
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Course you want to see its Students");
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            studentsCourseChoiceInputInt = intRangeChecker(0, realIndeces.size(), studentsCourseChoiceInput);
            if (studentsCourseChoiceInputInt == 0) {
                queriesMenu();
            }

        } while (studentsCourseChoiceInputInt < 0 || studentsCourseChoiceInputInt > realIndeces.size());

        int workingCourseRealIndex = realIndeces.get(studentsCourseChoiceInputInt - 1);

        ArrayList<Student> studentsPerCourseList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseStudentList().getCourseStudentList();

        if (studentsPerCourseList.isEmpty()) {

            System.out.println("");
            System.out.println("");
            System.out.print("There are no Students available for this Course");
            System.out.println("");
            System.out.println("");

        } else {

            System.out.println("");
            System.out.println("Students of Course: " + CourseList.getCourseList().get(workingCourseRealIndex).getTitle());
            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Name / Date of Birth / Tuition Fees");
            System.out.println("-----------------------------------");

            for (int i = 0; i < studentsPerCourseList.size(); i++) {

                Student student = studentsPerCourseList.get(i);

                System.out.println((i + 1) + ") " + student.getFirstName() + " "
                        + student.getLastName() + " / "
                        + dateFormatter(student.getDateOfBirth()) + " / "
                        + student.getTuitionFees());
            }
        }

        System.out.println("");
        System.out.println("Press Enter to go to the previous menu");
        System.out.println("");
        System.out.println("");
        String studentsPerCourseString = studentsPerCourseInputFinish.nextLine();
        if (studentsPerCourseString.length() == 0) {
            Menus.QueriesMenu.queriesMenu();
        } else {
            Menus.QueriesMenu.queriesMenu();
        }
    }
}
