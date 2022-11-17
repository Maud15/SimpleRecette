package com.jpa.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ingredient")
public class E_Ingredient {

    @Id
    @Column(name = "id_ingredient")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ingredientId;

    @Column(name = "nom_ingredient", nullable = false)
    private String ingredientName;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "id_ingredient"),
            inverseJoinColumns = @JoinColumn(name = "id_recette")
    )
    private List<E_Recette> recettes;


    public E_Ingredient() {
    }

}
