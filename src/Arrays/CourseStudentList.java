/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import Classes.Student;
import java.util.ArrayList;

/**
 *
 * @author omiro
 */
public class CourseStudentList {

    private ArrayList<Student> courseStudentList = new ArrayList<>();

    public CourseStudentList() {
    }

    public ArrayList<Student> getCourseStudentList() {
        return courseStudentList;
    }

    public void setCourseStudentList(ArrayList<Student> courseStudentList) {
        this.courseStudentList = courseStudentList;
    }

}
