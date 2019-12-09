/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import Arrays.CourseList;
import Arrays.CourseStudentList;
import Arrays.StudentList;
import Classes.Assignment;
import static Menus.AddMenu.addMenu;
import static Menus.AddMenu.addMenuInputInt;
import static Tools.InputRepeater.inputRepeater;
import static Tools.IntRangeChecker.intRangeChecker;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class AssignStudentToCourseInput {

    static ArrayList<Integer> realIndeces;

    static public void assignStudentToCourseInput() {

        Scanner assignStudentToCourseInputFinish = new Scanner(System.in);

        if (CourseList.getCourseList().isEmpty() || StudentList.getStudentList().isEmpty()) { // Checks if there are available Courses and Students to choose from
            System.out.println("");
            System.out.println("In order to assign a Student to a Course,");
            System.out.println("you need to create at least one from each!");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            String assignStudentToCourseInputFinishString = assignStudentToCourseInputFinish.nextLine();
            if (assignStudentToCourseInputFinishString.length() == 0) {
                addMenuInputInt = -1;
                addMenu();
            } else {
                addMenuInputInt = -1;
                addMenu();
            }
        }

        // Print list of Courses
        int assignStudentToCourse_CourseChoiceInputInt = -1;

        do {

            Scanner assignStudentToCourse_CourseChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Courses");
            System.out.println("-----------------");
            for (int i = 0; i < CourseList.getCourseList().size(); i++) {
                System.out.println((i + 1) + " - " + CourseList.getCourseList().get(i).getTitle());
            }
            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Course you want to assign a Student to");
            System.out.print("Please Select (0-" + CourseList.getCourseList().size() + "): ");

            assignStudentToCourse_CourseChoiceInputInt = intRangeChecker(0, CourseList.getCourseList().size(), assignStudentToCourse_CourseChoiceInput);

            if (assignStudentToCourse_CourseChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (assignStudentToCourse_CourseChoiceInputInt < 0 || assignStudentToCourse_CourseChoiceInputInt > CourseList.getCourseList().size());

        int workingCourseRealIndex = assignStudentToCourse_CourseChoiceInputInt - 1;

        // Print list of Students
        int assignStudentToCourse_StudentChoiceInputInt = -1;

        do {

            Scanner assignStudentToCourse_StudentChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Students");
            System.out.println("---------------------------------------------------------------");
            System.out.println("(Students who are already assigned to this course are excluded)");
            System.out.println("");
            /////////////
            // Dynamically prints a menu excluding Students that are already assigned to the chosen Course
            // In parallel, it creates an Array with the real indices of the printed options
            realIndeces = new ArrayList<>();
            for (int i = 0; i < StudentList.getStudentList().size(); i++) {
                if (CourseList.getCourseList().get(workingCourseRealIndex).getCourseStudentList().getCourseStudentList().contains(StudentList.getStudentList().get(i)) == false) {

                    realIndeces.add(i);

                    System.out.println((realIndeces.size()) + " - " + StudentList.getStudentList().get(i).getFirstName() + " " + StudentList.getStudentList().get(i).getLastName());
                }
            }

            if (realIndeces.isEmpty()) {
                System.out.println("");
                System.out.println("No more available Students for this Course");
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Student you want to assign to course: " + CourseList.getCourseList().get(workingCourseRealIndex).getTitle());
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            assignStudentToCourse_StudentChoiceInputInt = intRangeChecker(0, realIndeces.size(), assignStudentToCourse_StudentChoiceInput);
            if (assignStudentToCourse_StudentChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (assignStudentToCourse_StudentChoiceInputInt < 0 || assignStudentToCourse_StudentChoiceInputInt > realIndeces.size());

        int workingStudentRealIndex = realIndeces.get(assignStudentToCourse_StudentChoiceInputInt - 1);

// Gets current Student List of the Course
        CourseStudentList currentList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseStudentList();
// Adds the selected Student to that list
        currentList.getCourseStudentList().add(StudentList.getStudentList().get(workingStudentRealIndex));
// Updates the saved list
        CourseList.getCourseList().get(workingCourseRealIndex).setCourseStudentList(currentList);
        System.out.println("");
        System.out.print("Student " + StudentList.getStudentList().get(workingStudentRealIndex).getFirstName() + " " + StudentList.getStudentList().get(workingStudentRealIndex).getLastName());
        System.out.println(" has been assigned to Course: " + CourseList.getCourseList().get(workingCourseRealIndex).getTitle());
        System.out.print("");

        // Adds copies of all Assignments of the Course to the newly assigned Student of that Course
        // Take the Course's Assignment List
        ArrayList<Assignment> currentCourseAssignmentList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseAssignmentList().getCourseAssignmentList();
        // Add each item of this list, to the Students Assignment List
        System.out.println("");
        System.out.println("The following Course's Assignments have been added to the newly assigned Student");
        System.out.println("--------------------------------------------------------------------------------");
        if (currentCourseAssignmentList.isEmpty()) {
            System.out.println("Currently, the Course does not have any Assignments to be assigned to the Student.");
            System.out.println("Any future Course Assignments will automatically be added to this Student also.");
        }

        Assignment assignmentCopy;
        for (Assignment assignment : currentCourseAssignmentList) {
            assignmentCopy = new Assignment(assignment);
            StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().add(assignmentCopy);
            System.out.println(assignment.getTitle());
        }

        // Ask if users wants to repeat last action
        inputRepeater(addMenuInputInt);

    }

}
