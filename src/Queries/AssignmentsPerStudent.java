/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.StudentList;
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
public class AssignmentsPerStudent {

    static ArrayList<Integer> realIndeces;

    public static void assignmentsPerStudent() {

        Scanner assignmentsPerStudentInputFinish = new Scanner(System.in);

        // Print list of Students
        if (StudentList.getStudentList().isEmpty()) { // Checks if there are available Students to choose from
            System.out.println("");
            System.out.println("");
            System.out.println("There are no Students available to show assignments for.");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            System.out.println("");
            String assignmentsPerStudentString = assignmentsPerStudentInputFinish.nextLine();
            if (assignmentsPerStudentString.length() == 0) {
                Menus.QueriesMenu.queriesMenu();
            } else {
                Menus.QueriesMenu.queriesMenu();
            }
        }
        int assignmentsStudentChoiceInputInt = -1;

        do {
            Scanner assignmentsStudentChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("");
            System.out.println("Available Students with at least 1 assignment");
            System.out.println("--------------------------------------------");

            // Dynamically prints a menu excluding Students that don't have assignments
            // In parallel, it creates an Array with the real indices of the printed options
            realIndeces = new ArrayList<>();
            for (int i = 0; i < StudentList.getStudentList().size(); i++) {
                if (StudentList.getStudentList().get(i).getStudentAssignmentList().getStudentAssignmentList().size() > 0) {

                    realIndeces.add(i);

                    System.out.println((realIndeces.size()) + ") "
                            + StudentList.getStudentList().get(i).getFirstName() + " "
                            + StudentList.getStudentList().get(i).getLastName());
                }
            }

            if (realIndeces.isEmpty()) {
                System.out.println("None of the Students have assignments set");
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Student you want to see his/her Assignments");
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            assignmentsStudentChoiceInputInt = intRangeChecker(0, realIndeces.size(), assignmentsStudentChoiceInput);
            if (assignmentsStudentChoiceInputInt == 0) {
                queriesMenu();
            }

        } while (assignmentsStudentChoiceInputInt < 0 || assignmentsStudentChoiceInputInt > realIndeces.size());

        int workingStudentRealIndex = realIndeces.get(assignmentsStudentChoiceInputInt - 1);

        ArrayList<Assignment> assignmentsPerStudentList = StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList();

        if (assignmentsPerStudentList.isEmpty()) {

            System.out.println("");
            System.out.println("");
            System.out.print("There are no Assignments available for this Student");
            System.out.println("");
            System.out.println("");

        } else {

            System.out.println("");
            System.out.println("Assignments of Student: " + StudentList.getStudentList().get(workingStudentRealIndex).getFirstName() + " " + StudentList.getStudentList().get(workingStudentRealIndex).getLastName());
            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Student / Title / Description / Submission Date");
            System.out.println("----------------------------------------------");

            for (int i = 0; i < assignmentsPerStudentList.size(); i++) {

                Assignment assignment = assignmentsPerStudentList.get(i);

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
        String assignmentsPerStudentString = assignmentsPerStudentInputFinish.nextLine();
        if (assignmentsPerStudentString.length() == 0) {
            Menus.QueriesMenu.queriesMenu();
        } else {
            Menus.QueriesMenu.queriesMenu();
        }
    }
}
