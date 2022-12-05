package rian.example.service;

import java.time.LocalDateTime;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import rian.example.constant.Rest;
import rian.example.entity.AppArsenalEntity;
import rian.example.mapper.AppArsenalMapper;
import rian.example.model.AppArsenalRequestModel;
import rian.example.repository.AppArsenalRepositorySupportedPanache;

@Dependent
public class AppArsenalServiceIAsync {

	private static final Logger logger = Logger.getLogger(AppArsenalServiceIAsync.class.getName());

	@Inject
	AppArsenalRepositorySupportedPanache appArsenalRepositorySupportedPanache;

	@Inject
	AppArsenalMapper appArsenalMapper;

	@Inject
	RequestOperationService serviceRedis;

	@Transactional
	public Long saveAsync(AppArsenalRequestModel productModel, String uuid) {
		try {
			serviceRedis.set(uuid.toString(), "{\"status\": 200}");
			Thread.sleep(30000l);
			AppArsenalEntity entity = appArsenalMapper.toEntity(productModel, null);
			entity.setCreatedAt(LocalDateTime.now());
			entity.setModifiedAt(LocalDateTime.now());
			appArsenalRepositorySupportedPanache.persist(entity);
			logger.info("Sucessfuly created AppArsenal");
			serviceRedis.set(uuid.toString(),
					"{\"status\": 302, \"urlRedirect\":\"" + Rest.pricipalPath + entity.getId() + "\"}");
			return 0l;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return 1l;
		}
	}
}
