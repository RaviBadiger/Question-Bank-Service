package com.api.questionbank.repository;

import com.api.questionbank.model.Complexity;
import com.api.questionbank.model.TrueFalse;
import com.api.questionbank.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrueFalseRepository extends JpaRepository<TrueFalse, Integer> {

List<Object> findTrueFalseByTypeAndComplexity(Type type, Complexity complexity);
}
