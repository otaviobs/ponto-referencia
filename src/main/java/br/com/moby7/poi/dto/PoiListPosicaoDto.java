package br.com.moby7.poi.dto;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;

import java.util.List;

@Data
public class PoiListPosicaoDto {

    private Long id;
    private String nome;
    private Integer raio;
    private Point geom;
    private List<PosicaoDto> posicoes;
}

