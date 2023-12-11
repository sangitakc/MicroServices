package com.example.service2.repository;

import com.example.service2.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    Optional<Person> findByorderId(Integer orderId);
}
