package com.example.service1.service;

import com.example.service1.dto.Person;
import com.example.service1.dto.RequestDto;
import com.example.service1.dto.ResponseDto;
import com.example.service1.entity.Order;
import com.example.service1.rabbitConfig.MessageConfig;
import com.example.service1.repository.OrderRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void orderAdd(RequestDto requestDto) {

        try {
            if (requestDto.getOrder()!=null && requestDto.getPerson()!=null) {
                Order order = requestDto.getOrder();
                Order savedOrder = orderRepo.save(order);

                Person person = requestDto.getPerson();
                person.setOrderId(savedOrder.getOrderId());


                Person personResponse = restTemplate.postForObject("http://PERSON-SERVICE/person/setPersonDetails", person, Person.class);

            }


        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
