/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;

/**
 *
 * @author omiro
 */
public class EmptyListChecker {

    public static <E> boolean emptyListChecker(ArrayList<E> list) {
        if (list.isEmpty()) {
            System.out.println("");
            System.out.println("There is nothing to display at the moment");
            return true;
        } else {
            return false;
        }

    }

}
