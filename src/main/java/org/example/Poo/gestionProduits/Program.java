package org.example.Poo.gestionProduits;

import java.util.Scanner;

public class Program {
    static int max_size = 30;
    static Produit[] produits = new Produit[max_size];

    static void printMenu() {
        System.out.println("1- Ajouter un produit");
        System.out.println("2- Modifier un produit");
        System.out.println("3- Supprimer un produit");
        System.out.println("4- Afficher la liste des produits");
        System.out.println("5- Rechercher un produit");
        System.out.println("6- Calculer la valeur totale du stock");
        System.out.println("0- Quitter");
    }

    static void ajouterProduit(Produit p) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null && produits[i].getCode() == p.getCode()) {
                System.out.println("Erreur: Un produit avec ce code existe déjà.");
                return;
            }
        }
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] == null) {
                produits[i] = p;
                System.out.println("Produit ajouté avec succès.");
                return;
            }
        }
        System.out.println("Erreur: Tableau plein.");
    }

    static void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null && produits[i].getCode() == code) {
                produits[i].setNom(nouveauNom);
                produits[i].setQuantite(nouvelleQuantite);
                produits[i].setPrix(nouveauPrix);
                System.out.println("Produit modifié avec succès.");
                return;
            }
        }
        System.out.println("Erreur: Produit non trouvé.");
    }

    static void supprimerProduit(int code) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null && produits[i].getCode() == code) {
                produits[i] = null;
                System.out.println("Produit supprimé avec succès.");
                return;
            }
        }
        System.out.println("Erreur: Produit non trouvé.");
    }

    static void afficherProduits() {
        boolean found = false;
        System.out.println(produits.length);
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null) {
                System.out.println(produits[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun produit en stock.");
        }
    }

    static void rechercherProduit(String nom) {
        boolean found = false;
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null && produits[i].getNom().equalsIgnoreCase(nom)) {
                System.out.println(produits[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Produit non trouvé.");
        }
    }

    static void calculerValeurStock() {
        double valeurTotale = 0;
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null) {
                valeurTotale += produits[i].getPrix() * produits[i].getQuantite();
            }
        }
        System.out.println("Valeur totale du stock: " + valeurTotale);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            printMenu();
            System.out.println("Entrer votre choix:");
            choix = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    System.out.println("*** Ajouter un produit ***");
                    System.out.print("Code: ");
                    int code = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Prix: ");
                    double prix = sc.nextDouble();
                    System.out.print("Quantité: ");
                    int quantite = sc.nextInt();
                    ajouterProduit(new Produit(nom, prix, quantite, code));
                    break;
                case 2:
                    System.out.println("*** Modifier un produit ***");
                    System.out.print("Code: ");
                    code = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nouveau nom: ");
                    nom = sc.nextLine();
                    System.out.print("Nouveau prix: ");
                    prix = sc.nextDouble();
                    System.out.print("Nouvelle quantité: ");
                    quantite = sc.nextInt();
                    modifierProduit(code, nom, quantite, prix);
                    break;
                case 3:
                    System.out.println("*** Supprimer un produit ***");
                    System.out.print("Code: ");
                    code = sc.nextInt();
                    supprimerProduit(code);
                    break;
                case 4:
                    System.out.println("*** Liste des produits ***");
                    afficherProduits();
                    break;
                case 5:
                    System.out.println("*** Rechercher un produit ***");
                    System.out.print("Nom: ");
                    nom = sc.nextLine();
                    rechercherProduit(nom);
                    break;
                case 6:
                    System.out.println("*** Valeur totale du stock ***");
                    calculerValeurStock();
                    break;
                case 0:
                    System.out.println("Quitter avec succès.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);

        sc.close();
    }
}
