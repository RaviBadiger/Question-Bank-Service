package com.api.questionbank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TrueFalse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tid")
    @SequenceGenerator(name = "tid",initialValue = 1)
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "optionA", nullable = false)
    private Boolean optionA;

    @Column(name = "optionB", nullable = false)
    private Boolean optionB;

    @Column(name = "answer",length = 1,nullable = false)
    private String answer;

    @Column(name = "complexity", length = 1,nullable = false)
    @Enumerated(EnumType.STRING)
    private Complexity complexity;

    @Column(name = "type",length = 2,nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public TrueFalse(String question, Boolean optionA, Boolean optionB, String answer, Complexity complexity, Type type) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.answer = answer;
        this.complexity = complexity;
        this.type = type;
    }
}
