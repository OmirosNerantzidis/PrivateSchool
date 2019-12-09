/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import Arrays.CourseAssignmentList;
import Arrays.CourseList;
import Classes.Assignment;
import Classes.Student;
import static Menus.AddMenu.addMenu;
import static Menus.AddMenu.addMenuInputInt;
import static Tools.DateFormatter.dateFormatter;
import static Tools.InputRepeater.inputRepeater;
import static Tools.IntRangeChecker.intRangeChecker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class AssignmentInput {

    static String[] randomAssignmentTitleList = new String[]{"Individual Project A", "Individual Project B", "Individual Project C", "Individual Project D", "Individual Project E"};
    static String[] randomAssignmentDescriptionList = new String[]{"This is an assignment description A", "This is an assignment description B", "This is an assignment description C", "This is an assignment description D", "This is an assignment description E"};

    static public void assignmentInput() {

        Scanner assignmentTitleInput = new Scanner(System.in);
        Scanner assignmentDescriptionInput = new Scanner(System.in);
        Scanner assignmentSubDateInput = new Scanner(System.in);
        Scanner assignmentInputFinish = new Scanner(System.in);

// Print list of Courses
        if (CourseList.getCourseList().isEmpty()) { // Checks if there are available Courses to choose from
            System.out.println("");
            System.out.println("There are no Courses available to add assignments to.");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            String assignmentInputFinishString = assignmentInputFinish.nextLine();
            if (assignmentInputFinishString.length() == 0) {
                addMenuInputInt = -1;
                addMenu();
            }
        }
        int assignmentCourseChoiceInputInt = -1;

        do {
            Scanner assignmentCourseChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Courses");
            System.out.println("-----------------");
            for (int i = 0; i < CourseList.getCourseList().size(); i++) {
                System.out.println((i + 1) + " - " + CourseList.getCourseList().get(i).getTitle());
            }
            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Course you want to create an Assignment for");
            System.out.print("Please Select (0-" + CourseList.getCourseList().size() + "): ");

            assignmentCourseChoiceInputInt = intRangeChecker(0, CourseList.getCourseList().size(), assignmentCourseChoiceInput);
            if (assignmentCourseChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (assignmentCourseChoiceInputInt < 0 || assignmentCourseChoiceInputInt > CourseList.getCourseList().size());

        int workingCourseRealIndex = assignmentCourseChoiceInputInt - 1;

        // Assignment Title Input
        System.out.println("");
        System.out.println("Enter Assignment's Title");
        System.out.print("(or press Enter for a random input): ");

        String assignmentTitleInputString = assignmentTitleInput.nextLine();
        if (assignmentTitleInputString.length() == 0) {
            String randomAssignmentTitle = Tools.Randomizer.stringRandomizer(randomAssignmentTitleList);
            System.out.println("");
            System.out.println("Assignment's Title: " + randomAssignmentTitle);
            assignmentTitleInputString = randomAssignmentTitle;
        }

        // Assignment Description Input
        System.out.println("");
        System.out.println("Enter Assignment's Description");
        System.out.print("(or press Enter for a random input): ");

        String assignmentDescriptionInputString = assignmentDescriptionInput.nextLine();
        if (assignmentDescriptionInputString.length() == 0) {
            String randomAssignmentDescription = Tools.Randomizer.stringRandomizer(randomAssignmentDescriptionList);
            System.out.println("");
            System.out.println("Assignment's Description: " + randomAssignmentDescription);
            assignmentDescriptionInputString = randomAssignmentDescription;
        }

        // Assignment Sub Date Input
        boolean correctFormat = false;
        String assignmentSubDateInputString = null;
        Date assignmentSubDateInputDate = null;

        while (correctFormat == false) {

            try { // the exception checks for correct date format input which can be parsed as a Date
                System.out.println("");
                System.out.println("Enter Assignment Submission Date (DD-MM-YYYY)");
                System.out.println("(It must be after the Course's Start Date: " + dateFormatter(CourseList.getCourseList().get(workingCourseRealIndex).getStart_date()) + ")");
                System.out.print("(or press Enter for a random date 1 to 180 days after Course's Start Date): ");

                assignmentSubDateInputString = assignmentSubDateInput.nextLine();

                if (assignmentSubDateInputString.length() == 0) {
                    assignmentSubDateInputDate = Tools.Randomizer.assignmentSubDateRandomizer(CourseList.getCourseList().get(workingCourseRealIndex).getStart_date());
                    System.out.println("");
                    System.out.println("Assignment Submission Date: " + dateFormatter(assignmentSubDateInputDate));

                } else {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    assignmentSubDateInputDate = format.parse(assignmentSubDateInputString);
                }

                Date currentDate = new Date();
                if (CourseList.getCourseList().get(workingCourseRealIndex).getStart_date().compareTo(assignmentSubDateInputDate) > 0) {
                    // this checks if the date input is before the Course Start Date (not accepted)
                    System.out.println("");
                    System.out.println("Assignment Submission Date cannot be before the Course Start Date! Try again!");
                    System.out.println("");
                } else {
                    correctFormat = true;
                }

            } catch (ParseException ex) {
                System.out.println("");
                System.out.println("Wrong format! Please try again!");
                System.out.println("");
            }

        }

        Assignment assignment1 = new Assignment(assignmentTitleInputString,
                assignmentDescriptionInputString,
                assignmentSubDateInputDate,
                0,
                0
        );

        // ADD new Assignment to the Course's Assignment List    
// Gets current Assignment List of the Course
        CourseAssignmentList currentList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseAssignmentList();
// Adds the new course to that list
        currentList.getCourseAssignmentList().add(assignment1);
// Updates the saved list
        CourseList.getCourseList().get(workingCourseRealIndex).setCourseAssignmentList(currentList);

// ADD new Assignment as a different object to all the Course's Students
// Print the new Assignment has been added to Course's students:
// Print their names 
        System.out.println("");
        System.out.println("The newly created Assignment has been added to the Course Students:");
        System.out.println("-------------------------------------------------------------------");
// Gets current Student List of the Course
        ArrayList<Student> currentCourseStudentList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseStudentList().getCourseStudentList();
        if (currentCourseStudentList.isEmpty()) {
            System.out.println("Currently, the Course does not have any Students for the Assignment to be assigned,");
            System.out.println("but any future Course Students will automatically will automatically get this");
            System.out.println("");
        }

// For each student of that Course, it gets his name and prints it
// Also his current Assignment List and adds a new copy of the Assignment we just created
        for (Student student : currentCourseStudentList) {
            // Creating copy of Assignment
            assignment1 = new Assignment(assignmentTitleInputString,
                    assignmentDescriptionInputString,
                    assignmentSubDateInputDate,
                    0,
                    0
            );
            System.out.println(student.getFirstName() + " " + student.getLastName());
            student.getStudentAssignmentList().getStudentAssignmentList().add(assignment1);
        }

        // Ask if users wants to repeat last action
        inputRepeater(addMenuInputInt);

    }

}
