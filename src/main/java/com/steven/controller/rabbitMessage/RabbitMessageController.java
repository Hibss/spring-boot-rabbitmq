package com.steven.controller.rabbitMessage;

import com.steven.model.RabbitMessage;
import com.steven.service.RabbitMessageService;
import com.steven.util.Errors;
import com.steven.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by steven.sheng on 2018/1/10.
 */
@RestController
@RequestMapping("/message")
public class RabbitMessageController {

    @Autowired
    private RabbitMessageService rabbitMessageService;

    @RequestMapping("/getRabbitMessage")
    @ResponseBody
    public RestResponse getAllMessage(@PathParam("exchange") String exchange,@PathParam("routingKey") String routingKey,
                                      @PathParam("context") String context){
        try{
            List<RabbitMessage> messages = rabbitMessageService.getRabbitMessage(exchange,routingKey,context);
            return RestResponse.createSuccess(messages);
        }catch (Exception e){
            return RestResponse.createFailed(Errors.SYSTEM_EXCEPTION.getCode(),e.getMessage());
        }
    }

    @RequestMapping("/saveRabbitMessage")
    @ResponseBody
    public RestResponse saveRabbitMessage(@PathParam("exchange") String exchange,@PathParam("routingKey") String routingKey,
                                          @PathParam("context") String context){
        try{
            RabbitMessage message = new RabbitMessage();
            message.setExchange(exchange);
            message.setRoutingKey(routingKey);
            message.setContext(context);
            message = rabbitMessageService.insert(message);
            return RestResponse.createSuccess(message);
        }catch (Exception e){
            return RestResponse.createFailed(Errors.SYSTEM_EXCEPTION.getCode(),e.getMessage());
        }
    }
}
