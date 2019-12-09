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
public class StudentList {

    private static ArrayList<Student> studentList = new ArrayList<>();

    public StudentList() {
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<Student> studentList) {
        StudentList.studentList = studentList;
    }

}
