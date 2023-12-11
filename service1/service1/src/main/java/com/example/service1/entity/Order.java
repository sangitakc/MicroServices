package com.example.service1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Integer orderId;

    @Column(name = "order_quantity")
    private Integer orderQuantity;

}
