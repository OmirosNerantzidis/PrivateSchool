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
public class CourseTrainerList {

    private ArrayList<Trainer> courseTrainerList = new ArrayList<>();

    public CourseTrainerList() {
    }

    public ArrayList<Trainer> getCourseTrainerList() {
        return courseTrainerList;
    }

    public void setCourseTrainerList(ArrayList<Trainer> courseTrainerList) {
        this.courseTrainerList = courseTrainerList;
    }

}
