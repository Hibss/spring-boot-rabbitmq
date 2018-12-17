package com.steven.service;

import com.steven.mapper.OperatorMapper;
import com.steven.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by steven.sheng on 2018/1/9.
 */
@Service
public class OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    public List<Operator> getByName(String name){
        return operatorMapper.getByName(name);

    }

}
