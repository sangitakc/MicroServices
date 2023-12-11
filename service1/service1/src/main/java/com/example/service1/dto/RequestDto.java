package com.example.service1.dto;

import com.example.service1.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private Order order;
    private Person person;
}
