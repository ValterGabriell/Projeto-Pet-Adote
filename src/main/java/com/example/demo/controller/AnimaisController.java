package com.example.demo.controller;


import com.example.demo.model.AnimaisModelDTO;
import com.example.demo.model.AnimaisModelRequest;
import com.example.demo.model.AnimaisModelResponse;
import com.example.demo.service.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audote/data/animais")
public class AnimaisController {
    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimaisModelResponse> postAnimal(@RequestBody AnimaisModelRequest animaisModelRequest) {
        ModelMapper mapper = new ModelMapper();
        AnimaisModelDTO modelDTO = mapper.map(animaisModelRequest, AnimaisModelDTO.class);
        modelDTO = animalService.adicionarNovoAnimal(modelDTO);
        AnimaisModelResponse modelResponse = mapper.map(modelDTO, AnimaisModelResponse.class);
        return new ResponseEntity<>(modelResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimaisModelResponse> atualizarAnimal(@PathVariable Integer id, @RequestBody AnimaisModelRequest animaisModelRequest) {
        ModelMapper mapper = new ModelMapper();
        AnimaisModelDTO modelDTO = mapper.map(animaisModelRequest, AnimaisModelDTO.class);
        modelDTO = animalService.atualizarAnimal(id, modelDTO);
        AnimaisModelResponse modelResponse = mapper.map(modelDTO, AnimaisModelResponse.class);
        return new ResponseEntity<>(modelResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<AnimaisModelResponse>> deletarAnimal(@PathVariable Integer id) {
        animalService.deletarAniaml(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<AnimaisModelResponse>> obterTodosOsAnimais() {
        ModelMapper mapper = new ModelMapper();
        List<AnimaisModelDTO> modelDTOList = animalService.obterTodosOsAnimais();
        List<AnimaisModelResponse> modelResponseList = modelDTOList.stream().map(
                animais -> mapper.map(animais, AnimaisModelResponse.class)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(modelResponseList, HttpStatus.OK);
    }

    @GetMapping(value = "/{dono}/lista")
    public ResponseEntity<List<AnimaisModelResponse>> obterAnimalPorDono(@PathVariable Integer dono) {
        List<AnimaisModelDTO> animaisModelDTOS = animalService.obterAnimalPorDono(dono);

        ModelMapper mapper = new ModelMapper();
        List<AnimaisModelResponse> animaisModelResponses = animaisModelDTOS.stream().map(
                animais -> mapper.map(animais, AnimaisModelResponse.class)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(animaisModelResponses, HttpStatus.OK);


    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimaisModelResponse> obterAnimalPorId(@PathVariable Integer id) {
        Optional<AnimaisModelDTO> modelDTO = animalService.obterAnimalPorId(id);

        if (modelDTO.isPresent()) {
            return new ResponseEntity<>(
                    new ModelMapper().map(modelDTO.get(), AnimaisModelResponse.class),
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
