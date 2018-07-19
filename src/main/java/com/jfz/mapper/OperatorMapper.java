package com.jfz.mapper;

import com.jfz.model.Operator;

import java.util.List;

public interface OperatorMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Operator record);

    int insertSelective(Operator record);

    Operator selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Operator record);

    int updateByPrimaryKey(Operator record);

    List<Operator> getByName(String name);
}