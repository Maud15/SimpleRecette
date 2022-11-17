package com.jpa.example.domain;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hey coucou !");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_simpleRecette");
    }

}
