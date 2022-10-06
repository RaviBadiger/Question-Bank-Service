package com.api.questionbank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Mathematics {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mid")
    @SequenceGenerator(name = "mid",initialValue = 1)
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer",precision = 10,scale = 5,nullable = false)
    private BigDecimal answer;

    @Column(name = "complexity", length = 1,nullable = false)
    @Enumerated(EnumType.STRING)
    private Complexity complexity;

    @Column(name = "type",length = 2,nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public Mathematics(String question, BigDecimal answer, Complexity complexity, Type type) {
        this.question = question;
        this.answer = answer;
        this.complexity = complexity;
        this.type = type;
    }
}
