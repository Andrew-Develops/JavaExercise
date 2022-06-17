public class Car {

    private String brand;
    private String model;
    private String year;
    private String color;
    private String fuel_type;
    private String rar_id;

    public Car(String brand, String model, String year, String color, String fuel_type) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.fuel_type = fuel_type;
    }

    public Car(String brand, String model, String year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getRar_id() {
        return rar_id;
    }

    public void setRar_id(String rar_id) {
        this.rar_id = rar_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", fuel_type='" + fuel_type + '\'' +
                ", rar_id='" + rar_id + '\'' +
                '}';
    }
}
