/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import Arrays.CourseAssignmentList;
import Arrays.CourseList;
import Arrays.CourseStudentList;
import Arrays.CourseTrainerList;
import Classes.Course;
import static Menus.AddMenu.addMenuInputInt;
import static Tools.DateFormatter.dateFormatter;
import static Tools.InputRepeater.inputRepeater;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class CourseInput {

    static String[] randomCourseTitleList = new String[]{"CB8", "CB9", "CB10", "CB11", "CB12", "CB13", "CB14",
        "CB15", "CB16", "CB17", "CB18", "CB19", "CB20"};
    static String[] randomCourseStreamList = new String[]{"Java", "C#"};
    static String[] randomCourseTypeList = new String[]{"Full-Time", "Part-Time"};

    static public void courseInput() {

        Scanner courseTitleInput = new Scanner(System.in);
        Scanner courseStreamInput = new Scanner(System.in);
        Scanner courseTypeInput = new Scanner(System.in);
        Scanner courseStartDateInput = new Scanner(System.in);
        Scanner courseEndDateInput = new Scanner(System.in);

        // Course Title Input
        System.out.println("");
        System.out.println("Enter Course Title (Ex. CB8)");
        System.out.print("(or press Enter for a random input): ");
        String courseTitleInputString = courseTitleInput.nextLine();
        if (courseTitleInputString.length() == 0) {
            String randomCourseTitle = Tools.Randomizer.stringRandomizer(randomCourseTitleList);
            System.out.println("");
            System.out.println("Course Title: " + randomCourseTitle);
            courseTitleInputString = randomCourseTitle;
        }

        // Course Stream Input
        System.out.println("");
        System.out.println("Enter Course Stream (Ex. Java)");
        System.out.print("(or press Enter for a random input): ");
        String courseStreamInputString = courseStreamInput.nextLine();
        if (courseStreamInputString.length() == 0) {
            String randomStream = Tools.Randomizer.stringRandomizer(randomCourseStreamList);
            System.out.println("");
            System.out.println("Course Stream: " + randomStream);
            courseStreamInputString = randomStream;
        }

        // Course Type Input
        System.out.println("");
        System.out.println("Enter Course Type (Ex. Full-Time)");
        System.out.print("(or press Enter for a random input): ");
        String courseTypeInputString = courseTypeInput.nextLine();
        if (courseTypeInputString.length() == 0) {
            String randomType = Tools.Randomizer.stringRandomizer(randomCourseTypeList);
            System.out.println("");
            System.out.println("Course Type: " + randomType);
            courseTypeInputString = randomType;
        }

        // Course Start Date Input
        boolean correctFormat = false;
        String courseStartDateInputString = null;
        Date courseStartDateInputDate = null;

        while (correctFormat == false) {

            try { // the exception checks for correct date format input which can be parsed as a Date
                System.out.println("");
                System.out.println("Enter Course Start Date (DD-MM-YYYY)");
                System.out.print("(or press Enter for a random future date up to 1000 days from today): ");
                courseStartDateInputString = courseStartDateInput.nextLine();

                if (courseStartDateInputString.length() == 0) {
                    courseStartDateInputDate = Tools.Randomizer.courseStartDateRandomizer();
                    System.out.println("");
                    System.out.println("Course Start Date: " + dateFormatter(courseStartDateInputDate));
                } else {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    courseStartDateInputDate = format.parse(courseStartDateInputString);
                }

                Date currentDate = new Date();

                if (currentDate.compareTo(courseStartDateInputDate) > 0) {
                    // this checks if the date input is in the past (not accepted)
                    System.out.println("");
                    System.out.println("This Date is in the past! Please try again!");
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

        // Course End Date Input    
        correctFormat = false;
        String courseEndDateInputString = null;
        Date courseEndDateInputDate = null;

        while (correctFormat == false) {

            try { // the exception checks for correct date format input which can be parsed as a Date
                System.out.println("");
                System.out.println("Enter Course End Date (DD-MM-YYYY)");
                System.out.print("(or press Enter for a random future End Date after the Start Date): ");
                courseEndDateInputString = courseEndDateInput.nextLine();

                if (courseEndDateInputString.length() == 0) {
                    courseEndDateInputDate = Tools.Randomizer.courseEndDateRandomizer(courseStartDateInputDate);
                    System.out.println("");
                    System.out.println("Course End Date: " + dateFormatter(courseEndDateInputDate));
                } else {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    courseEndDateInputDate = format.parse(courseEndDateInputString);
                }

                if (courseStartDateInputDate.compareTo(courseEndDateInputDate) > 0) {
                    // this checks if the date input is before the Course Start Date (not accepted)
                    System.out.println("");
                    System.out.println("This Date is before the Course Start Date! Please try again!");
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

        CourseAssignmentList courseAssignmentList = new CourseAssignmentList();
        CourseTrainerList courseTrainerList = new CourseTrainerList();
        CourseStudentList courseStudentList = new CourseStudentList();

        // Create Course Object and add it to courseList array
        Course course1 = new Course(
                courseTitleInputString,
                courseStreamInputString,
                courseTypeInputString,
                courseStartDateInputDate,
                courseEndDateInputDate,
                courseAssignmentList,
                courseTrainerList,
                courseStudentList
        );
        CourseList.getCourseList().add(course1);

        System.out.println("");
        System.out.println("Total number of Courses: " + CourseList.getCourseList().size());
        System.out.println("");

        // Ask if users wants to repeat last action
        inputRepeater(addMenuInputInt);

    }

}
