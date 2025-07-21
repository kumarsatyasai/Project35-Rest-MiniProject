package com.nt.service;

import java.util.List;

import com.nt.binding.ActorData;

public interface IActorEntityMgmtService {
	
	public String registerActorData(ActorData data);
	
	public List<ActorData> findAllActors();
	
	public String fUpdateActorData(ActorData data);
	
	public String pUpdateActorData(Integer id, String name);
	
	public String deleteActorData(Integer id);

}
