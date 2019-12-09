/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.StudentList;
import Classes.Student;
import static Tools.DateFormatter.dateFormatter;
import static Tools.EmptyListChecker.emptyListChecker;
import static Tools.EnterToContinue.enterToContinue;

/**
 *
 * @author omiro
 */
public class StudentListPrint {

    public static void studentListPrint() {

        System.out.println("");
        System.out.println("Students");
        System.out.println("--------");
        System.out.println("");
        System.out.println("Name / Date of Birth / Tuition Fees");
        System.out.println("-----------------------------------------------------");

        boolean listIsEmpty = emptyListChecker(StudentList.getStudentList());

        if (listIsEmpty == false) {

            int count = 0;

            for (Student student : StudentList.getStudentList()) {
                count++;
                System.out.println(count + ") " + student.getFirstName() + " "
                        + student.getLastName() + " / "
                        + dateFormatter(student.getDateOfBirth()) + " / "
                        + student.getTuitionFees());
            }
        }

        enterToContinue();
        Menus.QueriesMenu.queriesMenu();

    }

}
