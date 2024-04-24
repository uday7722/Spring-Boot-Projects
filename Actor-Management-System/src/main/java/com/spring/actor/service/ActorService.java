package com.spring.actor.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spring.actor.entity.Actor;
import com.spring.actor.utility.ResponseStructure;

public interface ActorService {


	ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor);

	//	public Actor findActorById(int actorId);
	//	
	//	public Actor updateActorById(int actorId,Actor updatedActor);
	//	
	//	public void DeleteActorById(int actorId);

	ResponseEntity<ResponseStructure<Actor>> findActorById(int actorId);

	ResponseEntity<ResponseStructure<Actor>> updateActorById(int actorId,Actor updatedActor);

	ResponseEntity<ResponseStructure<Actor>>  DeleteActorById(int actorId);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findAllActors();
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByActorName(String actorName);
		
	ResponseEntity<ResponseStructure<List<Actor>>> findByActorAge(int actorAge);
	
	ResponseEntity<ResponseStructure<List<Actor>>> updateNationalityByAge(String nationality,int age);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByactorNameAndnationality(String actorName,String nationaliity);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByactorNameOractorAddress(String nationality,String actorAddress);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByactorAgeBetween(int actorAge1,int actorAge2);
	
	ResponseEntity<ResponseStructure<List<Actor>>>  findbyactorAgeGreaterThan(int actorAge);

	ResponseEntity<ResponseStructure<List<Actor>>>  findbyactorAgeLessThan(int actorAge);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLike(String actorName);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLikeEndingWith(String actorName);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLikeStartingWith(String actorName);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByNationlityContaining(String nationality);
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByActorIndustryIsNull();
	
	ResponseEntity<ResponseStructure<List<Actor>>> findByActorIndustryIsNotNull();
	
	ResponseEntity<ResponseStructure<List<Actor>>> deleteByActorNameAndActorAge(String actorName, int actorAge);
	
	ResponseEntity<ResponseStructure<List<Actor>>> deleteByActorNameOrActorNationality(String actorName, String  nationality);


}
