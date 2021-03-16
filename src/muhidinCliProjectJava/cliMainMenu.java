package muhidinCliProjectJava;

import java.util.Scanner;

public class cliMainMenu {
    public static void main(String[] args) {
        input();
    }
    public static int input() {
        Scanner input = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("|   MENU SELECTION DEMO    |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|       1. Add a new City  |");
        System.out.println("|       2. List all cities |");
        System.out.println("|       3. Exit            |");
        System.out.println("============================");

        System.out.println(" Select option: ");

        int userChoice = input.nextInt();
        return 1;
    }
}
