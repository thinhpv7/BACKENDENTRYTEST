package com.thinh.pham.entrytest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "test_title", nullable = false)
    private String testTitle;

    @Column(name = "test_time",nullable = false)
    private int testTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "date_time_test", nullable = false)
    private Date dateTimeTest;

    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "tests_questions",
            joinColumns = {@JoinColumn(name = "tests_id")},
            inverseJoinColumns = {@JoinColumn(name = "questions_id")}
    )
    private List<Question> questionList;

    @Column(name = "is_deleted")
    private boolean deleted = false;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @Column(name = "created_by")
    private String createdBy;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "classes_tests",
            joinColumns = @JoinColumn(name = "tests_id"),
            inverseJoinColumns = @JoinColumn(name = "classes_id")
    )
    private Set<Classe> classeSet;

    public Test() {

    }

    public Test(String testTitle, int testTime) {
        this.testTitle = testTitle;
        this.testTime = testTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public int getTestTime() {
        return testTime;
    }

    public void setTestTime(int testTime) {
        this.testTime = testTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Date getDateTimeTest() {
        return dateTimeTest;
    }

    public void setDateTimeTest(Date dateTimeTest) {
        this.dateTimeTest = dateTimeTest;
    }

    public void add(Question question) {
        if (questionList == null) {
            questionList = new ArrayList<>();
        }

        questionList.add(question);
    }

    public Set<Classe> getClasseSet() {
        return classeSet;
    }

    public void setClasseSet(Set<Classe> classeSet) {
        this.classeSet = classeSet;
    }

    public void add(Classe classe) {
        if (classeSet == null) {
            classeSet = new HashSet<>();
        }

        classeSet.add(classe);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", testTitle='" + testTitle + '\'' +
                ", testTime=" + testTime +
                ", dateTimeTest=" + dateTimeTest +
                ", questionList=" + questionList +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", classeSet=" + classeSet +
                '}';
    }
}
