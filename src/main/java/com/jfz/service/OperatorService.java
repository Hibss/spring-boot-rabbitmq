package com.jfz.service;

import com.jfz.mapper.OperatorMapper;
import com.jfz.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
