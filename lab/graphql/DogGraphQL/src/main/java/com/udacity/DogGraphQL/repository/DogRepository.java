package com.udacity.DogGraphQL.repository;

import com.udacity.DogGraphQL.Entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {


}
