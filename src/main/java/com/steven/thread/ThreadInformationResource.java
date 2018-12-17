package com.steven.thread;

import org.springframework.stereotype.Service;

/**
 * @Author steven.sheng
 * @Date 2018/12/14/014.
 */
@Service
public class ThreadInformationResource {

    private ThreadLocal<ThreadInformation> local = new ThreadLocal<>();

    public ThreadInformation getThreadInfo(){
        ThreadInformation info = local.get();
        if(info==null){
            info = new ThreadInformation();
            local.set(info);
        }
        return info;
    }
}
