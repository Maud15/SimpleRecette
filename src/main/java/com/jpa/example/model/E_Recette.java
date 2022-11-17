package com.jpa.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "recette")
public class E_Recette {

    @Id
    @Column(name = "id_recette")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST}) //, fetch = FetchType.EAGER
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient")
    )
    private List<E_Ingredient> ingredients;

    public E_Recette() {
    }
    public E_Recette(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " " + this.id + " : " + this.name + " ";
    }
}
