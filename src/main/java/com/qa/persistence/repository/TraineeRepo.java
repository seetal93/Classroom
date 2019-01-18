package com.qa.persistence.repository;

public interface TraineeRepo {
	
	String getAllTrainees();
	
	String updateTrainee(String jsonData);
	
	String getATrainee(String jsonData);
	
	String createTrainee(String jsonData);
	
	String deleteTrainee(Long id);

}
