package br.com.moby7.poi.dto;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;

@Data
public class PoiDto {

    private Long id;
    private String nome;
    private Float latitude;
    private Float longitude;
    private Integer raio;
    private Point geom;
}

