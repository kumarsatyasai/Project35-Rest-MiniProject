package com.nt.binding;

import lombok.AllArgsConstructor;    
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorData {
	
    private Integer actorId;
	
	private String actorName;
	
	private String actorAddrs;
	
	private Double actorFee;
	
	private String actorLocation;
	
	private String actorSoftSwitch;

}
