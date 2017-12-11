package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

// Sukurti lentele kuri leistu vartotojui pasirinki duomenis
// 1 - prideti, 2 - atimti ar 3 - atvaizduoti abiejose lentelese, ar 4 - importuoti duomenis is tekstinio failo
// .. programa turi parodyti visas masinas su bauda, bei rasti masinas kurio negalejo pasiekti baudos greicio


public class Main {

    public static void main(String[] args) {

        Main programa = new Main();
        InsertAuto auto = new InsertAuto();
        NuskaitymasIsFailoISarasa isTeksto = new NuskaitymasIsFailoISarasa();
        Scanner sc = new Scanner(System.in);
        while (true) {
            programa.rodykMeniu();
            String veiksmas = sc.nextLine();
            switch (veiksmas) {
                case "0":
                    return;
                case "1":
                    System.out.println("Naujo iraso priedejimas prie masinu:");
                    System.out.println("Iveskite automobilio marke: ");
                    String marke = sc.nextLine();
                    System.out.println("Iveskite modeli: ");
                    String modelis = sc.nextLine();
                    System.out.println("Iveskite masinos aprasyma: ");
                    String aprasymas = sc.nextLine();
                    System.out.println("Iveskite maksimalu automobilio greiti: ");
                    int maxGreitis = sc.nextInt();
                    auto.InsertAutomo(marke, modelis, aprasymas, maxGreitis);
                    break;
                case "2":
                    System.out.println("Naujo iraso priedejimas prie baudu:");
                    System.out.println("Iveskite automobilio id: ");
                    int autoId = sc.nextInt();
                    System.out.println("Iveskite baudos aprasyma: ");
                    String baudAprasymas = sc.nextLine();
                    System.out.println("Iveskite baudos dydi: ");
                    int baudosDydis = sc.nextInt();
                    System.out.println("Iveskite automobilio greiti: ");
                    int autoGreitis = sc.nextInt();
                    auto.InsertBauda(autoId, baudAprasymas, baudosDydis, autoGreitis);
                    break;
                case "3":
                    System.out.println("Automobilio istrinimas is duomenu bazes");
                    System.out.println("Iveskite norimo istrinti automobilio id: ");
                    autoId = sc.nextInt();
                    auto.TrintiAuto(autoId);
                    break;
                case "4":
                    System.out.println("Baudu istrynimas is duomenu bazes");
                    System.out.println("Pasirinkite automobilio id kurio bauda reikia istrinti: ");
                    autoId = sc.nextInt();
                    auto.TrintiNusizengimai(autoId);
                    break;
                case "5":
                    System.out.println("Visu automobiliu sarasas: ");
                    auto.VaizduotiAuto();
                    break;
                case "6":
                    System.out.println("Visu baudu sarasas: ");
                    auto.VaizduotiBaudas();
                    break;
                case "7":
                    System.out.println("Visu masinos su baudomis: ");
                    auto.MasinosSuBaudom();
                    break;
                case "8":
                    System.out.println("Masinos kurios negalejo virsiti greicio: ");
                    auto.NegalejoGreitis();
                    break;
                case "9":
                    ArrayList<ArrayList<String>> sarasas = isTeksto.NuskaitymasIsFailoISarasa("Masinos.txt");
                    for (int i = 0; i < sarasas.size(); i++) {
                        ArrayList<String> eilute = sarasas.get(i);
                        auto.InsertAutomo(eilute.get(0), eilute.get(1), eilute.get(2), Integer.parseInt(eilute.get(3)) );
                    }
                    break;
                case "10":
                    ArrayList<ArrayList<String>> sarasas1 = isTeksto.NuskaitymasIsFailoISarasa("Nusizengimai.txt");
                    for (int i = 0; i < sarasas1.size(); i++) {
                        ArrayList<String> eilute1 = sarasas1.get(i);
                        auto.InsertBauda(Integer.parseInt(eilute1.get(0)), eilute1.get(1), Integer.parseInt(eilute1.get(2)), Integer.parseInt(eilute1.get(3)) );
                    }
                    break;
            }
        }

    }


    public void rodykMeniu() {
        System.out.println("--------------------------------------------------");
        System.out.println("|  Pasirinkite koki veiksma norite atlikti:      |");
        System.out.println("|  1 - prideti nauja irasa prie masinu           |");
        System.out.println("|  2 - prideti nauja irasa prie baudu            |");
        System.out.println("|  3 - istrinti irasa is masinu (DB)             |");
        System.out.println("|  4 - istrinti irasa is baudu (DB)              |");
        System.out.println("|                                                |");
        System.out.println("|  5 - atvaizduoti masinu lentele                |");
        System.out.println("|  6 - atvaizduoti baudu lentele                 |");
        System.out.println("|  7 - atvaizduoti masinas su baudomis           |");
        System.out.println("|  8 - masinos kiurios negalejo gauti baudos     |");
        System.out.println("|                                                |");
        System.out.println("|  9 - ikelti masinas i DB is tekstinio failo    |");
        System.out.println("|  10 - ikelti baudas i DB is tekstinio failo    |");
        System.out.println("|                                                |");
        System.out.println("|  0 - baigti programos darba                    |");
        System.out.println("--------------------------------------------------");
    }
}



