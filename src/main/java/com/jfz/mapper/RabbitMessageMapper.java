package com.jfz.mapper;

import com.jfz.model.RabbitMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RabbitMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RabbitMessage record);

    int insertSelective(RabbitMessage record);

    RabbitMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RabbitMessage record);

    int updateByPrimaryKeyWithBLOBs(RabbitMessage record);

    int updateByPrimaryKey(RabbitMessage record);

    List<RabbitMessage> getRabbitMessage(@Param("exchange") String channelTopic, @Param("routingKey") String routingKey,
                                         @Param("context") String context);

    Long insertAndGenIdSelective(RabbitMessage message);
}