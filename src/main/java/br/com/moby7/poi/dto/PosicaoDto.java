package br.com.moby7.poi.dto;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;

@Data
public class PosicaoDto {

    private Long id;
    private String placa;
    private String dataPosicao;
    private Integer velocidade;
    private Float longitude;
    private Float latitude;
    private Point geom;
}
