package com.nttdata.projeto.mineducacao.controllers;

import com.nttdata.projeto.mineducacao.dto.DisciplinaResponseDTO;
import com.nttdata.projeto.mineducacao.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    /**
     * Método que retorna uma lista de todas as areas distintas existentes na BD
     * @return retorna lista de Strings,
     * ou retorna uma lista vazia caso não existam disciplinas na BD,
     * e status OK
     */
    @GetMapping("/areas")
    @ResponseBody
    public ResponseEntity<Object> getAllAreas(){
        List<String> listDistinctAreas = disciplinaService.getAllDistinctAreas();
        return new ResponseEntity<>(listDistinctAreas, HttpStatus.OK);
    }
    /**
     * Método que retorna uma disciplina pelo título, existente na BD
     * @return retorna disciplina e status OK, se existir, ou status NOT FOUND se não existir
     */
    @GetMapping("/{titulo}")
    @ResponseBody
    public ResponseEntity<Object> getByTitulo(@PathVariable String titulo){
        Optional<DisciplinaResponseDTO> escolaridadeOptional = disciplinaService.getByTitulo(titulo);

        if(escolaridadeOptional.isPresent()){
            return new ResponseEntity<>(escolaridadeOptional, HttpStatus.OK);
        }else return new ResponseEntity<>("A disciplina não existe", HttpStatus.NOT_FOUND);
    }
}
