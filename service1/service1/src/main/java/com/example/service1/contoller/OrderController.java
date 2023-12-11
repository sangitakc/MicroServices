package com.example.service1.contoller;

import com.example.service1.dto.RequestDto;
import com.example.service1.dto.ResponseDto;
import com.example.service1.rabbitConfig.MessageConfig;
import com.example.service1.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    RabbitTemplate rabbitTemplate;


    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public ResponseDto saveOrder(@RequestBody RequestDto requestDto) {

        ResponseDto responseDto = new ResponseDto<>();
        try {
            rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING, requestDto);
            responseDto.setMessage("success");
            responseDto.setStatusCode(true);
            return responseDto;
        } catch (Exception e) {
            responseDto.setMessage(e.getLocalizedMessage());
            responseDto.setStatusCode(false);
            return responseDto;
        }
    }

}
