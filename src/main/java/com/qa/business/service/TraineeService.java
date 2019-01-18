package com.qa.business.service;

import com.qa.persistence.repository.TraineeRepo;

public interface TraineeService {
		
	String getAllTrainees();
	
	String updateTrainee(String jsonData);
	
	String getATrainee(String jsonData);
	
	String createTrainee(String jsonData);
	
	String deleteTrainee(Long id);
	
	public int countTrainees(TraineeRepo data);
	
	public int countTraineesByName(TraineeRepo data, String traineeName);
	
}
