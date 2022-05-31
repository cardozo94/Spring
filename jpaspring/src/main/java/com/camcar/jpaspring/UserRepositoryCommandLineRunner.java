package com.camcar.jpaspring;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.camcar.jpaspring.entity.User;
import com.camcar.jpaspring.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class); 
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		userRepository.save(user);
		log.info("New user is created "+ user);
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived: "+ userWithIdOne);
		
		List<User> users = userRepository.findAll();
		log.info("All users: "+users);
	}

}
