import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Citim dintr-un fisier si impartim angajatii in functie de departamentul din care provin
        //Cream 2 seturi pentru angajanți
        Set<Employee> itSet = new HashSet<>();
        Set<Employee> salesSet = new HashSet<>();
        //Fisierul care contine datelor angajatilor
        String employee = "D:\\Java\\ExercitiiGit\\JavaInsertSetEmployee\\fisiereFolosite\\angajati.txt";
        try {
            FileReader fileReader = new FileReader(employee);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            //Trecem prin fisier si ii impartim in seturi in functie de departamentul angajatilor
            while (text != null) {
                String[] employeeInfo = text.split(";");
                Employee newEmployee = new Employee(employeeInfo[0], employeeInfo[1], employeeInfo[2]);
                //Dupa ce i-am citit ii adaugam in functie de departament
                if (newEmployee.getDepartment().equals("IT")) {
                    itSet.add(newEmployee);
                } else {
                    salesSet.add(newEmployee);
                }
                //pentru a iesi din while
                text = bufferedReader.readLine();
                //Inseram angajatii din departamentul IT intr-un fisier separat
                FileWriter itEmployee = new FileWriter("D:\\Java\\ExercitiiGit\\JavaInsertSetEmployee\\fisiereFolosite\\itEmployee.txt");
                BufferedWriter itEmployeeWriter = new BufferedWriter(itEmployee);
                for(Employee e : itSet){
                    itEmployeeWriter.write(e.toString());
                    itEmployeeWriter.newLine();
                }
                itEmployeeWriter.flush();
                itEmployeeWriter.close();
                //Inseram angajatii din departamentul Sales intr-un fisier separat
                FileWriter salesEmployee = new FileWriter("D:\\Java\\ExercitiiGit\\JavaInsertSetEmployee\\fisiereFolosite\\salesEmployee.txt");
                BufferedWriter salesEmployeeWriter = new BufferedWriter(salesEmployee);
                for(Employee e : salesSet){
                    salesEmployeeWriter.write(e.toString());
                    salesEmployeeWriter.newLine();
                }
                salesEmployeeWriter.flush();
                salesEmployeeWriter.close();

            }
            System.out.println("Lista angajatilor IT: ");
            for (Employee e : itSet) {
                System.out.println(e);
            }
            System.out.println("Lista angajatilor Vanzari: ");
            for (Employee e : salesSet) {
                System.out.println(e);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Exceptie fisier lipsa: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exceptie IO: " + e.getMessage());
        }
    }
}
