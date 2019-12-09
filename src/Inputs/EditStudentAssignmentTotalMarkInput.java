/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import Arrays.StudentList;
import Classes.Student;
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
public class EditStudentAssignmentTotalMarkInput {

    static ArrayList<Integer> realIndeces;

    static public void editStudentAssignmentTotalMarkInput() {

        Scanner editStudentAssignmentTotalMarkInputFinish = new Scanner(System.in);

// count total number of existing assignments assigned to Students
        int totalAssignments = 0;

        for (Student student : StudentList.getStudentList()) {
            totalAssignments += student.getStudentAssignmentList().getStudentAssignmentList().size();
        }

        if (totalAssignments == 0) { // Checks if there are available Students with Assignments to choose from
            System.out.println("");
            System.out.println("Currently there are not any Students with Assignments");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            String editStudentAssignmentTotalMarkInputFinishString = editStudentAssignmentTotalMarkInputFinish.nextLine();
            if (editStudentAssignmentTotalMarkInputFinishString.length() == 0) {
                addMenuInputInt = -1;
                addMenu();
            }
        }

        // Print list of Students
        int editStudentAssignmentTotalMarkStudentChoiceInputInt = -1;

        do {
            Scanner editStudentAssignmentTotalMarkStudentChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Students");
            System.out.println("-----------------------------------------  ");
            System.out.println("(Students with no Assignments are excluded)");

            /////////////
            // Dynamically prints a menu excluding Students with no assignments
            // In parallel, it creates an Array with the real indices of the printed options
            realIndeces = new ArrayList<>();
            for (int i = 0; i < StudentList.getStudentList().size(); i++) {
                if (StudentList.getStudentList().get(i).getStudentAssignmentList().getStudentAssignmentList().isEmpty() == false) {

                    realIndeces.add(i);

                    System.out.println((realIndeces.size()) + " - " + StudentList.getStudentList().get(i).getFirstName() + " " + StudentList.getStudentList().get(i).getLastName());
                }
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Student you want to edit his Total Mark in an Assignment: ");
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            editStudentAssignmentTotalMarkStudentChoiceInputInt = intRangeChecker(0, realIndeces.size(), editStudentAssignmentTotalMarkStudentChoiceInput);
            if (editStudentAssignmentTotalMarkStudentChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (editStudentAssignmentTotalMarkStudentChoiceInputInt < 0 || editStudentAssignmentTotalMarkStudentChoiceInputInt > realIndeces.size());

        int workingStudentRealIndex = realIndeces.get(editStudentAssignmentTotalMarkStudentChoiceInputInt - 1);

        // Prints a menu with the the Student's Assignments along their current Total Mark       
        int editStudentAssignmentTotalMarkAssignmentChoiceInputInt = -1;
        int maxMenuValue;
        do {
            Scanner editStudentAssignmentTotalMarkAssignmentChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Assignments for this Student");
            System.out.println("--------------------------------------");
            System.out.println("");
            System.out.println("No / Assignment Title / Total Mark (0 = No Mark)");
            System.out.println("-----------------------------------------------");

            realIndeces = new ArrayList<>();
            for (int i = 0; i < StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().size(); i++) {
                System.out.println((i + 1) + ") " + StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().get(i).getTitle() + " - Total Mark: " + StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().get(i).getTotalMark());
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Assignment you want to edit his Total Mark in an Assignment: ");
            maxMenuValue = StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().size();
            System.out.print("Please Select (0-" + maxMenuValue + "): ");

            editStudentAssignmentTotalMarkAssignmentChoiceInputInt = intRangeChecker(0, maxMenuValue, editStudentAssignmentTotalMarkAssignmentChoiceInput);
            if (editStudentAssignmentTotalMarkAssignmentChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (editStudentAssignmentTotalMarkAssignmentChoiceInputInt < 0 || editStudentAssignmentTotalMarkAssignmentChoiceInputInt > maxMenuValue);

        int workingAssignmentRealIndex = editStudentAssignmentTotalMarkAssignmentChoiceInputInt - 1;

// Request new Total Mark
        int editStudentAssignmentTotalMarkNewTotalMarkInputInt = -1;

        do {
            Scanner editStudentAssignmentTotalMarkNewTotalMarkInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Input new Total Mark");
            System.out.print("Please Select (0-10): ");

            editStudentAssignmentTotalMarkNewTotalMarkInputInt = intRangeChecker(0, 10, editStudentAssignmentTotalMarkNewTotalMarkInput);

        } while (editStudentAssignmentTotalMarkNewTotalMarkInputInt < 0 || editStudentAssignmentTotalMarkNewTotalMarkInputInt > 10);

        // Set the new Total Mark  
        StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().get(workingAssignmentRealIndex).setTotalMark(editStudentAssignmentTotalMarkNewTotalMarkInputInt);
        System.out.println("");
        System.out.println("The Student's Total Mark for this assignment has been updated!");

        // Ask if users wants to repeat last action
        inputRepeater(addMenuInputInt);

    }

}
