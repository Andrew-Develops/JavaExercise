public class Menu {

    public static void selectMenu() {
        System.out.println("---------- Meniul principal ----------");
        System.out.println("(1)Insert a car  (2)Update a car  (3)Delete a car  (4)Search for a car  (5)Display all cars  (0)Exit");
    }

    public static void insertCar() {
        System.out.println("---------- Introduceti urmatoarele valori: ----------");
        System.out.println("Marca masinii:");
        System.out.println("Modelul masinii:");
        System.out.println("Anul de fabricatie:");
        System.out.println("Culoarea masinii:");
        System.out.println("Combustibilul preferat:");
    }

    public static void searchCar() {
        System.out.println("---------- Rezultat cautare ----------");
        System.out.println("Introduceti marca masinii pe care vreti sa o cautati: ");
    }

    public static void displayAllCars() {
        System.out.println("---------- Lista masinile din dealership ----------");
    }
}
