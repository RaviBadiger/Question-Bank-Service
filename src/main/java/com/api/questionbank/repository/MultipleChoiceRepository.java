package com.api.questionbank.repository;

import com.api.questionbank.model.Complexity;
import com.api.questionbank.model.MultipleChoice;
import com.api.questionbank.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultipleChoiceRepository extends JpaRepository<MultipleChoice, Integer> {

    List<Object> findMultipleChoicesByTypeAndAndComplexity(Type type, Complexity complexity);
}
