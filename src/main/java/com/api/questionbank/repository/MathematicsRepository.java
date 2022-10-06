package com.api.questionbank.repository;

import com.api.questionbank.model.Complexity;
import com.api.questionbank.model.Mathematics;
import com.api.questionbank.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MathematicsRepository extends JpaRepository<Mathematics, Integer> {

    List<Object> findMathematicsByTypeAndComplexity(Type type, Complexity complexity);
}
