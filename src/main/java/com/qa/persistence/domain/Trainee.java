package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Trainee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private static Long id;
	@Column (length = 100)
	private String traineeName;
	@Column
	private Long traineeId;
	@Column 
	private Long classroomId;
	
	public Trainee(String traineeName, Long traineeId ) {	
		this.traineeName = traineeName;
		traineeId = id;
		id++;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Long getTraineeId() {
		return traineeId;
	}

		
}


