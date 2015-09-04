package com.dsny.hack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dsny.hack.domain.Event;
import com.dsny.hack.service.EventService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DsnyhackApplication.class)
@WebAppConfiguration
public class EventProcessorTest {
	
	@Autowired
	private EventService enventService;
	
	@Test
	public void processEvents(){
		Event event = new Event("social", (short)1, 1);
	
	}
}
