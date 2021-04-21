import java.io.Serializable;
import java.util.Scanner;


public class Main implements Serializable {

    static boolean loop = true;
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        menu mainMenu = new menu();

        while (loop) {

            menu.switchChoice(mainMenu.showMenu());

        }
    }

}

