import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele persoanei care se antreneaza");
        String name = scanner.nextLine();
        //Cream un obiect de tip trainee
        Trainee trainee = new Trainee(name);
        System.out.println("Introduceti ziua curenta");
        //Selectam antrenamentul in functie de input
        String day = scanner.nextLine();
        while ((day.equals("luni") || day.equals("miercuri") || day.equals("vineri")) && trainee.getStamina() > 0) {
            switch (day) {
                case "luni":
                    trainee.cardio();
                    System.out.println("Stamina persoanei: " + trainee.getName() + " a ajuns la " + trainee.getStamina());
                    break;
                case "miercuri":
                    trainee.weightTraining();
                    System.out.println("Stamina persoanei: " + trainee.getName() + " a ajuns la " + trainee.getStamina());
                    break;
                case "vineri":
                    trainee.boxing();
                    System.out.println("Stamina persoanei: " + trainee.getName() + " a ajuns la " + trainee.getStamina());
                    break;
                default:
                    System.out.println("Nu am gasit ziua introdusa");
                    break;
            }
            day = scanner.nextLine();
        }
        //Daca ziua introdusa nu se afla in switch vom afisa un mesaj
        if (!day.equals("luni") || !day.equals("miercuri") || !day.equals("vineri")) {
            System.out.println(day + " nu este zi de antrenament pentru " + trainee.getName());
        }
        if (trainee.getStamina() <= 0) {
            System.out.println(trainee.getName() + " este mult prea obosit. Nivelul energie este: " + trainee.getStamina());
        }
        //Statusul trainee-ului
        System.out.println(trainee.getName() + "  Strength: " + trainee.getStrength() + "  Stamina: " + trainee.getStamina());
    }
}
