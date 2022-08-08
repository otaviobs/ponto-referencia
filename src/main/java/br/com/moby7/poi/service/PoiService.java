package br.com.moby7.poi.service;

import br.com.moby7.poi.domain.Poi;
import br.com.moby7.poi.domain.Posicao;
import br.com.moby7.poi.dto.PoiDto;
import br.com.moby7.poi.dto.PoiListPosicaoDto;
import br.com.moby7.poi.dto.PosicaoDto;
import br.com.moby7.poi.dto.converter.PoiConverter;
import br.com.moby7.poi.dto.converter.PosicaoConverter;
import br.com.moby7.poi.exception.NotFoundException;
import br.com.moby7.poi.repository.PoiRepository;
import br.com.moby7.poi.repository.PosicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PoiService {

    @Autowired
    PosicaoRepository posicaoRepository;

    @Autowired
    PoiRepository poiRepository;

    @Autowired
    PoiConverter poiConverter;

    @Autowired
    PosicaoConverter posicaoConverter;


    // WGS-84 SRID
//    private GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    public List<PosicaoDto> findTodasPosicoesComRaioDoPoiEspecifico(Long poiId) {
        Optional<Poi> poi = poiRepository.findById(poiId);
        if(!poi.isPresent())
            throw new RuntimeException("Recurso não encontrado");

//        Point p = factory.createPoint(new Coordinate(poi.get().getLongitude(), poi.get().getLatitude()));

        List<Posicao> listaPosicoes = posicaoRepository.findAllPosicoesEmCadaPOI(poi.get().getGeom(), poi.get().getRaio());
        return posicaoConverter.convertListEntityToDto(listaPosicoes);
    }

    public List<PoiListPosicaoDto> findTodasPosicoesComRaioDosPois() {
        List<Poi> pois = poiRepository.findAll();
        if(pois.isEmpty())
            throw new NotFoundException("Recurso não encontrado");
        
        List<PoiListPosicaoDto> lista = new ArrayList<PoiListPosicaoDto>();

        for (Poi poi : pois) {
            PoiListPosicaoDto poiListPosicaoDto = new PoiListPosicaoDto();
            poiListPosicaoDto.setId(poi.getId());
            poiListPosicaoDto.setNome(poi.getNome());
            poiListPosicaoDto.setRaio(poi.getRaio());
            poiListPosicaoDto.setGeom(poi.getGeom());
            poiListPosicaoDto.setPosicoes(
                posicaoRepository.findAllPosicoesEmCadaPOI(poi.getGeom(), poi.getRaio())
                        .stream().map(posicao ->  posicaoConverter.convertEntityToDto(posicao))
                    .collect(Collectors.toList()));

            lista.add(poiListPosicaoDto);
        }


        return lista;
    }

    public List<PoiDto> getAll() {
        List<Poi> pois = poiRepository.findAll();
        if(pois.isEmpty())
            throw new NotFoundException("Recurso não encontrado");

        return poiConverter.convertListEntityToDto(pois);
    }

}
