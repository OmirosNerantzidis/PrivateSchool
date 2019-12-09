/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queries;

import Arrays.CourseList;
import Arrays.StudentList;
import Classes.Course;
import Classes.Student;
import static Tools.EmptyListChecker.emptyListChecker;
import static Tools.EnterToContinue.enterToContinue;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author omiro
 */
public class MultipleCourseStudentsPrint {

    public static void multipleCourseStudentsPrint() {

        System.out.println("");
        System.out.println("Students that follow more than 1 courses");
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println("Name / Number of Courses");
        System.out.println("------------------------");

        boolean listIsEmpty = emptyListChecker(StudentList.getStudentList());

        Map<Student, Integer> coursesPerStudentMap = new HashMap();

        for (Course course : CourseList.getCourseList()) {

            for (Student student : course.getCourseStudentList().getCourseStudentList()) {

                if (coursesPerStudentMap.containsKey(student)) {
                    int currentStudentCourseCount = coursesPerStudentMap.get(student);
                    currentStudentCourseCount++;
                    coursesPerStudentMap.put(student, currentStudentCourseCount);
                } else {
                    coursesPerStudentMap.put(student, 1);
                }

            }

        }

        coursesPerStudentMap.forEach(
                (k, v)
                -> {
            int count = 0;
            if (v > 1) {
                count++;
                System.out.println(count + ") " + k.getFirstName() + " "
                        + k.getLastName() + " / "
                        + v);
            }
        }
        );

        enterToContinue();
        Menus.QueriesMenu.queriesMenu();

    }

}
