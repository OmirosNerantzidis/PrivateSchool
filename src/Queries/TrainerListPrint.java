/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.StudentList;
import Arrays.TrainerList;
import Classes.Trainer;
import static Tools.DateFormatter.dateFormatter;
import static Tools.EmptyListChecker.emptyListChecker;
import static Tools.EnterToContinue.enterToContinue;

/**
 *
 * @author omiro
 */
public class TrainerListPrint {

    public static void trainerListPrint() {

        System.out.println("");
        System.out.println("Trainers");
        System.out.println("-----------");
        System.out.println("");
        System.out.println("First Name - Last Name - Subject");
        System.out.println("-----------------------------------------------------");

        boolean listIsEmpty = emptyListChecker(TrainerList.getTrainerList());

        if (listIsEmpty == false) {

            int count = 0;

            for (Trainer trainer : TrainerList.getTrainerList()) {

                count++;

                System.out.println(count + ") " + trainer.getFirstName() + " " + trainer.getLastName() + " - " + trainer.getSubject());
            }
        }

        enterToContinue();
        Menus.QueriesMenu.queriesMenu();

    }

}
