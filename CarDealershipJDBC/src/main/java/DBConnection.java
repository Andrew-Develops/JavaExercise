import java.sql.*;

public class DBConnection {

    private Connection databaseConnection;
    private PreparedStatement statement;

    public DBConnection() {
        //Deschide conexiunea de fiecare data cand creem obiectul
        try {
            this.databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealer", "root", "4991");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCar(Car carToInsert) {
        String insertCarQuery = "INSERT INTO cars(brand, model, year, color, fuel_type) VALUES(?, ?, ?, ?, ?)";
        try {
            statement = databaseConnection.prepareStatement(insertCarQuery);
            //setam valorile care le introducem de la tastatura
            statement.setString(1, carToInsert.getBrand());
            statement.setString(2, carToInsert.getModel());
            statement.setString(3, carToInsert.getYear());
            statement.setString(4, carToInsert.getColor());
            statement.setString(5, carToInsert.getFuel_type());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(String id) {
        String deleteCarQuery = "DELETE FROM cars WHERE id = ?";
        try {
            statement = databaseConnection.prepareStatement(deleteCarQuery);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car carToUpdate, String id) {
        String updateCarQuery = "UPDATE cars SET brand = ?, model =?, year = ?, color = ?, fuel_type = ? WHERE id = ?";
        try {
            statement = databaseConnection.prepareStatement(updateCarQuery);
            statement.setString(1, carToUpdate.getBrand());
            statement.setString(2, carToUpdate.getModel());
            statement.setString(3, carToUpdate.getYear());
            statement.setString(4, carToUpdate.getColor());
            statement.setString(5, carToUpdate.getFuel_type());
            statement.setString(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchCar(Car carToSearch) {
        String searCarQuery = "SELECT * FROM cars WHERE brand = ?";
        try {
            statement = databaseConnection.prepareStatement(searCarQuery);
            statement.setString(1, carToSearch.getBrand());
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String id = result.getString("id");
                String brand = result.getString("brand");
                String model = result.getString("model");
                String year = result.getString("year");
                System.out.println("Car in the dealership :  " + brand + " " + model + " " + year + "    carId: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCarBriefDescription() {
        String selectCarQuery = "SELECT * FROM cars";
        try {
            statement = databaseConnection.prepareStatement(selectCarQuery);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String brand = result.getString("brand");
                String model = result.getString("model");
                String year = result.getString("year");
                System.out.println("Car in the dealership :  " + brand + " " + model + " " + year + "    carId: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCarLongDescription() {
        String selectCarQuery = "SELECT * FROM cars";
        try {
            statement = databaseConnection.prepareStatement(selectCarQuery);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String brand = result.getString("brand");
                String model = result.getString("model");
                String year = result.getString("year");
                String color = result.getString("color");
                String fuelType = result.getString("fuel_type");
                String id = result.getString("id");
                System.out.println("Cars available :  " + brand + " " + model + " " + year + " " + color + " " + fuelType + " carId: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
