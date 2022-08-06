package br.com.moby7.poi.repository;

import br.com.moby7.poi.domain.Poi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoiRepository extends CrudRepository<Poi, Long> {
    List<Poi> findAll();
}
