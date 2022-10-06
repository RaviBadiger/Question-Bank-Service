package com.api.questionbank.helper;

import com.api.questionbank.exception.QuestionBankException;
import com.api.questionbank.model.Complexity;
import com.api.questionbank.model.Type;
import org.springframework.stereotype.Component;

@Component
public class QuestionBankHelper {

    public void checkType(Type type){
        if(!( type.equals(Type.FB) ||
                        type.equals(Type.TF) ||
                            type.equals(Type.MM) ||
                                type.equals(Type.MC) ))  {
            throw new QuestionBankException("Type is incorrect" + type);
        }

    }

    public void checkComplexity(Complexity complexity){
        if( ! ( ( complexity.equals(Complexity.E)||
                        complexity.equals(Complexity.H) ||
                            complexity.equals(Complexity.M) ) ) ){
            throw new QuestionBankException("Invalid Complexity " + complexity);
        }
    }
}
