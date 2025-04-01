package at.technikum.w3resourceOOP.exercise14;

import java.util.ArrayList;

public class School {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<SchoolClass> classes;

    public School() {
        this.students = new ArrayList<Student>();
        this.teachers = new ArrayList<Teacher>();
        this.classes = new ArrayList<SchoolClass>();
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
    }

    public void addClass(SchoolClass schoolClass) {
        this.classes.add(schoolClass);
    }

    public void removeClass(SchoolClass schoolClass) {
        this.classes.remove(schoolClass);
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<SchoolClass> getClasses() {
        return classes;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }
}
