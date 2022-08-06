package br.com.moby7.poi.controller;

import br.com.moby7.poi.dto.PosicaoDto;
import br.com.moby7.poi.service.PosicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posicao")
public class PosicaoController {

    @Autowired
    private PosicaoService posicaoService;

    @GetMapping("/id/{id}")
    public PosicaoDto getPosicaoId(@PathVariable Long id) {
        return posicaoService.getById(id);
    }

    @GetMapping("/all")
    public List<PosicaoDto> getAllPosicoes() {
        return posicaoService.getAll();
    }

    @GetMapping("/coordenadas/{longitude}/{latitude}")
    public List<PosicaoDto> getPosicaoPorCoordenada(@PathVariable Float longitude, @PathVariable Float latitude) {
        return posicaoService.getPosicaoPorCoordenada(longitude, latitude);
    }

}
