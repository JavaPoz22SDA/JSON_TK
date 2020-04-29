package pl.sda.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static String NEW = "Dodaj studenta na listę";
    final static String DEL = "Usuń studenta z listy";
    final static String DISPLAY = "Wyświetl studentów";
    final static String SAVE = "Zapisz zmiany";
    final static String EXIT = "Zakończ program";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentsManager studentsManager = new StudentsManager();
        Menu menu = new Menu<String>();
        menu.add(NEW);
        menu.add(DEL);
        menu.add(DISPLAY);
        menu.add(SAVE);
        menu.add(EXIT);

        List<Student> students = new ArrayList<>();
        try {

            while (true) {
                switch ((String) menu.showAndGetSelected()) {
                    case NEW:
                        Student s = new Student();
                        System.out.print("Podaj imię: ");
                        s.setFirstName(scanner.nextLine());
                        System.out.print("Podaj nazwisko: ");
                        s.setLastName(scanner.nextLine());
                        studentsManager.addStudent(s);
                        break;
                    case DEL:
                        break;
                    case DISPLAY:
                        System.out.println("Lista studentów: ");
                        studentsManager.displayStudents();
                        break;
                    case SAVE:
                        break;
                    case EXIT:
                        System.exit(0);
                    default:
                        System.out.println("Nieprawidlowy wybor!");
                }
                System.out.println();
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Nieprawidłowy wybór!\nKoniec programu!!!");
        }

    }
}
