import java.util.Scanner;

public class User {

    DBConnection dbConnection = new DBConnection();
    Scanner scanner = new Scanner(System.in);

    //Daca userul apasa tasta 1 insereaza o masina
    public void insertACarOption() {
        Menu.insertCar();
        String brand = scanner.next();
        String model = scanner.next();
        String year = scanner.next();
        String color = scanner.next();
        String fuel = scanner.next();
        System.out.printf("Masina Dumneavoastra: %s %s %s %s %s a fost  adaugata in baza de date %n", brand, model, year, color, fuel);
        Car carToInsert = new Car(brand, model, year, color, fuel);
        dbConnection.insertCar(carToInsert);
    }

    //Daca userul apasa tasta 2 updateaza o masina
    public void updateACar() {
        Menu.displayAllCars();
        dbConnection.selectCarLongDescription();
        System.out.println("Introduceti id-ul masinii pe care vreti sa o updatati");
        String id = scanner.next();
        Menu.insertCar();
        String brand = scanner.next();
        String model = scanner.next();
        String year = scanner.next();
        String color = scanner.next();
        String fuel = scanner.next();
        System.out.printf("Masina Dumneavoastra: %s %s %s %s %s %n", brand, model, year, color, fuel);
        Car carToUpdate = new Car(brand, model, year, color, fuel);
        dbConnection.updateCar(carToUpdate, id);
    }

    //Daca userul apasa tasta 3 sterge o masina
    public void deleteACar() {
        Menu.displayAllCars();
        dbConnection.selectCarBriefDescription();
        System.out.println("Introduceti id-ul masinii pe care vreti sa o stergeti");
        String id = scanner.next();
        dbConnection.deleteCar(id);
    }

    //Daca userul apasa tasta 4 cauta o masina din baza de date
    public void searchForACar() {
        Menu.searchCar();
        String brand = scanner.next();
        Car carToSearch = new Car(brand);
        dbConnection.searchCar(carToSearch);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Vrei sa cauti o alta masina?");
        System.out.println("(1)YES  (0)NO");
        int optionA = scanner.nextInt();
        if (optionA == 1) {
            while (optionA != 0) {
                brand = scanner.next();
                Car carToSearch2 = new Car(brand);
                dbConnection.searchCar(carToSearch2);
                System.out.println("Vrei sa cauti o alta masina?");
                System.out.println("(1)YES  (0)NO");
                optionA = scanner.nextInt();
            }
        }
    }

    //Daca userul apasa tasta 5 afiseaza toate masinile din baza de date
    public void displayAllCars() {
        Menu.displayAllCars();
        dbConnection.selectCarLongDescription();
    }

}
