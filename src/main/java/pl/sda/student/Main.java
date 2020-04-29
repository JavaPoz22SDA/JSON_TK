package pl.sda.student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    final static String NEW = "Dodaj studenta na listę";
    final static String DEL = "Usuń studenta z listy";
    final static String DISPLAY = "Wyświetl studentów";
    final static String SAVE = "Zapisz zmiany";
    final static String EXIT = "Zakończ program";

    public static void main(String[] args) {
        Menu menu = new Menu<String>();
        menu.add(NEW);
        menu.add(DEL);
        menu.add(DISPLAY);
        menu.add(SAVE);
        menu.add(EXIT);

        List<Student> students = new ArrayList<>();
        try {

            switch ((String) menu.showAndGetSelected()){
                case NEW:
                    break;
                case DEL:
                    break;
                case DISPLAY:
                    break;
                case SAVE:
                    break;
                case EXIT:
                    System.exit(0);
                default:
                    System.out.println("Nieprawidlowy wybor!");
            }

        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Nieprawidłowy wybór!\nKoniec programu!!!");
        }

    }
}
