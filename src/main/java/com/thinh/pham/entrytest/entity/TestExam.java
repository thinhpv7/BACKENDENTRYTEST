package com.thinh.pham.entrytest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "test_exams")
public class TestExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datetime_exam")
    private Date dateTimeExam;

    @Column(name = "status_exam")
    private int statusExam = 0;

    @Column(name = "remaining_time")
    private int remainingTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "log_time")
    private Date logTime;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "test_exam_id")
    private List<AnswersSheets> answersSheets;
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="username")
    private User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
    protected void onLog() {
        logTime = new Date();
    }

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    public TestExam() {

    }

    public TestExam(Date dateTimeExam, int statusExam, int remainingTime, Date logTime) {
        this.dateTimeExam = dateTimeExam;
        this.statusExam = statusExam;
        this.remainingTime = remainingTime;
        this.logTime = logTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTimeExam() {
        return dateTimeExam;
    }

    public void setDateTimeExam(Date dateTimeExam) {
        this.dateTimeExam = dateTimeExam;
    }

    public int getStatusExam() {
        return statusExam;
    }

    public void setStatusExam(int statusExam) {
        this.statusExam = statusExam;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<AnswersSheets> getAnswersSheets() {
        return answersSheets;
    }

    public void setAnswersSheets(List<AnswersSheets> answersSheets) {
        this.answersSheets = answersSheets;
    }

    @Override
    public String toString() {
        return "TestExam{" +
                "id=" + id +
                ", dateTimeExam=" + dateTimeExam +
                ", statusExam=" + statusExam +
                ", remainingTime=" + remainingTime +
                ", logTime=" + logTime +
                ", answersSheets=" + answersSheets +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
