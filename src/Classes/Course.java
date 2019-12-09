/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Arrays.CourseAssignmentList;
import Arrays.CourseStudentList;
import Arrays.CourseTrainerList;
import java.util.Date;

/**
 *
 * @author omiro
 */
public class Course {

    private String title;
    private String stream;
    private String type;
    private Date start_date;
    private Date end_date;
    private CourseAssignmentList courseAssignmentList = new CourseAssignmentList();
    private CourseTrainerList courseTrainerList = new CourseTrainerList();
    private CourseStudentList courseStudentList = new CourseStudentList();

    public Course(String title, String stream, String type, Date start_date, Date end_date, CourseAssignmentList courseAssignmentList, CourseTrainerList courseTrainerList, CourseStudentList courseStudentList) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
        this.courseAssignmentList = courseAssignmentList;
        this.courseTrainerList = courseTrainerList;
        this.courseStudentList = courseStudentList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public CourseAssignmentList getCourseAssignmentList() {
        return courseAssignmentList;
    }

    public void setCourseAssignmentList(CourseAssignmentList courseAssignmentList) {
        this.courseAssignmentList = courseAssignmentList;
    }

    public CourseTrainerList getCourseTrainerList() {
        return courseTrainerList;
    }

    public void setCourseTrainerList(CourseTrainerList courseTrainerList) {
        this.courseTrainerList = courseTrainerList;
    }

    public CourseStudentList getCourseStudentList() {
        return courseStudentList;
    }

    public void setCourseStudentList(CourseStudentList courseStudentList) {
        this.courseStudentList = courseStudentList;
    }

}
