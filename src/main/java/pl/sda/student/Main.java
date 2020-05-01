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
                        Student sNew = new Student();
                        System.out.println("Dodawanie nowego studenta do listy.");
                        System.out.print("Podaj imię: ");
                        sNew.setFirstName(scanner.nextLine().trim());
                        System.out.print("Podaj nazwisko: ");
                        sNew.setLastName(scanner.nextLine().trim());
                        studentsManager.addStudent(sNew);
                        System.out.println("Dodano studenta do listy!");
                        break;
                    case DEL:
                        Student sDel = new Student();
                        System.out.println("Usuwanie studenta z listy.");
                        System.out.print("Podaj imię: ");
                        sDel.setFirstName(scanner.nextLine().trim());
                        System.out.print("Podaj nazwisko: ");
                        sDel.setLastName(scanner.nextLine().trim());
                        System.out.println(studentsManager.delStudent(sDel));
                        break;
                    case DISPLAY:
                        System.out.println("Lista studentów: ");
                        studentsManager.displayStudents();
                        break;
                    case SAVE:
                        studentsManager.saveToFile();
                        System.out.println("Zapisano do pliku!");
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
