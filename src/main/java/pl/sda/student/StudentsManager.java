package pl.sda.student;

import java.util.ArrayList;
import java.util.List;

public class StudentsManager {

    private String name;
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }

    public void delStudent(String firsName, String lastName){


    }

    public void displayStudents(){
        for (Student s:students) {
            System.out.println("  - " + s.toString());
        }

    }

    public void saveToFile(){


    }
}
