package com.udacity.DogGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.DogGraphQL.Entity.Dog;
import com.udacity.DogGraphQL.exception.DogNotFoundException;
import com.udacity.DogGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            return optionalDog.get();
        }
        else{
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
