package com.api.questionbank.repository;

import com.api.questionbank.model.Complexity;
import com.api.questionbank.model.FillInTheBlank;
import com.api.questionbank.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FillInTheBlankRepository extends JpaRepository<FillInTheBlank,Integer> {

    List<Object> findFillInTheBlankByTypeAndComplexity(Type type, Complexity complexity);
}
