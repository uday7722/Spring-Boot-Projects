package com.spring.actor.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.actor.entity.Actor;
import com.spring.actor.exception.ActorObjectNotFoundByIdException;
import com.spring.actor.exception.ActorsNotFoundException;
import com.spring.actor.repository.ActorRepository;
import com.spring.actor.service.ActorService;
import com.spring.actor.utility.ResponseStructure;

import jakarta.transaction.Transactional;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	private ActorRepository actorRepository;
	private Optional<Actor> optional;


	@Override
	public	ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor) {
		Actor actors = actorRepository.save(actor);
		System.out.println("Data inserted Successfully");

		ResponseStructure<Actor>responseStructure=new ResponseStructure<Actor>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Actor object created Successfully ");
		responseStructure.setData(actors);
		return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.CREATED);

	}


	@Override
	public ResponseEntity<ResponseStructure<Actor>> findActorById(int actorId) {
		optional = actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor = optional.get();
			ResponseStructure<Actor> responseStructure=new ResponseStructure<Actor>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor Object Found");
			responseStructure.setData(actor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new ActorObjectNotFoundByIdException(" Actor not Found !! ");
		}

	}


	@Override
	public ResponseEntity<ResponseStructure<Actor>> updateActorById(int actorId, Actor updatedActor) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor existingActor = optional.get();
			updatedActor.setActorId(existingActor.getActorId());
			actorRepository.save(updatedActor);

			ResponseStructure<Actor> responseStructure=new ResponseStructure<Actor>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Object Updated");
			responseStructure.setData(updatedActor);

			return new  ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new ActorObjectNotFoundByIdException(" Actor not Found !!");
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<Actor>> DeleteActorById(int actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor existingActor =optional.get();
			actorRepository.delete(existingActor);

			ResponseStructure<Actor> responseStructure=new ResponseStructure<Actor>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor object found and deleted Successfully ");
			responseStructure.setData(existingActor);

			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.OK);

		}
		else {

			throw new ActorObjectNotFoundByIdException(" Actor not Found !!");
		}


	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors() {

		List<Actor> actors = actorRepository.findAll();

		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No Actors are Found");
		}
		else {

			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();

			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Ators are found !! ");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}

	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorName(String actorName) {
		List<Actor> actors=actorRepository.findByActorName(actorName);

		ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();

		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Ators are found !! ");
		responseStructure.setData(actors);

		return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);

	}


	@Override
	@Transactional
	public ResponseEntity<ResponseStructure<List<Actor>>> updateNationalityByAge(String nationality, int actorAge) {

		actorRepository.updateNationalityByAge(nationality, actorAge);	
		List<Actor>	updatedActors=actorRepository.findAll();
		if(updatedActors.isEmpty()) {
			throw new ActorsNotFoundException("No actors are found");

		}
		else {

			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Objects Updated");	
			responseStructure.setData(updatedActors);

			return new  ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.OK);				
		}	
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorAge(int actorAge) {
		List<Actor> actors = actorRepository.findByActorAge(actorAge);

		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actors found can't perform operation");
		}
		else {

			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor Objects Updated");	
			responseStructure.setData(actors);

			return new  ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);	

		}	
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByactorNameAndnationality(String actorName,String nationaliity) 
	{
		List<Actor> actors= actorRepository.findByactorNameAndnationality(actorName, nationaliity);

		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actors are present  ");

		}
		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByactorNameOractorAddress(String nationality,String actorAddress) {

		List<Actor> actors=actorRepository.findByactorNameOractorAddress(nationality, actorAddress);

		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor found");

		}
		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor are found");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByactorAgeBetween(int actorAge1, int actorAge2) {

		List<Actor> actors=actorRepository.findByactorAgeBetween(actorAge1, actorAge2);

		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actors are found");
		}

		ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Actors are found");
		responseStructure.setData(actors);

		return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);

	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findbyactorAgeGreaterThan(int actorAge) {
		List<Actor> actors=actorRepository.findbyactorAgeGreaterThan(actorAge);

		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}

	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findbyactorAgeLessThan(int actorAge) {

		List<Actor> actors=actorRepository.findbyactorAgeLessThan(actorAge);

		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}


	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLike(String actorName) {
		
		List<Actor> actors=actorRepository.findByActorNameLike(actorName);
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}


		
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLikeEndingWith(String actorName) {
		
		List<Actor> actors=actorRepository.findByActorNameLikeEndingWith(actorName);
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}

		
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorNameLikeStartingWith(String actorName) {
		List<Actor> actors=actorRepository.findByActorNameLikeStartingWith(actorName);
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByNationlityContaining(String nationality) {
		List<Actor> actors=actorRepository.findByNationlityContaining(nationality);
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorIndustryIsNull() {
		
		List<Actor> actors=actorRepository.findByActorIndustryIsNull();
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorIndustryIsNotNull() {
		
		List<Actor> actors=actorRepository.findByActorIndustryIsNotNull();
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
		
	}


	@Transactional
	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> deleteByActorNameAndActorAge(String actorName,int actorAge) {
		
		actorRepository.deleteByActorNameAndActorAge(actorName, actorAge);
		List<Actor> actors=actorRepository.findAll();
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}


	@Transactional
	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> deleteByActorNameOrActorNationality(String actorName,String nationality) {
		
		actorRepository.deleteByActorNameOrActorNationality(actorName, nationality);
		List<Actor> actors=actorRepository.findAll();
		if(actors.isEmpty()) {
			throw new ActorsNotFoundException("No actor are found");
		}

		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors are found and displayed");
			responseStructure.setData(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
		
	}
	
	

}
