package com.spring.actor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.actor.entity.Actor;

import jakarta.transaction.Transactional;

public interface ActorRepository extends JpaRepository<Actor, Integer>{

// 1.To find actor by Name
	
	public List<Actor> findByActorName(String actorName);
	
//	2.To Find the actor by Age
	
	public List<Actor> findByActorAge(int actorAge);
	
	
// 3.To update the nationality by age
	
	@Modifying
	@Query("UPDATE Actor a SET a.nationality = :nationality WHERE a.actorAge = :actorAge")
	void updateNationalityByAge(String nationality,int actorAge);

	
	@Query("Select a from Actor a where a.actorName=:actorName and a.nationality=:nationality ")
	public List<Actor> findByactorNameAndnationality(String actorName ,String nationality);
		
	@Query("Select a from Actor a where a.nationality=:nationality OR a.actorAddress=:actorAddress")
	public List<Actor> findByactorNameOractorAddress(String nationality,String actorAddress);

	@Query("Select a from Actor a where a.actorAge between :actorAge1 and :actorAge2")
	public List<Actor> findByactorAgeBetween(int actorAge1,int actorAge2);
	
//	Note: if you want only  less than just remove the equal operator 
	
	@Query("Select a from Actor a where a.actorAge>=:actorAge")
	public List<Actor> findbyactorAgeGreaterThan(int actorAge);
	
	@Query("Select a from Actor a where a.actorAge<=:actorAge")
	public List<Actor> findbyactorAgeLessThan(int actorAge);
	
	@Query("Select a from Actor a where a.actorName like %:actorName%")
	public List<Actor> findByActorNameLike(String actorName);
	
	@Query("Select a from Actor a where a.actorName like %:actorName")
	public List<Actor> findByActorNameLikeEndingWith(String actorName);
	
	@Query("Select a from Actor a where a.actorName like :actorName%")
	public List<Actor> findByActorNameLikeStartingWith(String actorName);
	
	@Query("Select a from Actor a where a.nationality like %:nationality%")
	public List<Actor> findByNationlityContaining(String nationality);
	
	@Query("Select a from Actor a where industry Is Null")
	public List<Actor> findByActorIndustryIsNull();
	
	@Query("Select a from Actor a where industry Is Not Null")
	public List<Actor> findByActorIndustryIsNotNull();
	
	@Modifying
	@Query("Delete from Actor a where a.actorName=:actorName and a.actorAge=:actorAge")
	public void deleteByActorNameAndActorAge(String actorName, int actorAge);
	
	@Modifying
	@Query("Delete from Actor a where a.actorName=:actorName or a.nationality=:nationality")
	public void deleteByActorNameOrActorNationality(String actorName, String  nationality);
	


}
