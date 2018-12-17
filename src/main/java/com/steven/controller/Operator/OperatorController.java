package com.steven.controller.Operator;

import com.steven.service.OperatorService;
import com.steven.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by steven.sheng on 2018/1/9.
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping("/name")
    @ResponseBody
    public RestResponse getByName(@PathParam("name") String name){
        return RestResponse.createSuccess(operatorService.getByName(name));
    }
}
