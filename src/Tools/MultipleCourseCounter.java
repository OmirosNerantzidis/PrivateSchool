/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Arrays.CourseList;
import Arrays.StudentList;
import Classes.Course;
import Classes.Student;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author omiro
 */
public class MultipleCourseCounter {

    public static ArrayList multipleCourseCounter() {

        // We create a Map, with Students as keys, and all values to 0
        HashMap<Student, Integer> studentCourseCounterMap = new HashMap<>();

        for (Student student : StudentList.getStudentList()) {
            studentCourseCounterMap.put(student, 0);
        }

        // Then we get all Student Lists from each course, and each time
        // we encounter a Student, we increase his value by 1 in the Map
        for (Course course : CourseList.getCourseList()) {

            for (Student student : course.getCourseStudentList().getCourseStudentList()) {
                int currentCount = studentCourseCounterMap.get(student); // We get the student's current count from the Map
                currentCount++; // We increase it by 1
                studentCourseCounterMap.put(student, currentCount); // and put it back in the Map
            }

        }

        // Finally we create an ArrayList with all the Students who have 2 or more value in the Map
        ArrayList<Student> multipleCourseStudents = new ArrayList<>();

        for (Student student : StudentList.getStudentList()) {
            int currentCount = studentCourseCounterMap.get(student);
            if (currentCount >= 2) {
                multipleCourseStudents.add(student);
            }
        }

        return multipleCourseStudents;

    }

}
