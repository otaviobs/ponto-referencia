package br.com.moby7.poi.controller;

import br.com.moby7.poi.dto.PoiDto;
import br.com.moby7.poi.dto.PoiListPosicaoDto;
import br.com.moby7.poi.dto.PosicaoDto;
import br.com.moby7.poi.service.PoiService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Poi", description = "Ponto de refêrencia para verificar se tem algum veículo dentro do raio desse ponto.")
@RestController
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private PoiService poiService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todas informações das Posições de acordo com o ID do Poi"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado na base de dados"),
    })
    @GetMapping("/id/{id}")
    public List<PosicaoDto> getAllPosicaoPorPoiEspecifico(@PathVariable Long id) {

        return poiService.findTodasPosicoesComRaioDoPoiEspecifico(id);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos os Pois e as Posições refêrentes"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado na base de dados"),
    })
    @GetMapping("/all/posicoes")
    public List<PoiListPosicaoDto> findTodasPosicoesComRaioDosPois() {

        return poiService.findTodasPosicoesComRaioDosPois();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos Poi"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado na base de dados"),
    })
    @GetMapping("/all")
    public List<PoiDto> getAll() {

        return poiService.getAll();
    }


}
