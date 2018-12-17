package com.steven.mapper;

import com.steven.model.rabbitMessage;

public interface rabbitMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(rabbitMessage record);

    int insertSelective(rabbitMessage record);

    rabbitMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(rabbitMessage record);

    int updateByPrimaryKeyWithBLOBs(rabbitMessage record);

    int updateByPrimaryKey(rabbitMessage record);
}