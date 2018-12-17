package com.steven.rabbitmq;

import com.steven.rabbit.many.StevenSender;
import com.steven.rabbit.many.StevenSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
	@Autowired
	private StevenSender stevenSender;

	@Autowired
	private StevenSender2 stevenSender2;

	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			stevenSender.send(i);
		}
	}

	@Test
	public void manyToMany() throws Exception {
		for (int i=0;i<100;i++){
			stevenSender.send(i);
			stevenSender2.send(i);
		}
	}

}