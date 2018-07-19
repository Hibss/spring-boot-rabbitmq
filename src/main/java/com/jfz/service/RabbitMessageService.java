package com.jfz.service;

import com.jfz.mapper.RabbitMessageMapper;
import com.jfz.model.RabbitMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by steven.sheng on 2018/1/10.
 */
@Service
public class RabbitMessageService {

    Logger logger = LoggerFactory.getLogger(RabbitMessageService.class);

    /**
     * rabbitMQ
     */
    @Autowired
    private RabbitMessageMapper rabbitMessageMapper;


    public List<RabbitMessage> getRabbitMessage(String exchange,String routingKey, String context) {
        return rabbitMessageMapper.getRabbitMessage(exchange,routingKey,context);
    }

    public RabbitMessage insert(RabbitMessage message) {
        logger.info("RabbitMessageService receive message:{}",new GsonAutoConfiguration().gson().toJson(message));
        rabbitMessageMapper.insertAndGenIdSelective(message);
        RabbitMessage result =  rabbitMessageMapper.selectByPrimaryKey(message.getId());
        logger.info("RabbitMessageService return message:{}",new GsonAutoConfiguration().gson().toJson(result));
        return result;
    }
}
