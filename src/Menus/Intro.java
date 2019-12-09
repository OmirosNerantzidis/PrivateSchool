/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import static Tools.IntRangeChecker.intRangeChecker;
import static Tools.PremadeDataCreator.premadeDataCreator;
import java.util.Scanner;

/**
 *
 * @author omiro
 */
public class Intro {

    public static void intro() {

        int introInputInt = -1;

        do {

            Scanner introInput = new Scanner(System.in);

            System.out.println("");
            System.out.println("* HOW THE PREMADE DATA ARE SETUP");
            System.out.println("--------------------------------");
            System.out.println("(3 Courses, 3 Trainers, 5 Students)");
            System.out.println("(Course 1 has 3 Assignments, Student 1 & 2, Trainer 11 & 12)");
            System.out.println("(Course 2 has 0 Assignments, Student 3 & 4, Trainer 21)");
            System.out.println("(Course 3 has 2 Assignments, Student 1 & 5, No Trainer)");
            System.out.println("");
            System.out.println("");
            System.out.println("START MENU");
            System.out.println("----------");
            System.out.println("1 - Manual inputs with optional Random-generated");
            System.out.println("    real-world entries per field");
            System.out.println("");
            System.out.println("2 - Like [1] but also starts with a premade* pack of Data");
            System.out.println("    with position markers for testing purposes");
            System.out.println("");

            System.out.print("Please Select (1-2): ");

            introInputInt = intRangeChecker(1, 2, introInput);

        } while (introInputInt < 1 || introInputInt > 2);

        switch (introInputInt) {
            case 1:
                Menus.MainMenu.mainMenu();
                break;
            case 2:
                premadeDataCreator();
                Menus.MainMenu.mainMenu();
                break;
            case 0:
                System.out.println("");
                System.out.println("Goodbye!");
                System.out.println("");
                break;
            default:
                System.out.println("");
                System.out.println("Wrong input, try again!");
                System.out.println("");

        }

    }
}
