package pl.sda.student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentsManager {

    private String name;
    /**
     * Lista studentów
     */
    private List<Student> students = new ArrayList<>();
    private Path file = Paths.get("Students.json");

    /**
     * Dodaje @Student do listy @students (bez zmian w pliku)
     * @param s @see {@link Student}
     * @return Info o sukcesie
     */
    public String addStudent(Student s) {
        if(students.add(s))
            return "Dodano studenta do listy.";
        else
            return "Nie udało się dodać studenta do listy!";
    }

    /**
     * Usuwa @Student do listy @students (bez zmian w pliku)
     * @param s @see {@link Student}
     * @return Info o sukcesie
     */
    public String delStudent(Student s) {
        if (students.remove(s))
            return "Usunięto studenta.";
        else
            return "Brak studenta na liście.";
    }

    /**
     * Wyświetla studentów z listy @students
     * @return string z danymi studentów
     */
    public String displayStudents() {
        String result = "";
        if (students.size() > 0) {
            result += "Lista studentów: \n";
            for (Student s : students) {
                result += "  - " + s.toString();
            }
        } else {
            result = "Lista studentów jest pusta!";
        }
        return result;
    }

    /**
     * Zapisuje liste @students do pliku
     */
    public String saveToFile() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(outputStream, students);

            byte[] data = outputStream.toByteArray();

            FileOutputStream file = new FileOutputStream("Students.json");
            file.write(data);
            file.close();
            return "Zapisano do pliku!";
        } catch (IOException ex) {
            return "Błąd podczas zapisu do pliku!";
        }
    }

    /**
     * Odczytuje JSON z pliku i przypisuje do listy @students
     * @return Info o sukcesie
     */
    public String readFromFile() {
        //File file = new File("Students.txt");
        ObjectMapper mapper = new ObjectMapper();

        try {
            byte[] data = Files.readAllBytes(file);
            FileInputStream inputStream = new FileInputStream(file.toString());
            students.clear();
            for (Student s : (mapper.readValue(inputStream, Student[].class))) {
                students.add(s);
            }
            return "Wczytano dane z pliku.\n";
        } catch (IOException e) {
            return ("Nie masz jeszcze pliku do wczytania.\n");
        }
    }

}
