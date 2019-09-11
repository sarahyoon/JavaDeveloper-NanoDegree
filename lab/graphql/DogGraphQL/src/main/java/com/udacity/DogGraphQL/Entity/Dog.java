package com.udacity.DogGraphQL.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String breed;
    private String origin;

    public Dog(Long id, String name, String breed, String origin){
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(String name, String breed, String origin){
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        origin = origin;
    }
}
