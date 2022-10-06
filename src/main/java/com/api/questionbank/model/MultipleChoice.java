package com.api.questionbank.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MultipleChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mcid")
    @SequenceGenerator(name = "mcid",initialValue = 1)
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "optionA",nullable = false)
    private String optionA;

    @Column(name = "optionB",nullable = false)
    private String optionB;

    @Column(name = "optionC",nullable = false)
    private String optionC;

    @Column(name = "optionD",nullable = false)
    private String optionD;

    @Column(name = "answer",length = 1,nullable = false)
    private String answer;

    @Column(name = "complexity", length = 1,nullable = false)
    @Enumerated(EnumType.STRING)
    private Complexity complexity;

    @Column(name = "type",length = 2,nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public MultipleChoice(String question, String optionA, String optionB, String optionC, String optionD, String answer, Complexity complexity, Type type) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.complexity = complexity;
        this.type = type;
    }
}
