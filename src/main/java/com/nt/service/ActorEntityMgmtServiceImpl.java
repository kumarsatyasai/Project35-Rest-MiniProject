package com.nt.service;

import java.util.ArrayList;  
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nt.binding.ActorData;
import com.nt.entity.ActorEntity;
import com.nt.repository.IActorEntityRepository;

@Service
public class ActorEntityMgmtServiceImpl implements IActorEntityMgmtService {
	
	@Autowired
	private IActorEntityRepository repo;
	
	@Value("${user.name}")
	public String userName;

	@Override
	public String registerActorData(ActorData data) {
		// TODO Auto-generated method stub
		
		ActorEntity actorEntity = new ActorEntity();
		BeanUtils.copyProperties(data, actorEntity);
		
		actorEntity.setCreatedBy(userName);
		actorEntity.setUpdatedBy(userName);
	
		return "Actor Inserted With Id : "+repo.save(actorEntity).getActorId();
	}

	@Override
	public List<ActorData> findAllActors() {
		// TODO Auto-generated method stub
		List<ActorEntity> findAll = repo.findAll();
		List<ActorData> arrayList = new ArrayList<ActorData>();
		
		for(ActorEntity entity: findAll)
		{
			ActorData data = new ActorData();
			BeanUtils.copyProperties(entity, data);
			arrayList.add(data);
			
		}
		return arrayList;
	}

	@Override
	public String fUpdateActorData(ActorData data) {
		// TODO Auto-generated method stub
		Optional<ActorEntity> opt = repo.findById(data.getActorId());
		if(opt.isPresent())
		{
			ActorEntity actorEntity = opt.get();
			BeanUtils.copyProperties(data, actorEntity);
			actorEntity.setUpdatedBy(userName);
			return "Actor Updated With Id : "+repo.save(actorEntity).getActorId();
		}
		else
		{
			throw new IllegalArgumentException("Invalid User Id,User Please Provide Correct Id.");
		}
	
	}

	@Override
	public String pUpdateActorData(Integer id, String name) {
		// TODO Auto-generated method stub
		Optional<ActorEntity> opt = repo.findById(id);
		if(opt.isPresent())
		{
			ActorEntity actorEntity = opt.get();
			actorEntity.setActorName(name);
			actorEntity.setUpdatedBy(userName);
			return "Actor Updated With Id : "+repo.save(actorEntity).getActorId();
		}
		else
		{
			throw new IllegalArgumentException("Invalid User Id,User Please Provide Correct Id.");
		}
	}

	@Override
	public String deleteActorData(Integer id) {
		// TODO Auto-generated method stub
				Optional<ActorEntity> opt = repo.findById(id);
				if(opt.isPresent())
				{
					repo.deleteById(id);
					return "Actor Deleted With Id : "+opt.get().getActorId();
				}
				else
				{
					throw new IllegalArgumentException("Invalid User Id,User Please Provide Correct Id To Delete.");
				}
	}

}
