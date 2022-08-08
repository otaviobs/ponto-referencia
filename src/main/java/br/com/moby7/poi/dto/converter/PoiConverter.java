package br.com.moby7.poi.dto.converter;

import br.com.moby7.poi.domain.Poi;
import br.com.moby7.poi.dto.PoiDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PoiConverter {

    public PoiDto convertEntityToDto(Poi poi) {
        ModelMapper modelMapper = new ModelMapper();
        PoiDto poiDto = modelMapper.map(poi, PoiDto.class);
        return poiDto;
    }

    public List<PoiDto> convertListEntityToDto(List<Poi> pois) {
        ModelMapper modelMapper = new ModelMapper();
        return pois.stream().map(poi -> modelMapper.map(poi, PoiDto.class))
                .collect(Collectors.toList());
    }

    public Poi convertDtoToEntity(PoiDto poiDto) {
        ModelMapper modelMapper = new ModelMapper();
        Poi poi = modelMapper.map(poiDto, Poi.class);
        return poi;
    }
}
