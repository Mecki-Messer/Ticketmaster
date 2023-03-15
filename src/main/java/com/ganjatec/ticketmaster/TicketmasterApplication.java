package com.ganjatec.ticketmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicketmasterApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TicketmasterApplication.class, args);

		/*
		Utilities ut = new Utilities();
		Hash h1 = ut.hashPassword("test1234");
		Hash h2 = ut.hashPassword("test1234");

		HashRepository hashRepository = applicationContext.getBean(HashRepository.class);
		hashRepository.save(h1);
		hashRepository.save(h2);
		*/
		/*
		User u1 = new User();
		u1.setUsername("administrator");
		u1.setHashID(1);
		u1.setDepartment(0);
		u1.setMatrikelnr(99999999);
		u1.setPrivLevel(0);

		User u2 = new User();
		u1.setUsername("dummy");
		u1.setHashID(2);
		u1.setDepartment(0);
		u1.setMatrikelnr(99999998);
		u1.setPrivLevel(1);

		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		userRepository.save(u1);
		userRepository.save(u2);
		*/

		/*
		Ticket t1 = new Ticket();
		t1.setHead("Testticket");
		t1.setBody("This is a test!");
		t1.setUserID(2);
		t1.setStatus(1);


		TicketRepository ticketRepository = applicationContext.getBean(TicketRepository.class);
		ticketRepository.save(t1);
		*/
	}

}
