package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
	// write your code here
        BiblioArbre b;
        Scanner s = new Scanner(System.in);
        System.out.println("Ecrire un nom");
        String nomFichier = s.nextLine();

        File f = new File(nomFichier);

        if(f.exists())
        {
            b = (BiblioArbre) BiblioArbre.charger(nomFichier);
        }
        else {
            b = new BiblioArbre();
            b.insere();
            b.affiche();
            b.sauvegarder("fichier");
        }

    }

}
