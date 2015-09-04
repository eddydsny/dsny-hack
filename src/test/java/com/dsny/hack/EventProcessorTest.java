package com.dsny.hack;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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
	private EventService eventService;
	
	@Test
	public void processEvents() throws Exception{
		Event eventOne = new Event("social", (short)1, 1);
		Event eventTwo = new Event("social", (short)2, 1);
		
		eventOne = eventService.create(eventOne);
		eventTwo = eventService.create(eventTwo);
		
		Assert.assertEquals("New", eventOne.getStatus());
		Assert.assertEquals("New", eventTwo.getStatus());
		
		TimeUnit.SECONDS.sleep(35L);
		
		Assert.assertEquals("Completed", eventService.findByID(eventOne.getId()).getStatus());
		Assert.assertEquals("Completed", eventService.findByID(eventTwo.getId()).getStatus());
	}
}
