/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.CourseList;
import Classes.Trainer;
import static Menus.QueriesMenu.queriesMenu;
import static Tools.IntRangeChecker.intRangeChecker;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class TrainersPerCourse {

    static ArrayList<Integer> realIndeces;

    public static void trainersPerCourse() {

        Scanner trainersPerCourseInputFinish = new Scanner(System.in);

        // Print list of Courses
        if (CourseList.getCourseList().isEmpty()) { // Checks if there are available Courses to choose from
            System.out.println("");
            System.out.println("");
            System.out.println("There are no Courses available to show trainers for.");
            System.out.println("");
            System.out.println("Press Enter to go to the previous menu");
            System.out.println("");
            System.out.println("");
            String trainersPerCourseString = trainersPerCourseInputFinish.nextLine();
            if (trainersPerCourseString.length() == 0) {
                Menus.QueriesMenu.queriesMenu();
            } else {
                Menus.QueriesMenu.queriesMenu();
            }
        }
        int trainersCourseChoiceInputInt = -1;

        do {
            Scanner trainersCourseChoiceInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("");
            System.out.println("Available Courses with at least 1 trainer");
            System.out.println("--------------------------------------------");

            // Dynamically prints a menu excluding Courses that don't have trainers
            // In parallel, it creates an Array with the real indices of the printed options
            realIndeces = new ArrayList<>();
            for (int i = 0; i < CourseList.getCourseList().size(); i++) {
                if (CourseList.getCourseList().get(i).getCourseTrainerList().getCourseTrainerList().size() > 0) {

                    realIndeces.add(i);

                    System.out.println((realIndeces.size()) + ") " + CourseList.getCourseList().get(i).getTitle());
                }
            }

            if (realIndeces.isEmpty()) {
                System.out.println("None of the Courses have trainers set");
            }

            System.out.println("");
            System.out.println("0 - Back to previous menu");
            System.out.println("");
            System.out.println("Choose the number of the Course you want to see its Trainers");
            System.out.print("Please Select (0-" + realIndeces.size() + "): ");

            trainersCourseChoiceInputInt = intRangeChecker(0, realIndeces.size(), trainersCourseChoiceInput);
            if (trainersCourseChoiceInputInt == 0) {
                queriesMenu();
            }

        } while (trainersCourseChoiceInputInt < 0 || trainersCourseChoiceInputInt > realIndeces.size());

        int workingCourseRealIndex = realIndeces.get(trainersCourseChoiceInputInt - 1);

        ArrayList<Trainer> trainersPerCourseList = CourseList.getCourseList().get(workingCourseRealIndex).getCourseTrainerList().getCourseTrainerList();

        if (trainersPerCourseList.isEmpty()) {

            System.out.println("");
            System.out.println("");
            System.out.print("There are no Trainers available for this Course");
            System.out.println("");
            System.out.println("");

        } else {

            System.out.println("");
            System.out.println("Trainers of Course: " + CourseList.getCourseList().get(workingCourseRealIndex).getTitle());
            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Name / Subject");
            System.out.println("--------------");

            for (int i = 0; i < trainersPerCourseList.size(); i++) {

                Trainer trainer = trainersPerCourseList.get(i);

                System.out.println((i + 1) + ") " + trainer.getFirstName() + " "
                        + trainer.getLastName() + " / "
                        + trainer.getSubject());
            }
        }

        System.out.println("");
        System.out.println("Press Enter to go to the previous menu");
        System.out.println("");
        System.out.println("");
        String trainersPerCourseString = trainersPerCourseInputFinish.nextLine();
        if (trainersPerCourseString.length() == 0) {
            Menus.QueriesMenu.queriesMenu();
        } else {
            Menus.QueriesMenu.queriesMenu();
        }
    }
}
