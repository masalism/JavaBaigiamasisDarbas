package com.company;

import DB.DBVeiksmai;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertAuto {
    public InsertAuto() {

// String Modelis;
// String Marke;
// String aprasymas;
// int MaxGreitis;
// Scanner skaitytuvas = new Scanner(System.in);
// System.out.println("Iveskite automobilio modeli: ");
// Modelis = skaitytuvas.nextLine();
// System.out.println("Iveskite marke: ");
// Marke = skaitytuvas.nextLine();
// System.out.println("Iveskite aprasyma: ");
// aprasymas = skaitytuvas.nextLine();
// System.out.println("Iveskite automobilio greiti: ");
// MaxGreitis = skaitytuvas.nextInt();
    }

    public void InsertAutomo(String Modelis, String Marke, String aprasymas, int MaxGreitis) {
        DBVeiksmai veiksmai = new DBVeiksmai();
        Object[] parametrai = {
                Modelis,
                Marke,
                aprasymas,
                MaxGreitis
        };
        try {
            veiksmai.paruoskUzklausa("INSERT INTO `masinos` (`id`, `marke`, `modelis`, `aprasymas`, `max_greitis`) VALUES (NULL, ?, ?, ?, ?)", parametrai);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void InsertBauda(int AutoID, String Aprasymas, int Bauda, int greitis) {
        DBVeiksmai veiksmai = new DBVeiksmai();
        Object[] parametrai = {
                AutoID,
                Aprasymas,
                Bauda,
                greitis
        };
        try {
            veiksmai.paruoskUzklausa("INSERT INTO `bauda` (`id`, `auto_id`, `aprasymas`, `bauda`, `greitis`) VALUES (NULL, ?, ?, ?, ?)", parametrai);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void TrintiAuto(int id) {
        DBVeiksmai veiksmai = new DBVeiksmai();
        Object[] parametrai = {
                id};
        try {
            veiksmai.paruoskUzklausa("DELETE FROM `masinos` WHERE `id`=?", parametrai);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TrintiNusizengimai(int id) {
        DBVeiksmai veiksmai = new DBVeiksmai();
        Object[] parametrai = {
                id};
        try {
            veiksmai.paruoskUzklausa("DELETE FROM `bauda` WHERE `id`=?", parametrai);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void VaizduotiLentelesAbi() {
        DBVeiksmai veiksmai = new DBVeiksmai();
        try {
            veiksmai.parodykUzklausosTurini("SELECT * FROM `bauda` INNER JOIN `masinos` ON `bauda`.`auto_id`=`masinos`.`id` ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void VaizduotiAuto() {
        DBVeiksmai veiksmai = new DBVeiksmai();
        try {
            veiksmai.parodykUzklausosTurini("SELECT * FROM `masinos`;");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void VaizduotiBaudas() {
        DBVeiksmai veiksmai = new DBVeiksmai();
        try {
            veiksmai.parodykUzklausosTurini("SELECT * FROM `bauda`;");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void MasinosSuBaudom() {
        DBVeiksmai veiksmai = new DBVeiksmai();
        try {
            veiksmai.parodykUzklausosTurini("SELECT * FROM `bauda` INNER JOIN `masinos` ON `bauda`.`auto_id`=`masinos`.`id` WHERE `bauda`.`id` IS NOT NULL ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void NegalejoGreitis() {
        DBVeiksmai veiksmai = new DBVeiksmai();
        try {
            veiksmai.parodykUzklausosTurini("SELECT * FROM `bauda` LEFT JOIN `masinos` ON `bauda`.`auto_id`=`masinos`.`id` WHERE `masinos`.`max_greitis`<`bauda`.`greitis` ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}