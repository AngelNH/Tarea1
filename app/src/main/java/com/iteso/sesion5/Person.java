package com.iteso.sesion5;

/**
 * Created by inqui on 30/01/2018.
 */

public class Person {
    String name;
    String phone;
    String degree;
    String gender;
    String book;
    boolean sport;
    public Person(String name, String phone,String degree, String gender, String book, boolean sport) {
        super();
        this.name = name;
        this.phone = phone;
        this.degree = degree;
        this.gender = gender;
        this.book = book;
        this.sport = sport;
    }

    public String toString(){
        String aux=   "Nombre: " + this.name
                + "\nTelefono: " + this.phone
                + "\nEscolaridad " + this.degree
                + "\nGénero: " + this.gender;
        if(book != null)
            aux += "\nLibro Favorito: " + this.book;
        aux+="\nPractica Deporte: ";
        if(this.sport)
            return aux+= "Si";
        return aux+= "No";
    }
}
