package br.com.moby7.poi.dto.converter;

import br.com.moby7.poi.domain.Posicao;
import br.com.moby7.poi.dto.PosicaoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PosicaoConverter {

    public PosicaoDto convertEntityToDto(Posicao posicao) {
        ModelMapper modelMapper = new ModelMapper();
        PosicaoDto posicaoDto = modelMapper.map(posicao, PosicaoDto.class);
        return posicaoDto;
    }

    public List<PosicaoDto> convertListEntityToDto(List<Posicao> posicoes) {
        ModelMapper modelMapper = new ModelMapper();
        return posicoes.stream().map(posicao -> modelMapper.map(posicao, PosicaoDto.class))
                .collect(Collectors.toList());
    }

    public Posicao convertDtoToEntity(PosicaoDto posicaoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Posicao posicao = modelMapper.map(posicaoDto, Posicao.class);
        return posicao;
    }
}
