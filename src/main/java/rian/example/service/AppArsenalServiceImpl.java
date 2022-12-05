package rian.example.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcabi.aspects.Async;
import com.jcabi.aspects.Loggable;

import rian.example.entity.AppArsenalEntity;
import rian.example.mapper.AppArsenalMapper;
import rian.example.model.AppArsenalRequestModel;
import rian.example.model.AppArsenalResponseModel;
import rian.example.model.RequestOperationModel;
import rian.example.repository.AppArsenalRepositorySupportedPanache;

@Dependent
public class AppArsenalServiceImpl {

	private static final Logger logger = Logger.getLogger(AppArsenalServiceImpl.class.getName());

	@Inject
	AppArsenalRepositorySupportedPanache appArsenalRepositorySupportedPanache;

	@Inject
	AppArsenalMapper appArsenalMapper;

	@Inject
	AppArsenalServiceIAsync appArsenalServiceIAsync;

	@Inject
	RequestOperationService serviceRedis;

	public AppArsenalResponseModel findById(Long id) {
		AppArsenalEntity entity = appArsenalRepositorySupportedPanache.findById(id);
		return appArsenalMapper.toModel(entity);
	}

	@Async
	@Loggable
	public Future<Long> save(AppArsenalRequestModel productModel, String uuid) {
		Future<Long> factorialFuture = CompletableFuture
				.supplyAsync(() -> appArsenalServiceIAsync.saveAsync(productModel, uuid));
		return factorialFuture;
	}

	public RequestOperationModel getOperationStatus(String guid) {
		String value = serviceRedis.get(guid.toString());
		RequestOperationModel requestOperationModel = new RequestOperationModel(guid);

		if (value.isEmpty()) {
			return requestOperationModel;
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			requestOperationModel = mapper.readValue(value, RequestOperationModel.class);
			requestOperationModel.setGuid(guid);
		} catch (JsonMappingException e) {
			logger.error(e.getLocalizedMessage());

		} catch (JsonProcessingException e) {
			logger.error(e.getLocalizedMessage());
		}
		return requestOperationModel;
	}

}
