package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Trainer;
import com.example.demo.myexception.ResourceNotFoundException;
import com.example.demo.repository.TrainerRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
@RestController
//@RequestMapping("/trainers")   //trainers/add,trainers/update
public class TrainerController {

	@Autowired
	private TrainerRepository trainerRepository;

	// http://localhost:8080/trainers
	@GetMapping("/trainers")
	public List<Trainer> getAllTrainers() {
		return trainerRepository.findAll();
	}

	
	// http://localhost:8080/trainers/add
	@PostMapping("/trainers/add")
	public void addTrainer(@RequestBody Trainer trainer) {
		trainerRepository.save(trainer);
	}

	// http://localhost:8080/trainers/and/Raju/Kumar
	@GetMapping("/trainers/and/{firstname}/{lastname}")
	public Trainer getTrainerByFnameNameAndLname(@PathVariable String firstname, @PathVariable String lastname) {
		return trainerRepository.findByFirstnameAndLastname(firstname, lastname);
	}

	// http://localhost:8080/trainers/or/Raju/kumar
	@GetMapping("/trainers/or/{firstname}/{lastname}")
	public List<Trainer> getTrainerByFnameNameOrLname(@PathVariable String firstname, @PathVariable String lastname) {
		return trainerRepository.findByFirstnameOrLastname(firstname, lastname);
	}

	// http://localhost:8080/trainers/24
	@GetMapping("/trainers/{age}")
	public List<Trainer> findByageLessThan(@PathVariable int age) {
		return trainerRepository.findByAgeLessThan(age);
	}

	// http://localhost:8080/trainers/agelte/20
	@GetMapping("/trainers/agelte/{age}")
	public List<Trainer> findByageLessThanEqual(@PathVariable int age) {
		return trainerRepository.findByAgeLessThanEqual(age);
	}

	// http://localhost:8080/trainers/agegte/24
	@GetMapping("/trainers/agegte/{age}")
	public List<Trainer> findByageGreaterThanEqual(@PathVariable int age) {
		return trainerRepository.findByAgeGreaterThanEqual(age);
	}

	// http://localhost:8080/trainers/agebetween/20/24
	@GetMapping("/trainers/agebetween/{age1}/{age2}")
	public List<Trainer> findByageBetween(@PathVariable int age1, @PathVariable int age2) {
		return trainerRepository.findByAgeBetween(age1, age2);
	}

	@GetMapping("/trainers/ageorderby/{age}")
	public List<Trainer> findbyageOrderByLastnameDesc(@PathVariable int age) {
		return trainerRepository.findByAgeOrderByLastnameDesc(age);
	}

	// http://localhost:8080/trainers/active/1
	@GetMapping("/trainers/active/{active}")
	public List<Trainer> findAllactiveTrainers(@PathVariable int active) {
		return trainerRepository.findAllActiveTrainers(active);
	}

	// http://localhost:8080/trainers/all/1/24
	@GetMapping("/trainers/all/{active}/{age}")
	public List<Trainer> findAllactiveWithAge(@PathVariable int active, @PathVariable int age) {
		return trainerRepository.findAllActiveWithAge(active, age);
	}

	// http://localhost:8080/trainers/up/1/vijay
	@PutMapping("/trainers/up/{active}/{firstname}")
	public int updateTrainersetStatusForName(@PathVariable int active, @PathVariable String firstname) {
		return trainerRepository.updateTrainerSetStatusForName(active, firstname);
	}

	// http://localhost:8080/trainerss/1
	// resource add link by using hatias dependency
	@GetMapping("/trainerss/{id}")
	public EntityModel<Trainer> getTrainerById(@PathVariable long id){
		Optional<Trainer> trainer=trainerRepository.findById(id);
		if(!trainer.isPresent()) {
			throw new ResourceNotFoundException("Trainer", "TrId", id);
			
			 }else {
				 EntityModel<Trainer> resource= EntityModel.of(trainer.get());
				 WebMvcLinkBuilder linkTo=linkTo(methodOn(this.getClass()).getAllTrainers());
				 resource.add(linkTo.withRel("all-trainers"));
				 return resource;
				 
			 }		
	}

}
