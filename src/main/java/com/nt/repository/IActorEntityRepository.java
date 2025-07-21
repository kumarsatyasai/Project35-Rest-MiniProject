package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.nt.entity.ActorEntity;

public interface IActorEntityRepository extends JpaRepository<ActorEntity, Integer> {
	
	

}
