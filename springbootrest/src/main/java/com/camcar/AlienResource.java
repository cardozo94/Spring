package com.camcar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {
	
	@Autowired
	AlienRepository repo;
	
//	@GetMapping("aliens")
//	public List<Alien> getAlien() {
//		System.out.println("get alien list");
//		Alien a1 = new Alien();
//		a1.setId(110);
//		a1.setName("Jorman");
//		a1.setPoints(100);
//		
//		Alien a2 = new Alien();
//		a2.setId(111);
//		a2.setName("Cristina");
//		a2.setPoints(1000);
//		
//		List<Alien> aliens = Arrays.asList(a1, a2);
//		return aliens;
//	}
	
	@GetMapping("aliens")
	public List<Aliens> getAlien() {
		System.out.println("get alien list from database");
		
		
		List<Aliens> aliens =(List<Aliens>) repo.findAll();
		return aliens;
	}


}
