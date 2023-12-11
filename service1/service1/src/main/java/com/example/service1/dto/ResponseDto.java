package com.example.service1.dto;

import com.example.service1.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean statusCode;
    private String message;
    private T data;
}
