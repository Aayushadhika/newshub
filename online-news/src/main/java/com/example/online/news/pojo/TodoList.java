package com.example.online.news.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todolist")
public class TodoList {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskId")
    private int taskID;

    @Column(name = "taskTitle")
    private String taskTitle;
    @ManyToOne
    @JoinColumn(name = "userDetails")
    private Users userDetails;
    @Column(name = "taskTiming")
    private String taskTiming;
    @Column(name = "taskDescription")
    private String taskDescription;
    @Column(name = "taskImportance")
    private String taskImportance;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public Users getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Users userDetails) {
        this.userDetails = userDetails;
    }

    public String getTaskTiming() {
        return taskTiming;
    }

    public void setTaskTiming(String taskTiming) {
        this.taskTiming = taskTiming;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskImportance() {
        return taskImportance;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskImportance(String taskImportance) {
        this.taskImportance = taskImportance;
    }


}
