package com.api.questionbank.helper;

import com.api.questionbank.exception.QuestionBankException;
import com.api.questionbank.model.Complexity;
import com.api.questionbank.model.MultipleChoice;
import com.api.questionbank.model.Type;
import org.springframework.stereotype.Component;

@Component
public class QuestionBankHelper {

    public void checkType(String typeRequested, Type typeInBody) {
        switch (typeRequested) {
            case "trueFalse":
                typeInBody.equals(Type.TF);
                break;
            case "multipleChoice":
                typeInBody.equals(Type.MC);
                break;
            case "fillInTheBlank":
                typeInBody.equals(Type.FB);
                break;
            case "mathematics":
                typeInBody.equals(Type.MM);
                break;
            default:
                throw new QuestionBankException("Question type in JSON body is not matching with question type being requested for " + typeInBody);
        }
    }
}
