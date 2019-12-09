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
public class StudentAssignmentList {

    private ArrayList<Assignment> studentAssignmentList = new ArrayList<>();

    public StudentAssignmentList() {
    }

    public ArrayList<Assignment> getStudentAssignmentList() {
        return studentAssignmentList;
    }

    public void setStudentAssignmentList(ArrayList<Assignment> studentAssignmentList) {
        this.studentAssignmentList = studentAssignmentList;
    }

}
