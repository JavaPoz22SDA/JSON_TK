package pl.sda.student;

import java.util.ArrayList;
import java.util.List;

public class StudentsManager {

    private String name;
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public String delStudent(Student s) {
        if (students.remove(s))
            return "Usunięto studenta.";
        else
            return "Brak studenta na liście.";
    }

    public void displayStudents() {
        for (Student s : students) {
            System.out.println("  - " + s.toString());
        }

    }

    public void saveToFile() {


    }
}
