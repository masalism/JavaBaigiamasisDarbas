package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NuskaitymasIsFailoISarasa {
    public ArrayList<ArrayList<String>> NuskaitymasIsFailoISarasa(String file) {
        try {
            BufferedReader br = null;
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String eilute = br.readLine();
            ArrayList<ArrayList<String>> sarasas = new ArrayList<ArrayList<String>>();
            eilute = br.readLine();
            while (eilute != null) {                //      System.out.println(eilute);
                ArrayList<String> SukarpytaEilute = new ArrayList<String>();
                String[] sukarpytas = eilute.split("\\|");
                for (int i = 0; i < sukarpytas.length; i++) {
                    SukarpytaEilute.add(sukarpytas[i]);
                }
                sarasas.add(SukarpytaEilute);
                eilute = br.readLine();
            }
            br.close();
            fr.close();
            return sarasas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}