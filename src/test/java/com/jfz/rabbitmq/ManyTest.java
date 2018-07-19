package com.jfz.rabbitmq;

import com.jfz.rabbit.many.JfzSender;
import com.jfz.rabbit.many.JfzSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
	@Autowired
	private JfzSender jfzSender;

	@Autowired
	private JfzSender2 jfzSender2;

	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			jfzSender.send(i);
		}
	}

	@Test
	public void manyToMany() throws Exception {
		for (int i=0;i<100;i++){
			jfzSender.send(i);
			jfzSender2.send(i);
		}
	}

}