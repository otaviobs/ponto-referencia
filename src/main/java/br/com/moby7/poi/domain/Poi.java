package br.com.moby7.poi.domain;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Poi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private Float latitude;
    private Float longitude;
    private Integer raio;
    private Point geom;
}
