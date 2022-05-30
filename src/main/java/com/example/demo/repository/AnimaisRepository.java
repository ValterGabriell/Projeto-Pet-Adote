package com.example.demo.repository;


import com.example.demo.model.AnimaisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimaisRepository extends JpaRepository<AnimaisModel, Integer> {
    List<AnimaisModel> findByDono(Integer dono);

}
