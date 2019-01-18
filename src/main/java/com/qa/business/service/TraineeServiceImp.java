package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepo;


public final class TraineeServiceImp implements TraineeService {
		
		@Inject 
		private TraineeRepo data;
		
		private TraineeServiceImp() {
			
		}
		
		public String updateTrainee(String traineeToUpdate) {
			return data.updateTrainee(traineeToUpdate);
		}
		
		public String getAllTrainees() {
			return data.getAllTrainees();
		}
		
		public String getATrainee(String getTrainee) {
			return data.getATrainee(getTrainee);
		}
		
		public String createTrainee(String traineeToCreate) {
			return data.createTrainee(traineeToCreate);
		}
		
		public String deleteTrainee(Long id) {
			return data.deleteTrainee(id);
		}


		public int countTrainees(TraineeRepo data) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countTraineesByName(TraineeRepo data, String traineeName) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	
}
