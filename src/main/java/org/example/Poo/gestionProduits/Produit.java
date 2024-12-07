package org.example.Poo.gestionProduits;


public class Produit {
    private String nom;
    private double prix;
    private int quantite;
    private int code;

    Produit(String nom, double prix, int quantite, int code){
        this.nom=nom;
        this.prix=prix;
        this.quantite=quantite;
        this.code=code;
    }

    public String getNom(){
        return nom;
    }

    public double getPrix(){
        return prix;
    }

    public int getQuantite(){
        return quantite;
    }

    public int getCode(){
        return code;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrix(double prix){
        this.prix = prix;
    }

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }

    public void setCode(int code){
        this.code = code;
    }

    @Override
    public String toString(){
        return code + " " + nom + " " + prix + " " + quantite;
    }
}

