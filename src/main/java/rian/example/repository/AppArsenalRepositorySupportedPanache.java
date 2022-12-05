package rian.example.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import rian.example.entity.AppArsenalEntity;

@ApplicationScoped
public class AppArsenalRepositorySupportedPanache implements PanacheRepository<AppArsenalEntity> {

}
