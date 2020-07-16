package com.example.rwbybackend.repositories;

import org.springframework.data.repository.CrudRepository;

public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {
    
    MyEntity getByNameAndBoolIsFalse(String name);
}
