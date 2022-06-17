import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //Citim dintr-un fisier si stocam in functie de tipul articolului
        //Cream seturile in functie de articole
        Set<Magazin> blugi = new HashSet<>();
        Set<Magazin> geci = new HashSet<>();
        Set<Magazin> tricou = new HashSet<>();
        Set<Magazin> accesorii = new HashSet<>();
        Set<Magazin> reduceri = new HashSet<>();
        //Fisierul care contine toate articolele
        String file = "D:\\Java\\ExercitiiGit\\JavaInsertSetMagazinImbracaminte\\fisiereFolosite\\magazinImbracaminte.txt";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null) {
                String[] magazin = text.split(";");
                Magazin newMagazin = new Magazin(magazin[0], magazin[1], magazin[2], Integer.parseInt(magazin[3]), Integer.parseInt(magazin[4]), magazin[5]);

                if (newMagazin.getArticole().equals("blugi")) {
                    blugi.add(newMagazin);
                } else if (newMagazin.getArticole().equals("geaca")) {
                    geci.add(newMagazin);
                } else if (newMagazin.getArticole().equals("tricou")) {
                    tricou.add(newMagazin);
                } else {
                    accesorii.add(newMagazin);
                }
                if (Integer.parseInt(newMagazin.getDiscount().substring(0, 1)) > 1) {
                    reduceri.add(newMagazin);
                }
                //pentru a iesi din while
                text = bufferedReader.readLine();

                //Cream 5 fisiere unde stocam pe categorii liniile citite
                //Inseram gecile intr-un fisier separat
                FileWriter geciPath = new FileWriter("D:\\Java\\ExercitiiGit\\JavaInsertSetMagazinImbracaminte\\fisiereFolosite\\fisierGeci.txt");
                BufferedWriter bufferedWriter1 = new BufferedWriter(geciPath);
                for (Magazin m : geci) {
                    bufferedWriter1.write(m.toString());
                    bufferedWriter1.newLine();
                }
                bufferedWriter1.flush();
                bufferedWriter1.close();
                //Inseram blugii intr-un fisier separat
                FileWriter blugiPath = new FileWriter("D:\\Java\\ExercitiiGit\\JavaInsertSetMagazinImbracaminte\\fisiereFolosite\\fisierBlugi.txt");
                BufferedWriter bufferedWriter2 = new BufferedWriter(blugiPath);
                for (Magazin m : blugi) {
                    bufferedWriter2.write(m.toString());
                    bufferedWriter2.newLine();
                }
                bufferedWriter2.flush();
                bufferedWriter2.close();
                //Inseram tricourile intr-un fisier separat
                FileWriter tricouPath = new FileWriter("D:\\Java\\ExercitiiGit\\JavaInsertSetMagazinImbracaminte\\fisiereFolosite\\fisierTricou.txt");
                BufferedWriter bufferedWriter3 = new BufferedWriter(tricouPath);
                for (Magazin m : tricou) {
                    bufferedWriter3.write(m.toString());
                    bufferedWriter3.newLine();
                }
                bufferedWriter3.flush();
                bufferedWriter3.close();
                //Inseram accesoriile intr-un fisier separat
                FileWriter accesoriiPath = new FileWriter("D:\\Java\\ExercitiiGit\\JavaInsertSetMagazinImbracaminte\\fisiereFolosite\\fisierAccesorii.txt");
                BufferedWriter bufferedWriter4 = new BufferedWriter(accesoriiPath);
                for (Magazin m : accesorii) {
                    bufferedWriter4.write(m.toString());
                    bufferedWriter4.newLine();
                }
                bufferedWriter4.flush();
                bufferedWriter4.close();
                //Inseram produsele cu discount intr-un fisier separat
                FileWriter discountPath = new FileWriter("D:\\Java\\ExercitiiGit\\JavaInsertSetMagazinImbracaminte\\fisiereFolosite\\fisierDiscount.txt");
                BufferedWriter bufferedWriter5 = new BufferedWriter(discountPath);
                for (Magazin m : reduceri) {
                    bufferedWriter5.write(m.toString());
                    bufferedWriter5.newLine();
                }
                bufferedWriter5.flush();
                bufferedWriter5.close();
            }
            System.out.println("Lista cu geci: ");
            for (Magazin m : geci) {
                System.out.println(m);
            }
            System.out.println("Lista cu blugi: ");
            for (Magazin m : blugi) {
                System.out.println(m);
            }
            System.out.println("Lista cu tricou: ");
            for (Magazin m : tricou) {
                System.out.println(m);
            }
            System.out.println("Lista cu accesorii: ");
            for (Magazin m : accesorii) {
                System.out.println(m);
            }
            System.out.println("Lista cu reduceri: ");
            for (Magazin m : reduceri) {
                System.out.println(m);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception" + e.getMessage());
        }
    }
}
