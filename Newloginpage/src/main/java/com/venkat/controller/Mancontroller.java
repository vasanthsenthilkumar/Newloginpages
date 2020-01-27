
package com.venkat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.entity.Man;
import com.venkat.repository.Manrepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class Mancontroller {

	@Autowired
	Manrepository repo;

	
	@GetMapping("/mans")
	@ResponseBody
	public List<Man> Man() {

		return repo.findAll();

	}

	@PostMapping("/mans")
	public Man addman(@RequestBody Man man) {
		repo.save(man);
		return man;
	}

	@DeleteMapping("/mans/{id}")
	@ResponseBody
	public String deleteMan(@PathVariable int id) {

		Man m = repo.getOne(id);

		repo.delete(m);

		return "deleted";

	}

	@PutMapping("/mans")
	public Man updateman(@RequestBody Man man) {
		repo.save(man);
		return man;
	}

	@GetMapping("/mans/{id}")
	public List<Man> getAlien(@PathVariable("id") int id) {

		return repo.findById(id);

	}

}
