/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Arrays.CourseAssignmentList;
import Arrays.CourseList;
import Arrays.CourseStudentList;
import Arrays.CourseTrainerList;
import Arrays.StudentAssignmentList;
import Arrays.StudentList;
import Arrays.TrainerList;
import Classes.Assignment;
import Classes.Course;
import Classes.Student;
import Classes.Trainer;
import static Tools.ParseDate.parseDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author omiro
 */
public class PremadeDataCreator {

    public static void premadeDataCreator() {

        Date assignment11SubDate = parseDate("2019-08-20");
        Date assignment12SubDate = parseDate("2019-09-20");
        Date assignment13SubDate = parseDate("2019-10-20");

        Date assignment31SubDate = parseDate("2019-09-28");
        Date assignment32SubDate = parseDate("2019-10-28");

        Assignment assignment11 = new Assignment("C1-A1-Title",
                "C1-A1-Description",
                assignment11SubDate,
                0,
                0
        );

        Assignment assignment12 = new Assignment("C1-A2-Title",
                "C1-A2-Description",
                assignment12SubDate,
                0,
                0
        );

        Assignment assignment13 = new Assignment("C1-A3-Title",
                "C1-A3-Description",
                assignment13SubDate,
                0,
                0
        );

        Assignment assignment31 = new Assignment("C3-A1-Title",
                "C3-A1-Description",
                assignment31SubDate,
                0,
                0
        );

        Assignment assignment32 = new Assignment("C3-A2-Title",
                "C1-A3-Description",
                assignment32SubDate,
                0,
                0
        );

        ArrayList<Assignment> assignmentInput = new ArrayList<>();
        ArrayList<Assignment> assignmentInput3 = new ArrayList<>();

        assignmentInput.clear();
        assignmentInput.add(assignment11);
        assignmentInput.add(assignment12);
        assignmentInput.add(assignment13);
        CourseAssignmentList course1AssignmentList = new CourseAssignmentList();
        course1AssignmentList.setCourseAssignmentList(assignmentInput);

        CourseAssignmentList course2AssignmentList = new CourseAssignmentList();

        assignmentInput3.clear();
        assignmentInput3.add(assignment31);
        assignmentInput3.add(assignment32);
        CourseAssignmentList course3AssignmentList = new CourseAssignmentList();
        course3AssignmentList.setCourseAssignmentList(assignmentInput3);

        Trainer trainer11 = new Trainer(
                "Trainer-11-FirstName",
                "Trainer-11-LastName",
                "Trainer-11-Subject"
        );

        Trainer trainer12 = new Trainer(
                "Trainer-12-FirstName",
                "Trainer-12-LastName",
                "Trainer-12-Subject"
        );

        Trainer trainer21 = new Trainer(
                "Trainer-21-FirstName",
                "Trainer-21-LastName",
                "Trainer-21-Subject"
        );

        ArrayList<Trainer> trainerInput = new ArrayList<>();
        ArrayList<Trainer> trainerInput2 = new ArrayList<>();

        trainerInput.clear();
        trainerInput.add(trainer11);
        trainerInput.add(trainer12);
        CourseTrainerList course1TrainerList = new CourseTrainerList();
        course1TrainerList.setCourseTrainerList(trainerInput);

        trainerInput2.clear();
        trainerInput2.add(trainer21);
        CourseTrainerList course2TrainerList = new CourseTrainerList();
        course2TrainerList.setCourseTrainerList(trainerInput2);

        CourseTrainerList course3TrainerList = new CourseTrainerList();

        TrainerList.getTrainerList().add(trainer11);
        TrainerList.getTrainerList().add(trainer12);
        TrainerList.getTrainerList().add(trainer21);

        Date student1BirthDate = parseDate("1979-08-20");
        Date student2BirthDate = parseDate("1980-09-21");
        Date student3BirthDate = parseDate("1981-10-22");
        Date student4BirthDate = parseDate("1982-11-23");
        Date student5BirthDate = parseDate("1983-12-24");

        Assignment student1assignment11 = new Assignment("C1-A1-Title",
                "C1-A1-Description",
                assignment11SubDate,
                0,
                0
        );

        Assignment student1assignment12 = new Assignment("C1-A2-Title",
                "C1-A2-Description",
                assignment12SubDate,
                0,
                0
        );

        Assignment student1assignment13 = new Assignment("C1-A3-Title",
                "C1-A3-Description",
                assignment13SubDate,
                0,
                0
        );

        Assignment student2assignment11 = new Assignment("C1-A1-Title",
                "C1-A1-Description",
                assignment11SubDate,
                0,
                0
        );

        Assignment student2assignment12 = new Assignment("C1-A2-Title",
                "C1-A2-Description",
                assignment12SubDate,
                0,
                0
        );

        Assignment student2assignment13 = new Assignment("C1-A3-Title",
                "C1-A3-Description",
                assignment13SubDate,
                0,
                0
        );

        Assignment student1assignment31 = new Assignment("C3-A1-Title",
                "C3-A1-Description",
                assignment31SubDate,
                0,
                0
        );

        Assignment student1assignment32 = new Assignment("C3-A2-Title",
                "C3-A2-Description",
                assignment32SubDate,
                0,
                0
        );
        Assignment student5assignment31 = new Assignment("C3-A1-Title",
                "C3-A1-Description",
                assignment31SubDate,
                0,
                0
        );

        Assignment student5assignment32 = new Assignment("C3-A2-Title",
                "C3-A2-Description",
                assignment32SubDate,
                0,
                0
        );
        ArrayList<Assignment> studentAssignmentInput = new ArrayList<>();
        ArrayList<Assignment> studentAssignmentInput2 = new ArrayList<>();
        ArrayList<Assignment> studentAssignmentInput5 = new ArrayList<>();

        studentAssignmentInput.clear();
        studentAssignmentInput.add(student1assignment11);
        studentAssignmentInput.add(student1assignment12);
        studentAssignmentInput.add(student1assignment13);
        studentAssignmentInput.add(student1assignment31);
        studentAssignmentInput.add(student1assignment32);

        StudentAssignmentList student1AssignmentList = new StudentAssignmentList();
        student1AssignmentList.setStudentAssignmentList(studentAssignmentInput);

        studentAssignmentInput2.clear();
        studentAssignmentInput2.add(student2assignment11);
        studentAssignmentInput2.add(student2assignment12);
        studentAssignmentInput2.add(student2assignment13);
        StudentAssignmentList student2AssignmentList = new StudentAssignmentList();
        student2AssignmentList.setStudentAssignmentList(studentAssignmentInput2);

        StudentAssignmentList student3AssignmentList = new StudentAssignmentList();

        StudentAssignmentList student4AssignmentList = new StudentAssignmentList();

        studentAssignmentInput5.clear();
        studentAssignmentInput5.add(student5assignment31);
        studentAssignmentInput5.add(student5assignment32);
        StudentAssignmentList student5AssignmentList = new StudentAssignmentList();
        student5AssignmentList.setStudentAssignmentList(studentAssignmentInput5);

//        System.out.println(student1AssignmentList.getStudentAssignmentList().size());
//        System.out.println(student2AssignmentList.getStudentAssignmentList().size());
//        System.out.println(student3AssignmentList.getStudentAssignmentList().size());
//        System.out.println(student4AssignmentList.getStudentAssignmentList().size());
//        System.out.println(student5AssignmentList.getStudentAssignmentList().size());
        Student student1 = new Student(
                "Student-1-FirstName",
                "Student-1-LastName",
                student1BirthDate,
                1900.50,
                student1AssignmentList
        );

        Student student2 = new Student(
                "Student-2-FirstName",
                "Student-2-LastName",
                student2BirthDate,
                2000.50,
                student2AssignmentList
        );

        Student student3 = new Student(
                "Student-3-FirstName",
                "Student-3-LastName",
                student3BirthDate,
                2100.50,
                student3AssignmentList
        );

        Student student4 = new Student(
                "Student-4-FirstName",
                "Student-4-LastName",
                student4BirthDate,
                2200.50,
                student4AssignmentList
        );

        Student student5 = new Student(
                "Student-5-FirstName",
                "Student-5-LastName",
                student5BirthDate,
                2300.50,
                student5AssignmentList
        );

        CourseStudentList course1StudentList = new CourseStudentList();
        CourseStudentList course2StudentList = new CourseStudentList();
        CourseStudentList course3StudentList = new CourseStudentList();

        ArrayList<Student> studentInput = new ArrayList<>();
        ArrayList<Student> studentInput2 = new ArrayList<>();
        ArrayList<Student> studentInput3 = new ArrayList<>();

        studentInput.clear();
        studentInput.add(student1);
        studentInput.add(student2);

        course1StudentList = new CourseStudentList();
        course1StudentList.setCourseStudentList(studentInput);

        studentInput2.clear();
        studentInput2.add(student3);
        studentInput2.add(student4);

        course2StudentList = new CourseStudentList();
        course2StudentList.setCourseStudentList(studentInput2);

        studentInput3.clear();
        studentInput3.add(student1);
        studentInput3.add(student5);

        course3StudentList = new CourseStudentList();
        course3StudentList.setCourseStudentList(studentInput3);

        StudentList.getStudentList().add(student1);
        StudentList.getStudentList().add(student2);
        StudentList.getStudentList().add(student3);
        StudentList.getStudentList().add(student4);
        StudentList.getStudentList().add(student5);

        Date course1StartDate = parseDate("2019-07-20");
        Date course1EndDate = parseDate("2019-12-20");

        Date course2StartDate = parseDate("2019-08-20");
        Date course2EndDate = parseDate("2020-01-20");

        Date course3StartDate = parseDate("2019-09-20");
        Date course3EndDate = parseDate("2020-02-20");

        Course course1 = new Course(
                "C1-Title",
                "C1-Stream",
                "C1-Type",
                course1StartDate,
                course1EndDate,
                course1AssignmentList,
                course1TrainerList,
                course1StudentList
        );

        Course course2 = new Course(
                "C2-Title",
                "C2-Stream",
                "C2-Type",
                course2StartDate,
                course2EndDate,
                course2AssignmentList,
                course2TrainerList,
                course2StudentList
        );

        Course course3 = new Course(
                "C3-Title",
                "C3-Stream",
                "C3-Type",
                course3StartDate,
                course3EndDate,
                course3AssignmentList,
                course3TrainerList,
                course3StudentList
        );

        CourseList.getCourseList().add(course1);
        CourseList.getCourseList().add(course2);
        CourseList.getCourseList().add(course3);

    }
}
