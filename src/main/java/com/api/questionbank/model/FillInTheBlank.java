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
public class FillInTheBlank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fid")
    @SequenceGenerator(name = "fid", initialValue = 1)
    private  Integer id;

    @Column(name = "question", nullable = false)
    private  String question;

    @Column(name = "answer", length = 10,nullable = false)
    private String answer;

    @Column(name = "complexity", length = 1,nullable = false)
    @Enumerated(EnumType.STRING)
    private Complexity complexity;

    @Column(name = "type",length = 2,nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public FillInTheBlank(String question, String answer, Complexity complexity, Type type) {
        this.question = question;
        this.answer = answer;
        this.complexity = complexity;
        this.type = type;
    }
}
