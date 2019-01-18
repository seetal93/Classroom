package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeServiceImp;


@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject
	private TraineeServiceImp service;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@Path("/getATrainee")
	@GET
	@Produces({ "application/json" })
	public String getATrainee(String trainee) {
		return service.getATrainee(trainee);
	}
	
	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String jsonData) {
		return service.createTrainee(jsonData);
	}
	
	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return service.deleteTrainee(id);
	}
	
	@Path("updateTrainee/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(String jsonData) {
		return service.updateTrainee(jsonData);
	}

}
