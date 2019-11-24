package com.thinh.pham.entrytest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tests_questions")
public class TestQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "questions_id")
    private int question;

    @Column(name = "tests_id")
    private int test;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(name = "test_question_id")
    private List<AnswersSheets> answersSheetsList;

    public TestQuestion() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public List<AnswersSheets> getAnswersSheetsList() {
        return answersSheetsList;
    }

    public void setAnswersSheetsList(List<AnswersSheets> answersSheetsList) {
        this.answersSheetsList = answersSheetsList;
    }

    public void add(AnswersSheets answersSheets) {
        if (answersSheetsList == null) {
            answersSheetsList = new ArrayList<>();
        }

        answersSheetsList.add(answersSheets);
    }

    @Override
    public String toString() {
        return "TestQuestion{" +
                "id=" + id +
                ", question=" + question +
                ", test=" + test +
                ", answersSheetsList=" + answersSheetsList +
                '}';
    }
}
