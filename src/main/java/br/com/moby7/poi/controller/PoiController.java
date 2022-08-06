package br.com.moby7.poi.controller;

import br.com.moby7.poi.dto.PoiDto;
import br.com.moby7.poi.dto.PoiListPosicaoDto;
import br.com.moby7.poi.dto.PosicaoDto;
import br.com.moby7.poi.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private PoiService poiService;

    @GetMapping("/id/{id}")
    public List<PosicaoDto> getAllPosicaoPorPoiEspecifico(@PathVariable Long id) {

        return poiService.findTodasPosicoesComRaioDoPoiEspecifico(id);
    }

    @GetMapping("/all/posicoes")
    public List<PoiListPosicaoDto> findTodasPosicoesComRaioDosPois() {

        return poiService.findTodasPosicoesComRaioDosPois();
    }

    @GetMapping("/all")
    public List<PoiDto> getAll() {

        return poiService.getAll();
    }


}
