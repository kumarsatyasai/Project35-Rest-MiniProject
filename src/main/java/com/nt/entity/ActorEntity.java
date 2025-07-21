package com.nt.entity;

import java.time.LocalDateTime;  

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Rest_Actor")
public class ActorEntity {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "A_SQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer actorId;
	
	@Column(length=25)
	private String actorName;
	
	@Column(length=30)
	private String actorAddrs;
	
	private Double actorFee;
	
	@Column(length=15)
	private String actorLocation;
	
	@Column(length=8)
	private String actorSoftSwitch;
	
	//Meta Data.
	//=============
	
	
	@Column(insertable = true,updatable = false)
	private String createdBy;
	
	@Column(insertable = false,updatable = true)
	private String updatedBy;
	
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDateTime createdTime;
	
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private LocalDateTime updatedTime;
	
	@Version
	private Integer updateCount;
	

}
