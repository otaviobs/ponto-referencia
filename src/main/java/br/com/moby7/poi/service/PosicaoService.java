package br.com.moby7.poi.service;

import br.com.moby7.poi.domain.Posicao;
import br.com.moby7.poi.dto.PosicaoDto;
import br.com.moby7.poi.dto.converter.PosicaoConverter;
import br.com.moby7.poi.exception.NotFoundException;
import br.com.moby7.poi.repository.PosicaoRepository;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PosicaoService {

    @Autowired
    PosicaoRepository posicaoRepository;

    @Autowired
    PosicaoConverter posicaoConverter;

    // WGS-84 SRID
    private GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);
    public PosicaoDto getById(Long id) {
        Optional<Posicao> posicao = posicaoRepository.findById(id);
        if(!posicao.isPresent())
            throw new NotFoundException("Recurso não encontrado");

        /** Convertendo String para LocalDateTime
         * Precisamos remover o conteúdo que está em parenteses
         * Assim podemos criar um Pattern com o DateTimeFormatter para converter a String para a classe de DateTime da nossa escolha
         */
        String dateTeste = posicao.get().getDataPosicao().replaceAll("( \\(.*\\))$", "");
        Locale locale = new Locale("pt", "BR");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
        LocalDateTime dateTime = LocalDateTime.parse(dateTeste, dateTimeFormatter);
        System.out.println("DATETIME: " + dateTime);

        return posicaoConverter.convertEntityToDto(posicao.get());
    }

    public List<PosicaoDto> getAll() {
        List<Posicao> posicoes = posicaoRepository.findAll();
        if(posicoes.isEmpty())
            throw new NotFoundException("Recurso não encontrado");

        return posicaoConverter.convertListEntityToDto(posicoes);
    }

    public List<PosicaoDto> getPosicaoPorCoordenada(Float longitude, Float latitude) {
//        Point point = factory.createPoint(new Coordinate(longitude, latitude));

        List<Posicao> posicoes = posicaoRepository.findByLongitudeAndLatitude(longitude, latitude);
        if(posicoes.isEmpty())
            throw new NotFoundException("Recurso não encontrado");

        return posicaoConverter.convertListEntityToDto(posicoes);
    }
}
