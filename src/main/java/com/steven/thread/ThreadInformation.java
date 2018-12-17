package com.steven.thread;

import lombok.Data;

import java.util.Date;

/**
 * @Author steven.sheng
 * @Date 2018/12/14/014.
 */
@Data
public class ThreadInformation {
    private String systemName;
    private Date requestTime;
    private String threadName;
}
