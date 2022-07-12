package com.company;

import java.io.*;
import java.util.Scanner;

public class BiblioArbre implements Serializable {
    String auteur, titre;
    BiblioArbre fileGauche, fileDroit;

    BiblioArbre()
    {
        auteur = "";
        titre = "";
        fileGauche = null;
        fileDroit = null;
    }

    BiblioArbre(String a, String b)
    {
        this();
        auteur = a;
        titre = b;
    }

    void insere(String a, String b)
    {
        if(auteur.equals(""))
        {
            auteur = a;
            titre = b;
        }
        else
        {
            if(a.compareTo(auteur)<= 0)
            {
                if (fileGauche != null)
                {
                    fileGauche.insere(a,b);
                }
                else
                {
                    fileGauche = new BiblioArbre(a,b);
                }
            }
            else
            {
                if (fileDroit != null)
                {
                    fileDroit.insere(a,b);
                }
                else
                {
                    fileDroit = new BiblioArbre(a,b);
                }
            }
        }
    }

    void affiche(){
        if (fileGauche != null)
        {
            fileGauche.affiche();
        }
        if (!auteur.equals(""))
        {
            System.out.println("L'auteur : " + auteur + " / Titre : " + titre);
        }
        if (fileDroit != null)
        {
            fileDroit.affiche();
        }
    }

    void insere(){
        Scanner s = new Scanner(System.in);
        for (int i =0; i < 2; i++)
        {
            System.out.println("Ecrire l'auteur: ");
            auteur = s.nextLine();
            System.out.println("Ecrire le titre");
            titre = s.nextLine();
            insere(auteur, titre);
        }
    }

    void sauvegarder(String fichier) throws IOException
    {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fichier));
        os.writeObject(this);
        os.flush(); //vider le buffer
        os.close();
    }

    static BiblioArbre charger(String fichier) throws IOException, ClassNotFoundException {
        BiblioArbre b;
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fichier));
        b = (BiblioArbre) is.readObject();
        is.close();
        return b;
    }

    void recherche()
    {
        String a;
        Scanner s = new Scanner(System.in);
        System.out.println("Rechercher un auteur: ");
        a = s.nextLine();
        if (auteur.equals(a))
        {
            System.out.println(titre);
        }
    }
}
