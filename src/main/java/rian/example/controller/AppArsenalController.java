package rian.example.controller;

import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpStatus;

import rian.example.constant.Rest;
import rian.example.model.AppArsenalRequestModel;
import rian.example.model.AppArsenalResponseModel;
import rian.example.model.RequestOperationModel;
import rian.example.service.AppArsenalServiceImpl;

@RequestScoped
@Path(Rest.pricipalPath)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppArsenalController {

	@Inject
	AppArsenalServiceImpl appArsenalService;

	@POST
	public Response create(@Valid AppArsenalRequestModel productModelRequest) {
		UUID uuid = UUID.randomUUID();
		appArsenalService.save(productModelRequest, uuid.toString());
		AppArsenalResponseModel response = new AppArsenalResponseModel();
		response.setUrlOperationStatus(Rest.pricipalPath + uuid.toString());
		return Response.ok(response).status(HttpStatus.SC_ACCEPTED).build();
	}

	@GET
	@Path("{id}")
	public Response get(@PathParam("id") final Long id) {
		AppArsenalResponseModel responseModel = appArsenalService.findById(id);
		if (responseModel.getId() == null) {
			return Response.ok().status(HttpStatus.SC_NOT_FOUND).build();
		} else {
			return Response.ok(responseModel).status(HttpStatus.SC_OK).build();
		}
	}

	@GET
	@Path("/request-status/{guid}")
	public Response get(@PathParam("guid") final String guid) {
		RequestOperationModel responseModel = appArsenalService.getOperationStatus(guid);
		return Response.ok(responseModel).status(responseModel.getStatus()).build();
	}

}
