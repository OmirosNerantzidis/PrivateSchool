/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import Classes.Assignment;
import java.util.ArrayList;

/**
 *
 * @author omiro
 */
public class CourseAssignmentList {

    private ArrayList<Assignment> courseAssignmentList = new ArrayList<>();

    public CourseAssignmentList() {
    }

    public ArrayList<Assignment> getCourseAssignmentList() {
        return courseAssignmentList;
    }

    public void setCourseAssignmentList(ArrayList<Assignment> courseAssignmentList) {
        this.courseAssignmentList = courseAssignmentList;
    }

}
