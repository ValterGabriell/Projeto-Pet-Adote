package com.example.demo.service;


import com.example.demo.Handler.ResourceNotFound;
import com.example.demo.model.AnimaisModel;
import com.example.demo.model.AnimaisModelDTO;
import com.example.demo.repository.AnimaisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    AnimaisRepository animaisRepository;


    public AnimaisModelDTO adicionarNovoAnimal(AnimaisModelDTO animaisModelDTO) {
        animaisModelDTO.setId(null);
        ModelMapper mapper = new ModelMapper();
        AnimaisModel model = mapper.map(animaisModelDTO, AnimaisModel.class);

        model = animaisRepository.save(model);
        animaisModelDTO.setId(model.getId());
        return animaisModelDTO;
    }

    public AnimaisModelDTO atualizarAnimal(Integer id, AnimaisModelDTO animaisModelDTO) {
        ModelMapper mapper = new ModelMapper();
        animaisModelDTO.setId(id);
        AnimaisModel model = mapper.map(animaisModelDTO, AnimaisModel.class);
        animaisRepository.save(model);
        return animaisModelDTO;
    }

    public void deletarAniaml(Integer id) {
        Optional<AnimaisModel> model = animaisRepository.findById(id);
        if (model.isPresent()) {
            animaisRepository.deleteById(id);
        } else {
            throw new ResourceNotFound("Não foi possivel deletar o usuario");
        }
    }

    public List<AnimaisModelDTO> obterTodosOsAnimais() {
        ModelMapper mapper = new ModelMapper();
        List<AnimaisModel> models = animaisRepository.findAll();
        return models.stream().map(
                animais -> mapper.map(animais, AnimaisModelDTO.class)
        ).collect(Collectors.toList());
    }

    public Optional<AnimaisModelDTO> obterAnimalPorId(Integer id) {
        Optional<AnimaisModel> animaisModel = animaisRepository.findById(id);
        if (animaisModel.isPresent()) {
            return Optional.of(new ModelMapper().map(animaisModel.get(), AnimaisModelDTO.class));
        }

        return Optional.empty();
    }

    public List<AnimaisModelDTO> obterAnimalPorDono(Integer dono) {
        List<AnimaisModel> animaisModels = animaisRepository.findByDono(dono);
        return animaisModels.stream().map(
                animais -> new ModelMapper().map(animais, AnimaisModelDTO.class)).collect(Collectors.toList());
    }




}
