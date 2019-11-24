package com.thinh.pham.entrytest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "question_content", columnDefinition = "text")
    private String questionContent;

    @Column(name = "is_shuffle")
    private boolean isShuffle = true;

    @Column(name = "point")
    private double point;

    @Column(name = "difficulty_level")
    private int difficultyLevel = 1;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "question_id")
    private List<QuestionAnswers> questionAnswersList;

    @ManyToOne(
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(name = "part_id")
    private Part part;

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

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(name = "question_types_id")
    private QuestionType questionType;

    public Question() {

    }

    public Question(String questionContent, int parentId, boolean isShuffle, double point, int difficultyLevel) {
        this.questionContent = questionContent;
        this.isShuffle = isShuffle;
        this.point = point;
        this.difficultyLevel = difficultyLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public boolean isShuffle() {
        return isShuffle;
    }

    public void setShuffle(boolean shuffle) {
        isShuffle = shuffle;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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

    public List<QuestionAnswers> getQuestionAnswersList() {
        return questionAnswersList;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setQuestionAnswersList(List<QuestionAnswers> questionAnswersList) {
        this.questionAnswersList = questionAnswersList;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public void add(QuestionAnswers questionAnswers) {
        if (questionAnswersList == null) {
            questionAnswersList = new ArrayList<>();
        }

        questionAnswersList.add(questionAnswers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionContent='" + questionContent + '\'' +
                ", isShuffle=" + isShuffle +
                ", point=" + point +
                ", difficultyLevel=" + difficultyLevel +
                ", questionAnswersList=" + questionAnswersList +
                ", part=" + part +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
