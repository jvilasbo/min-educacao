package com.nttdata.projeto.mineducacao.controllers;

import com.nttdata.projeto.mineducacao.dto.DisciplinaResponseDTO;
import com.nttdata.projeto.mineducacao.dto.EscolaridadeResponseDTO;
import com.nttdata.projeto.mineducacao.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path="/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;


    /**
     * Método que retorna uma lista de todas as disciplinas existentes na BD
     * @return retorna lista de DisciplinasResponseDTO (Data Transfer Object de DisciplinaEntity, criado para ser retornado da BD),
     * ou retorna uma lista vazia caso não existam disciplinas na BD,
     * e status OK
     */

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getAllDisciplinas(){
        List<DisciplinaResponseDTO> listDisciplinasResponseDTO = disciplinaService.getAllDisciplinas();
        return new ResponseEntity<>(listDisciplinasResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/areas")
    @ResponseBody
    public ResponseEntity<Object> getAllAreas(){
        List<String> listDistinctAreas = disciplinaService.getAllDistinctAreas();
        return new ResponseEntity<>(listDistinctAreas, HttpStatus.OK);
    }
 /*   @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> getById(@PathVariable int id){
        DisciplinaEntity d = drep.getReferenceById(id);
        DisciplinaResponseDTO d1 = assembler.toDTO(d);
        return new ResponseEntity<>(d1, HttpStatus.OK);
    }*/

    @GetMapping("/{titulo}")
    @ResponseBody
    public ResponseEntity<Object> getByTitulo(@PathVariable String titulo){
        DisciplinaResponseDTO escolaridade = disciplinaService.getByTitulo(titulo);

        return new ResponseEntity<>(escolaridade, HttpStatus.OK);
    }
}
