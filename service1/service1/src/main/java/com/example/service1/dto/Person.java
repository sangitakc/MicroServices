package com.example.service1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private Integer orderId;
    private String firstName;
    private String lastName;
    private Integer age;


}
