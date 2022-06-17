import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
         *   Inventar : - O clasa Main de unde interactioneaza userul
         *              - O clasa User unde chem toate metodele din DBConnection
         *              - O clasa Menu unde este meniul cu instructiunile de folosire
         *              - O clasa DBConnection unde se afla toate metodele de CRUD
         *              - O clasa Car de unde creez obiecte Car
         *              - folosim operatiuni doar de tipul JDBC
         * */

        Menu.selectMenu();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if (option == 1) {
            user.insertACarOption();
        } else if (option == 2) {
            user.updateACar();
        } else if (option == 3) {
            user.deleteACar();
        } else if (option == 4) {
            user.searchForACar();
        } else if (option == 5) {
            user.displayAllCars();
        } else if (option == 0) {
            System.out.println("Exiting the app...");
        } else {
            System.out.println("Optiunea nu exista");
        }

    }
}
