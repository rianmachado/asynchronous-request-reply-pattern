package rian.example.mapper;

import java.util.Optional;

import javax.enterprise.context.Dependent;

import rian.example.entity.AppArsenalEntity;
import rian.example.model.AppArsenalRequestModel;
import rian.example.model.AppArsenalResponseModel;

@Dependent
public class AppArsenalMapper {

	public AppArsenalResponseModel toModel(final AppArsenalEntity appArsenalEntity) {

		Optional<AppArsenalResponseModel> appArsenalResponseModel = Optional
				.ofNullable(appArsenalEntity == null ? null : new AppArsenalResponseModel());

		if (!appArsenalResponseModel.isPresent()) {
			return new AppArsenalResponseModel();
		}

		Optional<AppArsenalEntity> entity = Optional.ofNullable(appArsenalEntity);

		Optional.ofNullable(entity.get().getId()).ifPresent(id -> {
			appArsenalResponseModel.get().setId(id);
		});

		Optional.ofNullable(entity.get().getOtherInfo()).ifPresent(otherInfo -> {
			appArsenalResponseModel.get().setOtherInfo(otherInfo);
		});

		return appArsenalResponseModel.get();
	}

	public AppArsenalEntity toEntity(final AppArsenalRequestModel appArsenalRequestModel, final Long id) {
		AppArsenalEntity appArsenalEntity = new AppArsenalEntity();
		appArsenalEntity.setId(id);
		appArsenalEntity.setOtherInfo(appArsenalRequestModel.getOtherInfo());
		return appArsenalEntity;
	}


}
