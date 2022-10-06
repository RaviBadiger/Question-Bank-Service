package com.api.questionbank.controller;


import com.api.questionbank.model.*;
import com.api.questionbank.service.QuestionBankService;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/bank")
public class QuestionBankController {

    @Autowired
    private QuestionBankService questionBankService;

    @ExceptionHandler({ConversionFailedException.class,IllegalArgumentException.class, JacksonException.class})
    public ResponseEntity<String> ErrorResponse(){
        return new ResponseEntity<String>("Valid Question Types suported are \n 1.MC - Multiple Choice \n 2.MM - Mathetical Questions \n 3.FB - Fill In The Blanks  \n 4.TF - True False Questions" +
                "\n Valid Complexity supported are \n 1. E - Easy \n 2. M - Medium \n 3. H - Hard" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{type}/{complexity}")
    public List<Object> getQuestions(@PathVariable(name = "type") Type type,
                                        @PathVariable(name = "complexity") Complexity complexity)
                                            throws ConversionFailedException,IllegalArgumentException, JacksonException {
        return questionBankService.getQuestions(type, complexity);
    }

    @PostMapping("/MC")
    public ResponseEntity<String> addMultipleChoice(@RequestBody MultipleChoice multipleChoice)
                                                          throws ConversionFailedException,IllegalArgumentException, JacksonException{
       return new ResponseEntity<String>("Added a Multiple Choice question with ID - " +
                                                questionBankService.addMultipleChoice(multipleChoice),HttpStatus.OK);
    }

    @PostMapping("/TF")
    public ResponseEntity addTrueFalse(@RequestBody TrueFalse trueFalse)
                                             throws ConversionFailedException,IllegalArgumentException, JacksonException{
        return new ResponseEntity<String>("Added a True False question with ID - " +
                                                questionBankService.addTrueFalse(trueFalse), HttpStatus.OK);
    }

    @PostMapping("/FB")
    public ResponseEntity addFillInTheBlank(@RequestBody FillInTheBlank fillInTheBlank)
                                                 throws ConversionFailedException,IllegalArgumentException,JacksonException{
        return new ResponseEntity<String>("Added a Fill in the Blank question with ID - " +
                                                questionBankService.addFillInTheBlank(fillInTheBlank), HttpStatus.OK);
    }

    @PostMapping("/MM")
    public ResponseEntity addMathematics(@RequestBody Mathematics mathematics)
                                             throws ConversionFailedException,IllegalArgumentException, JacksonException{
        return new ResponseEntity<String>("Added a Math question with ID - " +
                                                questionBankService.addMathematics(mathematics), HttpStatus.OK);
    }

   /* @PostMapping("/test")
    public  ResponseEntity Test(@RequestBody Object object){
        //questionBankService.Test(object);
        return new ResponseEntity<String>("Hello",HttpStatus.OK);
    }*/

    @DeleteMapping("/{type}/{id}")
    public  ResponseEntity deleteQuestion(@PathVariable(name = "type") Type type,
                                             @PathVariable(name = "id") Integer id )
                                                throws ConversionFailedException,IllegalArgumentException, JacksonException{
        return new ResponseEntity<String>("Deleted question with ID - " +
                                                questionBankService.deleteQuestion(type, id), HttpStatus.OK);
    }

}
