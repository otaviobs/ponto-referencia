package br.com.moby7.poi.repository;

import br.com.moby7.poi.domain.Posicao;
import com.vividsolutions.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosicaoRepository extends JpaRepository<Posicao, Long> {

    @Query(value = "SELECT * FROM posicao WHERE ST_DistanceSphere(geom, :point) <= :poiRaio", nativeQuery = true)
    List<Posicao> findAllPosicoesEmCadaPOI(@Param("point") Point point, @Param("poiRaio") Integer poiRaio);
    List<Posicao> findByLongitudeAndLatitude(Float longitude, Float Latitude);
}
