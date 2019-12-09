/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Arrays.StudentAssignmentList;
import java.util.Date;

/**
 *
 * @author omiro
 */
public class Student {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private double tuitionFees;

    private StudentAssignmentList studentAssignmentList = new StudentAssignmentList();

    public Student(String firstName, String lastName, Date dateOfBirth, double tuitionFees, StudentAssignmentList studentAssignmentList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        this.studentAssignmentList = studentAssignmentList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public StudentAssignmentList getStudentAssignmentList() {
        return studentAssignmentList;
    }

    public void setStudentAssignmentList(StudentAssignmentList studentAssignmentList) {
        this.studentAssignmentList = studentAssignmentList;
    }

}
