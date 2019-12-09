/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import Arrays.CourseList;
import Arrays.CourseTrainerList;
import Arrays.TrainerList;
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
public class AssignTrainerToCourseInput {

    static ArrayList<Integer> realIndeces;

    static public void assignTrainerToCourseInput() {

        Scanner assignTrainerToCourseInputFinish = new Scanner(System.in);

        if (CourseList.getCourseList().isEmpty() || TrainerList.getTrainerList().isEmpty()) { // Checks if there are available Courses and Trainers to choose from
            System.out.println("");
            System.out.println("In order to assign a Trainer to a Course,");
            System.out.println("you need to create at least one from each!");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            String assignTrainerToCourseInputFinishString = assignTrainerToCourseInputFinish.nextLine();
            if (assignTrainerToCourseInputFinishString.length() == 0) {
                addMenuInputInt = -1;
                addMenu();
            } else {
                addMenuInputInt = -1;
                addMenu();
            }
        }

        // Print list of Courses
        int assignTrainerToCourse_CourseChoiceInputInt = -1;

        do {
            Scanner assignTrainerToCourse_CourseChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Courses");
            System.out.println("-----------------");
            for (int i = 0; i < CourseList.getCourseList().size(); i++) {
                System.out.println((i + 1) + " - " + CourseList.getCourseList().get(i).getTitle());
            }
            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Course you want to assign a Trainer to");
            System.out.print("Please Select (0-" + CourseList.getCourseList().size() + "): ");

            assignTrainerToCourse_CourseChoiceInputInt = intRangeChecker(0, CourseList.getCourseList().size(), assignTrainerToCourse_CourseChoiceInput);
            if (assignTrainerToCourse_CourseChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (assignTrainerToCourse_CourseChoiceInputInt < 0 || assignTrainerToCourse_CourseChoiceInputInt > CourseList.getCourseList().size());

        int workingCourseRealIndex = assignTrainerToCourse_CourseChoiceInputInt - 1;

        // Print list of Trainers
        int assignTrainerToCourse_TrainerChoiceInputInt = -1;

        do {
            Scanner assignTrainerToCourse_TrainerChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("Available Trainers");
            System.out.println("---------------------------------------------------------------");
            System.out.println("(Trainers who are already assigned to this course are excluded)");
            System.out.println("");
            /////////////
            // Dynamically prints a menu excluding Trainers that are already assigned to the chosen Course
            // In parallel, it creates an Array with the real indices of the printed options
            realIndeces = new ArrayList<>();
            for (int i = 0; i < TrainerList.getTrainerList().size(); i++) {
                if (CourseList.getCourseList().get(workingCourseRealIndex).getCourseTrainerList().getCourseTrainerList().contains(TrainerList.getTrainerList().get(i)) == false) {

                    realIndeces.add(i);

                    System.out.println((realIndeces.size()) + ") " + TrainerList.getTrainerList().get(i).getFirstName() + " " + TrainerList.getTrainerList().get(i).getLastName());
                }
            }

            if (realIndeces.isEmpty()) {
                System.out.println("No more available Trainers for this Course");
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Trainer you want to assign to course: " + CourseList.getCourseList().get(workingCourseRealIndex).getTitle());
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            assignTrainerToCourse_TrainerChoiceInputInt = intRangeChecker(0, realIndeces.size(), assignTrainerToCourse_TrainerChoiceInput);
            if (assignTrainerToCourse_TrainerChoiceInputInt == 0) {
                addMenuInputInt = -1;
                addMenu();
            }

        } while (assignTrainerToCourse_TrainerChoiceInputInt < 0 || assignTrainerToCourse_TrainerChoiceInputInt > realIndeces.size());

        int workingTrainerRealIndex = realIndeces.get(assignTrainerToCourse_TrainerChoiceInputInt - 1);

// Gets current Trainer List of the Course
        CourseTrainerList currentList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseTrainerList();
// Adds the selected trainer to that list
        currentList.getCourseTrainerList().add(TrainerList.getTrainerList().get(workingTrainerRealIndex));
// Updates the saved list
        CourseList.getCourseList().get(workingCourseRealIndex).setCourseTrainerList(currentList);
        System.out.println("");
        System.out.print("Trainer " + TrainerList.getTrainerList().get(workingTrainerRealIndex).getFirstName() + " " + TrainerList.getTrainerList().get(workingTrainerRealIndex).getLastName());
        System.out.println(" has been assigned to Course: " + CourseList.getCourseList().get(workingCourseRealIndex).getTitle());

        // Ask if users wants to repeat last action
        inputRepeater(addMenuInputInt);

    }

}
