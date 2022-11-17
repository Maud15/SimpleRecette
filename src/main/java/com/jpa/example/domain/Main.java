package com.jpa.example.domain;

import jakarta.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hey coucou !");
        PersistenceManager pm = new PersistenceManager();
        EntityManagerFactory emfSimpleRecette = pm.getEmfInstance("pu_simpleRecette");

    }

}
