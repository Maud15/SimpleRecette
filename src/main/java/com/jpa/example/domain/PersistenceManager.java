package com.jpa.example.domain;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {
    private static EntityManagerFactory EMF_INSTANCE;

    public EntityManagerFactory getEmfInstance(String persistanceUnitName) {
        if(EMF_INSTANCE == null) {
            EMF_INSTANCE = Persistence.createEntityManagerFactory(persistanceUnitName);
        }
        return EMF_INSTANCE;
    }

}
