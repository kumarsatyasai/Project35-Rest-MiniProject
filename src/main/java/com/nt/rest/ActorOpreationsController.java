package com.nt.rest;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.binding.ActorData;
import com.nt.service.IActorEntityMgmtService;


@RestController
@RequestMapping("/actor-api")
public class ActorOpreationsController {
	
	@Autowired
	private IActorEntityMgmtService service;
	
	
	@PostMapping("/save")
	public  ResponseEntity<String> saveActorData(@RequestBody ActorData data)
	{
		String msg = service.registerActorData(data);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/select")
	public ResponseEntity<List<ActorData>> showAllActors()
	{
		List<ActorData> findAllActors = service.findAllActors();
		return new ResponseEntity<List<ActorData>>(findAllActors, HttpStatus.OK);
	}
	
	@PutMapping("/fupdate")
	public ResponseEntity<String> fullUpdateActorData(@RequestBody ActorData data)
	{
		String msg = service.fUpdateActorData(data);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/pupdate/{id}/{name}")
	public ResponseEntity<String> fullUpdateActorData(@PathVariable Integer id, @PathVariable String name)
	{
		String msg = service.pUpdateActorData(id, name);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeActorData(@PathVariable Integer id)
	{
		String msg = service.deleteActorData(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}


}
