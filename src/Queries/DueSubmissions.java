/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.StudentList;
import Classes.Assignment;
import Classes.Student;
import static Tools.DateFormatter.dateFormatter;
import static Tools.DateUtil.addDays;
import static Tools.EnterToContinue.enterToContinue;
import static Tools.MondayFinder.mondayFinder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class DueSubmissions {

    public static void dueSubmissions() {

        // Check if there are any assignments assigned to Students
        int existAssignedAssignments = 0;
        for (Student student : StudentList.getStudentList()) {

            if (student.getStudentAssignmentList().getStudentAssignmentList().size() > 0) {
                existAssignedAssignments = 1;
                break;
            }

        }

        if (existAssignedAssignments == 0) {
            System.out.println("");
            System.out.println("No assignments exist for any Student");

        } else {

            Scanner dueSubmissionsInput = new Scanner(System.in);

            // Ask the Date for which the user is interested in to find due submissions in that day's weekday
            boolean correctFormat = false;
            String dueSubmissionsInputString = null;
            Date dueSubmissionsInputDate = null;

            while (correctFormat == false) {

                try { // the exception checks for correct date format input which can be parsed as a Date
                    System.out.println("");
                    System.out.print("Enter the Date to check for due Assignments (DD-MM-YYYY): ");
                    dueSubmissionsInputString = dueSubmissionsInput.nextLine();

                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    dueSubmissionsInputDate = format.parse(dueSubmissionsInputString);

                    Date currentDate = new Date();

                    if (currentDate.compareTo(dueSubmissionsInputDate) > 0) {
                        // this checks if the date input is in the past (not accepted)
                        System.out.println("");
                        System.out.println("Date should be in the future! Try again!");
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

            // Then we find the Date of the Monday that procedes the user's Date input
            // and also the Friday, 4 days after that Monday
            // we actually add 5, because we want till 23:59 of Friday
            // because it goes Saturday 00:00, the upper limit is not inclusive
            Date mondayDate = mondayFinder(dueSubmissionsInputDate);
            Date fridayDate = addDays(mondayDate, 5);

            // Then we print the Students who have assignments between that Monday and Friday (inclusive)
            System.out.println("");
            System.out.println("Student Name / Assignment Title / Due Date");
            System.out.println("------------------------------------------");
            System.out.println("");

            Date checkedDate;
            int count = 0;
            for (Student student : StudentList.getStudentList()) {

                for (Assignment assignment : student.getStudentAssignmentList().getStudentAssignmentList()) {
                    checkedDate = assignment.getSubDateTime();

                    if (checkedDate.compareTo(mondayDate) >= 0 && checkedDate.compareTo(fridayDate) < 0) {
                        count++;
                        System.out.println(count + ") " + student.getFirstName() + " " + student.getLastName()
                                + " / " + assignment.getTitle() + " / " + dateFormatter(assignment.getSubDateTime()));
                    }

                }

            }
            if (count == 0) {
                System.out.println("");
                System.out.println("No Students have due Assignments to the weekday of that date!");
                System.out.println("");

            }

        }
        enterToContinue();
        Menus.QueriesMenu.queriesMenu();

    }

}
