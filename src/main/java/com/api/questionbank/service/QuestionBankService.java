package com.api.questionbank.service;

import com.api.questionbank.exception.QuestionBankException;
import com.api.questionbank.helper.QuestionBankHelper;
import com.api.questionbank.model.*;
import com.api.questionbank.repository.FillInTheBlankRepository;
import com.api.questionbank.repository.MathematicsRepository;
import com.api.questionbank.repository.MultipleChoiceRepository;
import com.api.questionbank.repository.TrueFalseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class QuestionBankService {

    @Autowired
    private MultipleChoiceRepository multipleChoiceRepository;

    @Autowired
    private TrueFalseRepository trueFalseRepository;

    @Autowired
    private FillInTheBlankRepository fillInTheBlankRepository;

    @Autowired
    private MathematicsRepository mathematicsRepository;

    @Autowired
    private QuestionBankHelper questionBankHelper;

    public List<Object> getQuestions(Type type , Complexity complexity) {
        switch (type){
            case MC :  return multipleChoiceRepository.findMultipleChoicesByTypeAndAndComplexity(type, complexity);
            case TF : return  trueFalseRepository.findTrueFalseByTypeAndComplexity(type, complexity);
            case FB : return fillInTheBlankRepository.findFillInTheBlankByTypeAndComplexity(type, complexity);
            case MM : return  mathematicsRepository.findMathematicsByTypeAndComplexity(type, complexity);
            default: throw new QuestionBankException("Type is incorrect" + type) ;
        }
    }

    public void Test(Object object){

    }

    public Integer addMultipleChoice(MultipleChoice multipleChoice) {
        multipleChoiceRepository.save(multipleChoice);
        return  multipleChoice.getId();
    }

    public Integer  addTrueFalse(TrueFalse trueFalse){
        trueFalseRepository.save(trueFalse);
        return trueFalse.getId();
    }

    public Integer addFillInTheBlank(FillInTheBlank fillInTheBlank){
        fillInTheBlankRepository.save(fillInTheBlank);
        return fillInTheBlank.getId();
    }

    public Integer addMathematics(Mathematics mathematics){
        mathematicsRepository.save(mathematics);
        return mathematics.getId();
    }

    public Integer deleteQuestion(Type type, Integer id){
        switch (type){
            case MC : multipleChoiceRepository.findById(id).
                        orElseThrow(()->new QuestionBankException("Invalid ID " + id));
                        multipleChoiceRepository.deleteById(id);
                        break;
            case TF : trueFalseRepository.findById(id).
                        orElseThrow(()->new QuestionBankException("Invalid ID " + id));
                        trueFalseRepository.deleteById(id);
                        break;
            case FB : fillInTheBlankRepository.findById(id)
                        .orElseThrow(()->new QuestionBankException("Invalid ID " + id));
                        fillInTheBlankRepository.deleteById(id);
                        break;
            case MM : mathematicsRepository.findById(id)
                        .orElseThrow(()->new QuestionBankException("Invalid ID " + id));
                        mathematicsRepository.deleteById(id);
                        break;
        }
        return id;
    }

}


