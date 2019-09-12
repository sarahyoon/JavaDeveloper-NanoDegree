package com.udacity.dogMicroservice.repository;

import com.udacity.dogMicroservice.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
