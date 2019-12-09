/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import Classes.Trainer;
import java.util.ArrayList;

/**
 *
 * @author omiro
 */
public class TrainerList {

    private static ArrayList<Trainer> trainerList = new ArrayList<>();

    public TrainerList() {
    }

    public static ArrayList<Trainer> getTrainerList() {
        return trainerList;
    }

    public static void setTrainerList(ArrayList<Trainer> trainerList) {
        TrainerList.trainerList = trainerList;
    }

}
