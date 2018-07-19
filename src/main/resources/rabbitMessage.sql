CREATE TABLE `mq_rabbit_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exchange` varchar(100) DEFAULT NULL COMMENT 'direct,fanout,topic消息交换机',
  `routing_key` varchar(100) DEFAULT NULL COMMENT '路由关键字',
  `context` text COMMENT '消息body',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `message_type` smallint(1) DEFAULT NULL COMMENT '1发送2接收',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `host` varchar(200) DEFAULT NULL COMMENT 'HOST NAME',
  `erp_table` varchar(100) DEFAULT NULL COMMENT 'erp业务表',
  `erp_id` bigint(20) DEFAULT NULL COMMENT 'erp业务主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8