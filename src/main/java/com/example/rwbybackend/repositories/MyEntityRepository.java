package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.MyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {
    
    MyEntity getByNameAndBoolIsFalse(String name);
}
