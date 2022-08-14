package br.com.moby7.poi.controller;

import br.com.moby7.poi.dto.PosicaoDto;
import br.com.moby7.poi.service.PosicaoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Posicão", description = "Posições dos veículos e a sua situação")
@RestController
@RequestMapping("/posicao")
public class PosicaoController {

    @Autowired
    private PosicaoService posicaoService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todas informações da Posição (conforme o modelo) pelo ID"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado na base de dados"),
    })
    @GetMapping("/id/{id}")
    public PosicaoDto getPosicaoId(@PathVariable Long id) {
        return posicaoService.getById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todas informações das Posições (conforme o modelo)"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado na base de dados"),
    })
    @GetMapping("/all")
    public List<PosicaoDto> getAllPosicoes() {
        return posicaoService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todas informações da Posição (conforme o modelo) pelo longitude e latitude"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado na base de dados"),
    })
    @GetMapping("/coordenadas/{longitude}/{latitude}")
    public List<PosicaoDto> getPosicaoPorCoordenada(@PathVariable Float longitude, @PathVariable Float latitude) {
        return posicaoService.getPosicaoPorCoordenada(longitude, latitude);
    }

}
