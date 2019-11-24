package com.thinh.pham.entrytest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answers_sheets")
public class AnswersSheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "point")
    private double point;

    @Column(name = "order_answer")
    private String orderAnswer;

    @Column(name = "selected_answer_id")
    private int selectedAnswerId;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinColumn(name = "test_question_id")
    private TestQuestion testQuestion;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

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

    public AnswersSheets() {

    }

    public AnswersSheets(double point, String orderAnswer, int selectedAnswerId) {
        this.point = point;
        this.orderAnswer = orderAnswer;
        this.selectedAnswerId = selectedAnswerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getOrderAnswer() {
        return orderAnswer;
    }

    public void setOrderAnswer(String orderAnswer) {
        this.orderAnswer = orderAnswer;
    }

    public int getSelectedAnswerId() {
        return selectedAnswerId;
    }

    public void setSelectedAnswerId(int selectedAnswerId) {
        this.selectedAnswerId = selectedAnswerId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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

    @Override
    public String toString() {
        return "AnswersSheets{" +
                "id=" + id +
                ", point=" + point +
                ", orderAnswer='" + orderAnswer + '\'' +
                ", selectedAnswerId=" + selectedAnswerId +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
