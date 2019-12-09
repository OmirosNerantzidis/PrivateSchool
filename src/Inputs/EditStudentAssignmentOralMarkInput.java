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
public class EditStudentAssignmentOralMarkInput {

    static ArrayList<Integer> realIndeces;

    static public void editStudentAssignmentOralMarkInput() {

        Scanner editStudentAssignmentOralMarkInputFinish = new Scanner(System.in);

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
            String editStudentAssignmentOralMarkInputFinishString = editStudentAssignmentOralMarkInputFinish.nextLine();
            if (editStudentAssignmentOralMarkInputFinishString.length() == 0) {
                addMenuInputInt = -1;
                addMenu();
            }
        }

        // Print list of Students
        int editStudentAssignmentOralMarkStudentChoiceInputInt = -1;

        do {
            Scanner editStudentAssignmentOralMarkStudentChoiceInput = new Scanner(System.in);

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
            System.out.println("Choose the number of the Student you want to edit his Oral Mark in an Assignment: ");
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            editStudentAssignmentOralMarkStudentChoiceInputInt = intRangeChecker(0, realIndeces.size(), editStudentAssignmentOralMarkStudentChoiceInput);
            if (editStudentAssignmentOralMarkStudentChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (editStudentAssignmentOralMarkStudentChoiceInputInt < 0 || editStudentAssignmentOralMarkStudentChoiceInputInt > realIndeces.size());

        int workingStudentRealIndex = realIndeces.get(editStudentAssignmentOralMarkStudentChoiceInputInt - 1);

        // Prints a menu with the the Student's Assignments along their current Oral Mark       
        int editStudentAssignmentOralMarkAssignmentChoiceInputInt = -1;
        int maxMenuValue;
        do {
            Scanner editStudentAssignmentOralMarkAssignmentChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Assignments for this Student");
            System.out.println("--------------------------------------");
            System.out.println("");
            System.out.println("No / Assignment Title / Oral Mark (0 = No Mark)");
            System.out.println("-----------------------------------------------");

            realIndeces = new ArrayList<>();
            for (int i = 0; i < StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().size(); i++) {
                System.out.println((i + 1) + ") " + StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().get(i).getTitle() + " - Oral Mark: " + StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().get(i).getOralMark());
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Assignment you want to edit his Oral Mark in an Assignment: ");
            maxMenuValue = StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().size();
            System.out.print("Please Select (0-" + maxMenuValue + "): ");

            editStudentAssignmentOralMarkAssignmentChoiceInputInt = intRangeChecker(0, maxMenuValue, editStudentAssignmentOralMarkAssignmentChoiceInput);
            if (editStudentAssignmentOralMarkAssignmentChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (editStudentAssignmentOralMarkAssignmentChoiceInputInt < 0 || editStudentAssignmentOralMarkAssignmentChoiceInputInt > maxMenuValue);

        int workingAssignmentRealIndex = editStudentAssignmentOralMarkAssignmentChoiceInputInt - 1;

// Request new Oral Mark
        int editStudentAssignmentOralMarkNewOralMarkInputInt = -1;

        do {
            Scanner editStudentAssignmentOralMarkNewOralMarkInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Input new Oral Mark");
            System.out.print("Please Select (0-10): ");

            editStudentAssignmentOralMarkNewOralMarkInputInt = intRangeChecker(0, 10, editStudentAssignmentOralMarkNewOralMarkInput);

        } while (editStudentAssignmentOralMarkNewOralMarkInputInt < 0 || editStudentAssignmentOralMarkNewOralMarkInputInt > 10);

        // Set the new Oral Mark  
        StudentList.getStudentList().get(workingStudentRealIndex).getStudentAssignmentList().getStudentAssignmentList().get(workingAssignmentRealIndex).setOralMark(editStudentAssignmentOralMarkNewOralMarkInputInt);
        System.out.println("");
        System.out.println("The Student's Oral Mark for this assignment has been updated!");

        // Ask if users wants to repeat last action
        inputRepeater(addMenuInputInt);

    }

}
