package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default

public class TraineeDBRepo implements TraineeRepo {
			
	@PersistenceContext(unitName = "primary")
	public EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a From Trainee a");
		Collection<Trainee> result = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	@Override
	public String getATrainee(String traineeToRetrieve) {
		Trainee trainee = util.getObjectForJSON(traineeToRetrieve, Trainee.class);
		trainee = findTrainee(trainee.getTraineeId());
		
		return trainee.toString();
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String traineeToCreate) {
		Trainee trainee = util.getObjectForJSON(traineeToCreate, Trainee.class);
		manager.persist(trainee);
		return trainee.getTraineeId() + " created!";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee trainee = findTrainee(id);
		if(trainee != null) {
			manager.remove(trainee);
		}
		return "Account deleted";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(String traineeToUpdate) {
		Trainee trainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
		if (trainee != null) {
			manager.remove(trainee.getTraineeId());
			manager.persist(trainee);
		}
		return trainee.getTraineeId() + " updated!";
	}
	
	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}

	
	//Getters setters & utility
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
		
}
