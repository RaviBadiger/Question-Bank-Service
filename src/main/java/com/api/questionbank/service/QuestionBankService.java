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
        System.out.println(object instanceof  MultipleChoice);
    }

    public Integer addMultipleChoice(MultipleChoice multipleChoice) {
        if(!(multipleChoice.getType().equals(Type.MC))){
            throw new QuestionBankException("Question type in JSON body is not matching with question type being requested for ");
        }
        multipleChoiceRepository.save(multipleChoice);
        return  multipleChoice.getId();
    }

    public Integer  addTrueFalse(TrueFalse trueFalse){
        if(!(trueFalse.getType().equals(Type.TF))){
            throw new QuestionBankException("Question type in JSON body is not matching with question type being requested for ");
        }
        trueFalseRepository.save(trueFalse);
        return trueFalse.getId();
    }

    public Integer addFillInTheBlank(FillInTheBlank fillInTheBlank){
        if(!(fillInTheBlank.getAnswer().length()<=10)){
            throw new QuestionBankException("Number of characters in answer exceeds 10 characters");
        }
        if(!(fillInTheBlank.getType().equals(Type.FB))){
            throw new QuestionBankException("Question type in JSON body is not matching with question type being requested for ");
        }
        fillInTheBlankRepository.save(fillInTheBlank);
        return fillInTheBlank.getId();
    }

    public Integer addMathematics(Mathematics mathematics){
        if(!(mathematics.getType().equals(Type.MM))){
            throw new QuestionBankException("Question type in JSON body is not matching with question type being requested for ");
        }
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


