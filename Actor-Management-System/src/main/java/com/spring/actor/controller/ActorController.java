package com.spring.actor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.actor.entity.Actor;
import com.spring.actor.service.ActorService;
import com.spring.actor.utility.ResponseStructure;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class ActorController {

	@Autowired
	private ActorService actorService;

//	@RequestMapping(value = "/actor",method = RequestMethod.POST)
	@PostMapping("/actors/addActor")
	ResponseEntity<ResponseStructure<Actor>> addActor(@RequestBody Actor actor) { 
		return  actorService.addActor(actor);
	}

//	@RequestMapping(value = "/actors/{actorId}",method = RequestMethod.GET)
	@GetMapping("/actors/findByActorId/{actorId}")
	ResponseEntity<ResponseStructure<Actor>> findActorById(@PathVariable int actorId) {
		return actorService.findActorById(actorId);
	}
	
//	@RequestMapping(value = "/actors/updatedActorById",method = RequestMethod.PUT) //-->End point
	@PutMapping("/actors/updateByActorId/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> updatedActor(@PathVariable int actorId,@RequestBody Actor actor) {
		return actorService.updateActorById(actorId, actor);
	}

//	@RequestMapping(value = "/actors/deleteActorById",method = RequestMethod.DELETE)
	@DeleteMapping("/actors/deleteByActorId/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>>  deleteActor(@PathVariable int actorId) {
	return 	actorService.DeleteActorById(actorId);
		
	}
	
	@GetMapping("/actors/findAllActors")
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors(){
		return actorService.findAllActors();
	}
	
	@GetMapping("/actors/findByActorName/{actorName}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorName(@PathVariable String actorName){
		return actorService.findByActorName(actorName);
	}

	@GetMapping("/actors/findByActorAge/{actorAge}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorAge(@PathVariable int actorAge){
		return actorService.findByActorAge(actorAge);
	}
	
	@PutMapping("/actors/updateNationalityByAge/{nationality}/{actorAge}")
	public ResponseEntity<ResponseStructure<List<Actor>>> updateNationalityByAge(@PathVariable String nationality,@PathVariable int actorAge) {
		return actorService.updateNationalityByAge(nationality, actorAge);
	}
	
	@GetMapping("/actors/findByactorNameAndnationality/{actorName}/{nationality}")
	public ResponseEntity<ResponseStructure<List<Actor>>>  findByactorNameAndnationality(@PathVariable String actorName,@PathVariable String nationality) {
		return actorService.findByactorNameAndnationality(actorName, nationality);
	}
	
	@GetMapping("/actors/findByactorNameOractorAddress/{nationality}/{actorAddress}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByactorNameOractorAddress(@PathVariable String nationality,@PathVariable String actorAddress) {
		return actorService.findByactorNameOractorAddress(nationality, actorAddress);
	}
	
	@GetMapping("/actors/findByactorAgeBetween/{actorAge1}/{actorAge2}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByactorAgeBetween(@PathVariable int actorAge1,@PathVariable int actorAge2)  {
		return actorService.findByactorAgeBetween(actorAge1, actorAge2);
	}
	
	@GetMapping("/actors/findByactorAgeGreaterThan/{actorAge}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByactorAgeGreaterThan(@PathVariable int actorAge) {
		return actorService.findbyactorAgeGreaterThan(actorAge);
	}
	
	@GetMapping("/actors/findByactorAgeLessThan/{actorAge}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByactorAgeLessThan(@PathVariable int actorAge) {
		return actorService.findbyactorAgeLessThan(actorAge);
	}
	
	@GetMapping("/actors/findByActorNameLike/{actorName}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLike(@PathVariable String actorName) {
		return actorService.findByActorNameLike(actorName);
	}
	
	@GetMapping("/actors/findByActorNameLikeEndingWith/{actorName}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLikeEndingWith(@PathVariable String actorName) {
		return actorService.findByActorNameLikeEndingWith(actorName);
	}
	
	@GetMapping("/actors/findByActorNameLikeStartingWith/{actorName}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLikeStartingWith(@PathVariable String actorName) {
		return actorService.findByActorNameLikeStartingWith(actorName);
	}
	
	@GetMapping("/actors/findByActorNationalityContaining/{nationality}")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorNationalityContaining(@PathVariable String nationality) {
		return actorService.findByNationlityContaining(nationality);
	}
	
	@GetMapping("/actors/findByActorIndustryIsNull")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorIndustryIsNull() {
		return actorService.findByActorIndustryIsNull();
	}
	
	@GetMapping("/actors/findByActorIndustryIsNotNull")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorIndustryIsNotNull() {
		return actorService.findByActorIndustryIsNotNull();
	}
	
	@DeleteMapping("/actors/deleteByActorNameAndActorAge/{actorName}/{actorAge}")
	public ResponseEntity<ResponseStructure<List<Actor>>> deleteByActorNameAndActorAge(@PathVariable String actorName,@PathVariable int actorAge){
		return actorService.deleteByActorNameAndActorAge(actorName, actorAge);
	}
	
	@DeleteMapping("/actors/deleteByActorNameOrActorNationality/{actorName}/{nationality}")
	public ResponseEntity<ResponseStructure<List<Actor>>> deleteByActorNameOrActorNationality(@PathVariable String actorName,@PathVariable String nationality){
		return actorService.deleteByActorNameOrActorNationality(actorName, nationality);
	}
	
	
	
}


//@RequestMapping( value = "/print", method = RequestMethod.GET)
//public String print() {
//	return "Hello World!!";
//}
//
//@RequestMapping(value = "/sum",method = RequestMethod.GET)
//public int sum(int num1,int num2) {
//	int sum=num1+num2;
//	return sum;
//}

