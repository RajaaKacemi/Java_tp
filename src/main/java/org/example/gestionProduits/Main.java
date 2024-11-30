package org.example.gestionProduits;

import java.util.Scanner;

public class Main {
    static int maxSize = 10;
    static int[] codeProduits = new int[maxSize];
    static String[] nomProduits = new String[maxSize];
    static double[] prixProduits = new double[maxSize];
    static int[] quantiteProduits = new int[maxSize];


    static void printMenu(){

        System.out.println("choississer un  choix.");
        System.out.println("1- Ajouter un produit");
        System.out.println("2- Modifier un produit");
        System.out.println("3- Supprimer un produit");
        System.out.println("4- Afficher la liste des produits");
        System.out.println("5- Recherche de produit");
        System.out.println("6- Calcul de la valeur totale du stock");
        System.out.println("0- Quitter");

    }

    static void affichageProduits(){

        System.out.println("List du produits:");
        System.out.println("Code" +"\t\t"+ "Nom"+"\t\t"+ "Quantite"+"\t\t"+ "Prix");
        for(int i = 0; i < codeProduits.length; i++){
            if(codeProduits[i] != 0){
            System.out.print(codeProduits[i] + "\t\t\t"+ nomProduits[i] + "\t\t\t"+ quantiteProduits[i]+ "\t\t\t"+ prixProduits[i]+ "\n");
            }
        }
    }

    static void ajouterProduit(int code, String nom, int quantite, double prix){

        int indice=-1;
        for(int i = 0; i < codeProduits.length; i++){
            if(codeProduits[i]==0){
                indice=i;
            }
        }
        if(indice==-1){
            System.out.println("Error: Tableau est plein.");
            return;
        }
        codeProduits[indice]=code;
        nomProduits[indice]=nom;
        prixProduits[indice]=prix;
        quantiteProduits[indice]=quantite;

    }

    static int rechercherProduit(String nom){
        for (int i = 0; i < nomProduits.length; i++) {
            if(nomProduits[i]!=null && nomProduits[i].equals(nom)){
                return i;
            }

        }
        return -1;
    }
    static void supprimerProduit(int code){
        for (int i = 0; i < codeProduits.length; i++) {
            if(codeProduits[i]==code){
                codeProduits[i]=0;
                nomProduits[i]=null;
                prixProduits[i]=0;
                quantiteProduits[i]=0;
                System.out.println("le produit "+ code + " a été supprimer avec succès");
                break;
            }else{
                System.out.println("Produit avec le code " + code + " introuvable !");
            }
        }
    }
    static void calculerValeurStock(){
        int sum=0;
        for (int i = 0; i < quantiteProduits.length; i++) {
            sum += quantiteProduits[i] * prixProduits[i];
        }
        System.out.println("La valeur total du stock est: " + sum);
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int choix=-1;
        int code;int quantite;double prix;
        String nom;
        int indice;

        do{
        printMenu();
        choix=input.nextInt();input.nextLine();

        switch (choix){

            case 1:
                System.out.println("*** Ajouter un produit **+");
                System.out.println("Saisir le code.");
                code=input.nextInt();input.nextLine();

                System.out.println("Saisir le nom.");
                nom=input.nextLine();

                System.out.println("Saisir la quantite.");
                quantite=input.nextInt();

                System.out.println("Saisir le prix.");
                prix=input.nextDouble();

                ajouterProduit(code, nom, quantite, prix);
                break;
            case 2:
                break;
            case 3:
                System.out.println("*** supprimer produit ***");
                code= input.nextInt();
                supprimerProduit(code);
                break;
            case 4:
                System.out.println("*** l'affichage du produits ***");
                affichageProduits();
                break;
            case 5:
                System.out.println("*** Rechercher un produit ***");
                nom = input.nextLine();
                indice=rechercherProduit(nom);
                if(indice!=-1){
                    System.out.println("Produit exist");
                    System.out.println("nom:"+ nomProduits[indice]);
                    System.out.println("code:" + codeProduits[indice]);
                    System.out.println("prix:" + prixProduits[indice]);
                    System.out.println("quantite:" + quantiteProduits[indice]);
                }else{
                    System.out.println("produit n'exist pas !!");
                }
                break;
            case 6:
                System.out.println("*** valeur total du stock ***");
                calculerValeurStock();
                break;
            case 0:
                System.out.println("Quitter avec succès.");
                break;
            default:
                System.out.println("ce choix n'exsite pas !");
                break;
        }
        }while (choix != 0);

    }
}
