package com.example.service2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="first_name")
    private String firstName;

    @Column (name="last_name")
    private String lastName;

    @Column (name="age")
    private Integer age;

}

