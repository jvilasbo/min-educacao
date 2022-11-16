package com.nttdata.projeto.mineducacao.controllers;

import com.nttdata.projeto.mineducacao.dto.EscolaridadeResponseDTO;
import com.nttdata.projeto.mineducacao.services.EscolaridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path="/escolaridades")
public class EscolaridadeController {

    @Autowired
    private EscolaridadeService escolaridadeService;


    /**
     * Método que retorna um  EscolaridadeResponseDTO da BD, recebendo por parâmetro uma idade
     * @param idade é um identificador da esoclaridade na BD
     * @return retorna um EscolaridadeResponseDTO (Data Transfer Object de EscolaridadeEntity, criado para ser retornado da BD),
     * ou retorna uma mensagem e status NOT_FOUND não exista na BD
     */

    @GetMapping("/{idade}")
    @ResponseBody
    public ResponseEntity<Object> getByIdade(@PathVariable int idade){
        EscolaridadeResponseDTO escolaridade = escolaridadeService.getByIdade(idade);

        return new ResponseEntity<>(escolaridade, HttpStatus.OK);
    }
}
