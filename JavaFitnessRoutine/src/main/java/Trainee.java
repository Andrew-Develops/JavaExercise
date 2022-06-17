public class Trainee {

    private String name;
    private int stamina = 500;
    private int strength = 50;

    public Trainee(String name) {
        this.name = name;
    }

    public Trainee() {
    }

    public void cardio() {
        System.out.println("Am inceput antrenamentul de cardio.");
        System.out.println("Am ars 300 calorii.");
        stamina -= 30;
        strength += 5;
    }

    public void weightTraining() {
        System.out.println("Am inceput antrenamentul cu greutati.");
        System.out.println("Am ars 500 calorii.");
        stamina -= 50;
        strength += 15;
    }

    public void boxing() {
        System.out.println("Am inceput antrenamentul de box.");
        System.out.println("Am ars 250 calorii.");
        stamina -= 70;
        strength += 20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
