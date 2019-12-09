/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import Classes.Course;
import java.util.ArrayList;

/**
 *
 * @author omiro
 */
public class CourseList {

    private static ArrayList<Course> courseList = new ArrayList<>();

    public CourseList() {
    }

    public static ArrayList<Course> getCourseList() {
        return courseList;
    }

    public static void setCourseList(ArrayList<Course> courseList) {
        CourseList.courseList = courseList;
    }

}
